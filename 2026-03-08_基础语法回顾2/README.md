# 2026-03-08 基础语法回顾2

今天是Java基础回顾 + 异常实战 + MySQL入门的第一天，感觉迈出了很扎实的一步。

1. Java部分收获
- 面向对象入门：写了Car和Dog类，理解了类是模板、对象是实例；属性/方法定义 + 简单调用（sayhello、shouw）
- 内存模型深度复盘（最爽的部分）：  
  - 数组“双标”：基本类型存值，引用类型存地址  
  - 空指针真相：new UserInfo[50] 只买了50个空柜子，没盖房子  
  - 引用拷贝本质：复制门牌号，不是搬房子（一房多钥联动）  
  - 栈帧临时工：register方法里的temp一结束就销毁，靠数组长寿命牵着对象  
  - 静态 vs 实例：推荐静态工具类，职责清晰不乱内存  
  - GC手动触发：把所有引用线剪掉，对象成孤岛被回收  
- 成绩计算拆方法：getsum + getavg，跨类静态调用，理解了static方法直接类名点


2. 异常实战突破
- 写了7–8个经典场景：除零、输入字母、数组越界、空指针、NumberFormat、ClassCast  
- 多catch顺序：InputMismatch → Arithmetic → Exception兜底，顺序对头  
- finally每次都加“代码结束”，理解了它强制执行的作用  
- 自定义异常雏形（AgeException），throw + catch + getMessage  
- 明白了throw是真扔炸弹，throws是提前说“我这可能有炸弹”

3. MySQL入门
- 建库school + students表（带CHECK、ENUM、TIMESTAMP、COMMENT）  
- INSERT 5条数据 + 3种查询（全表、条件排序、COUNT/AVG）  
- 脚本规范：IF NOT EXISTS、DROP IF EXISTS、utf8mb4、ENGINE=InnoDB  
- 已经push到Mysql_Learning_Demos仓库

