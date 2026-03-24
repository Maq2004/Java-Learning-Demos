package day_16_接口鱼类吃东西;

public class Main {
	public static void main( String[] args ) {
		
		
		SharkFish shark = new SharkFish("科比鲨鱼");
		GoldFish goldfish = new GoldFish("唑巴扬金鱼");
		
		shark.Inductoring();
		shark.eating();
		shark.swiming();
		
		goldfish.eating();
		goldfish.swiming();
		/*
		 * 
		Java 接口

		接口是“能力契约”，不是“身份”
		接口不关心你是什么类，只关心你能不能做某件事。
		比如 Flyable 接口只说：“你要会飞”，不管你是鸟、飞机还是超人。

		实现接口 = 承诺提供某些方法
		一个类用 implements 声明实现某个接口，就必须写出接口里所有方法的具体代码。
		这就像签了合同：你说你会飞，那就真得写出 fly() 方法。

		接口让代码更灵活、更容易扩展
		方法参数用接口类型（比如 void draw(Drawable d)），就能接受任何会画图的对象。
		以后加新图形（三角形、星星），不用改这个方法——只要新类实现了 Drawable 就行。

		一个类可以实现多个接口
		Java 不允许多继承（不能 extends 多个类），但可以 implements 很多接口。
		所以你可以让一个对象同时具备多种能力：会飞、会游泳、会唱歌……

		接口本身没有状态，也不能有普通字段
		接口里只能有常量（public static final 的），不能有像 name、age 这样的普通变量。
		它只定义行为，不保存数据。

		接口和抽象类不是对手，是搭档
		抽象类适合表达“是一类东西”（比如动物），还能共享代码。
		接口适合表达“会做什么事”（比如能飞、能跑），强调通用能力。
		很多时候，一个类既继承一个抽象父类，又实现多个接口。

		面向接口编程 = 写更健壮、可维护的代码
		别依赖具体类，依赖接口。
		这样换实现、写测试、加功能都更容易，代码也不容易“牵一发而动全身”。

		✅ 记住一句话：  
		接口不是“你是谁”，而是“你能干啥”。只要能干这事，管你是谁！
		
		*/
		
		
	}

}
