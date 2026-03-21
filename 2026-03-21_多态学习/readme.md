Java 多态与 instanceof 学习笔记

什么是多态
核心概念：同一个行为，不同对象表现出来不同的形态。
前提条件：
  必须有继承关系（如 Chinese 继承 People）。
  必须有方法重写（子类重写父类方法，如 sayHello）。
  必须使用父类引用指向子类对象（如 People p = new Chinese();）。

多态的表现
编译看左边：编译时检查父类是否有该方法，没有则报错。
运行看右边：运行时执行的是子类重写后的具体逻辑。
例子：
  定义 People p = new Chinese();
  调用 p.sayHello() 时，实际执行的是 Chinese 类中的 sayHello 方法，而不是 People 的。
  同理，new SouthKorea() 或 new TheUS() 传入同一个接收 People 类型参数的方法时，会各自执行自己国家的问候逻辑。

instanceof 关键字
作用：判断一个对象是否属于某个特定的类（或其子类）。
语法：对象 instanceof 类名，返回 true 或 false。
使用场景：
  在进行向下转型（强制类型转换）之前，必须先判断，防止报错。
  例子：
        if (p instanceof Chinese) {
        Chinese c = (Chinese) p; // 安全转换
        c.sing(); // 调用子类特有方法
    }
    
注意：如果对象是 null，instanceof 永远返回 false。

总结
多态让代码更灵活，可以用父类类型统一管理所有子类对象。
想要调用子类特有的方法（如 Chinese 的唱歌，TheUS 的特有行为），需要先通过 instanceof 判断，再强制转换。
记住口诀：编译看父类，运行看子类；转型先判断，安全不报错。