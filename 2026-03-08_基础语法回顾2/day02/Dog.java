package day02;

public class Dog {

		String name;
		//局部变量，在方法中定义的变量，随着方法结束而销毁，无法被其他方法所得到
		
		//全局变量：类中定义的变量称为全局变量，它不被任何一个方法包含，所有方法都可以共享（读取值）
		//如果全局变量的类型为整形，系统会默认全局变量的初始值为0
		int age;
		
		public void sayhello() {
			System.out.println("大家好，我的名字是"+name+",今年"+age+"岁了");
			
			
		}
		
}
