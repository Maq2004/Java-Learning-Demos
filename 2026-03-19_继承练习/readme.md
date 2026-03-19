当前重点：理解继承的内存布局、同名字段隐藏、super 使用、抽象方法实现

结构
day_11/
├── Main.java               主程序入口，测试多态与继承效果
├── Pet.java                父类：宠物基类（包含私有字段 + getter/setter）
├── Cat.java                子类：猫，继承 Pet，演示同名字段隐藏 + 方法重写
├── Fish.java               抽象类：鱼基类，包含抽象方法 Fishspeed()
├── QiFish.java             子类：旗鱼（快速游泳）
├── BaiFish.java            子类：白鱼（中等速度）
└── FeiFish.java            子类：飞鱼（另一种速度实现）
text## 学习目标与覆盖知识点

1. **继承的基本语法与内存布局**
   - 子类对象内存 = 父类部分 + 子类部分
   - 同名实例字段（field hiding）：两个独立变量，不同步

2. **super 关键字使用**
   - `super(参数)` 调用父类构造（必须在子类构造第一行）
   - 访问父类被隐藏的字段/方法（本例中因 private 无法直接 super.catName）

3. **方法重写 vs 方法重载**
   - Cat.makeSound() 与 Pet.makeSound() 参数相同但未正确重写（实际为重载或未覆盖）
   - 建议统一参数列表并加 `@Override`

4. **抽象类与抽象方法**
   - 抽象类不能实例化
   - 子类必须实现所有抽象方法

5. **多态**
   - 父类/抽象类引用指向子类对象
   - 调用抽象方法时执行子类实现

6. **常见问题**
   - 父类无无参构造 → 子类必须显式 super()
   - private 字段子类无法直接访问
   - 未重写 equals()/toString() → 默认比较引用地址

## 关键代码片段说明

### 1. 同名字段隐藏验证（Cat 与 Pet 都有 catName）

```java
// Pet（父类）有 private String catName
// Cat（子类）有 private String catName ← 独立的两份

this.catName = name;           // 修改子类自己的 catName
// super.catName = ...         // 因 private，无法直接访问父类版本

System.out.println(getCatName());     // 调用 Pet 的 getter → 父类版本
System.out.println(getSubName());     // 调用 Cat 的方法 → 子类版本
2. 抽象类多态示例（Fish 系列）
JavaFish qifish = new QiFish(110);
Fish baifish = new BaiFish(48);

System.out.println(qifish.Fishspeed(3));   // 执行 QiFish 的实现