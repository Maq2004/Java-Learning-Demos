package test01;

import java.util.Scanner;

public class day01 {

	public static void main(String args[]) {
		
//		System.out.print("Hello World ");
//		
//		int num = 20;
//		int price = 15;
//		System.out.print(num*price+"元");
//		

		
		
		//标识符只能包括数字 字母 下划线，并且开头只剩是字母或者下划线
		//在同一作用域内，标识符不能重复定义
		//区分大小写
		
//		String brand = "华为MateBook14s";
//		double size = 14.2;
//		int ram = 16;
//		int price = 6899;
//		
//		System.out.println("brand:"+brand);
//		System.out.println("size:"+size);
//		System.out.println("ram:"+ram);
//		System.out.println("price:"+price);
		
		
		// /除 
		// %取余
		
//		
//		int num1 = 5; 
//		int num2 = 2; 
//		int a = num1 % num2;
//		int b = num1 / num2;
//		System.out.println(num1 + " % " + num2 + "= " + a);
//		System.out.println(num1 + " / " + num2 + " = " + b);
		
		
		//已知圆的半径是1.5，求周长和面积
		
//		double pi  = 3.14;
//		double r = 1.5;
//		System.out.println("圆的周长是:"+ String.format("%.1f",2*pi*r));
//		System.out.println("圆的面积是:" + String.format("%.1f",r*pi*r));
//		
		
		//保留小数位数
		//String result=String.format("%.1f","要保留的小数的变量");
		
		
		
	// 类型转换
		//自动类型转换： 类型相容 ， 目标类型精度大于原本的类型精度,如果目标精度比原本精度小则报错
		//强制类型转换： （类型名称）表达式,可能会丢失精度
		
		
//		double a  = 5.2;
//		int b =(int ) a ;
//		System.out.println(b);
//		
		
		// 小明准备实现一个数字加密器，加密规则是
		// 加密结果 = （整数 * 8 + 3 ） / 2 + 2.6 
		// 加密结构仍为整数
		
//		int num = 2;
//		
//		int mima = (int ) ((num*8+3)/2+2.6);
//		
//		System.out.println(mima);
//	
		
		
//		Scanner input = new Scanner(System.in);
//		int num = input.nextInt(); 
		//标准写法
//		int num=input.nextInt();
		
//		//进行接收字符串
//		String name=input.next();
		
//		//进行接收字符
//		String name=input.next().charAt(0);

		
		
		//已知某班有男学生二十位，女学生十五位，
		//二十位男学生平均分是八十七，十五位女学生的平均分是八十五
		//问全体学生平均分是多少
		
		
//		
//		int man = 20;
//		int female = 15;
//		
//		int manScore = 87;
//		int femaleScore = 85;
//		
//		System.out.println(((man*manScore)+(female*femaleScore))
//				/(man+female));
//		

		//A买来了三十根骨头，第一天吃掉一般后又吃了一根，
		//第二天将剩下的骨头吃了一半后又吃了一根，第三天仍然如此
		//第三天吃完后还剩多少根骨头？
		
//		int bones = 30;
//		int day1 = bones/2 - 1;
//		int day2 = day1 / 2 -1;
//		int day3 = day2 / 2-1;
//		
//		System.out.println("第三天吃完后剩余"+day3);
//		
//		
//		
		//对一个三位数123分离数位
//		int num = 123;
//		int ge = num %10;
//		int shi = num / 10 % 10;
//		int bai = num /100;
//		
//		System.out.println(" "+ge+" "+shi+" "+bai);
//		
//		
		//输入两个整形变量交换两个变量的值
		
//		Scanner input =new Scanner(System.in);
//		int a = input.nextInt();
//		int b = input.nextInt();
//		a = a+b; // 11
//		b = a-b; //11 - 6 
//		a = a-b;
//		System.out.println("a"+a+" b"+b);
//		
		
		
//		//输入一个小写字母，输出其对应的大写字母
//		Scanner input= new Scanner(System.in);
//		char num =input.next().charAt(0) ;
//		System.out.print((char)(num-32));
		//有一个教训，没记住强制类型转换要要带括号
		
		
		
//		Scanner input = new Scanner(System.in);
//		int num = input.nextInt();
//		if(num>98) {
//			System.out.println("得到篮球");
//			
//		}
//		
		
//		Scanner input = new Scanner(System.in);
//		int num = input.nextInt();
//		
//		if(num >200) {
//			System.out.println("做的好");
//		}
//		else {
//			System.out.println("做的不好");
//			
//		}
//		
		
		
//		Scanner input = new Scanner(System.in);
//		int num = input.nextInt();
//		
//		if(num % 2 == 0)
//			System.out.println("even");
//		else
//			System.out.println("odd");
		
		
		//写一个征录系统，输入正确的用户名和密码输出欢迎语句“欢迎你”，否则
		//输出用户名不正确或者密码错误
		
		//java 比较函数 
		
		//equals()（内容是否完全相同，区分大小写）
		//忽略大小写比较：equalsIgnoreCase()
		
		
		
		
//		String name = "maqian";
//		String passwd ="123456";
//		Scanner input = new Scanner(System.in);
//		String enterName = input.next();
//		String enterPasswd = input.next();
//		
//		if((name.equals(enterName) )&& passwd.equals(enterPasswd) ) {
//			System.out.println("欢迎回来");
//		}else if(name.equals(enterName)) {
//			System.out.println("密码错误");
//			
//		}else {
//			System.out.println("账号错误");
//		}
		
//		Scanner input = new Scanner(System.in);
//		int num = input.nextInt();
//		
//		switch(num) {
//			case 1 :
//				System.out.println("红烧肉1");
//				break;
//			case 2 :
//				System.out.println("红烧肉2");
//				break;
//			case 3 :
//				System.out.println("红烧肉3");
//				break;
//			case 4 :
//				System.out.println("红烧肉4");
//				break;
//			case 5 :
//				System.out.println("红烧肉5");
//				break;
//			case 6 :
//				System.out.println("红烧肉6");
//				break;
//			case 7 :
//				System.out.println("红烧肉7");
//				break;
//		}
		
		
		//输入三个数，输出其最大的数
//		Scanner input = new Scanner(System.in);
//		int num1 = input.nextInt();
//		int num2 = input.nextInt();
//		int num3 = input.nextInt();
//		
//		int max = num1;
//		
//		if(num2>max) {
//			max = num2;
//		}
//		if(num3>max)
//			max = num3;
//		
//		System.out.print(max);
		
		//判断某年是否是闰年，如果是闰年输出Y，不是输出N
		Scanner input = new Scanner(System.in);
		int year = input.nextInt();
		
		if((year%4==0 && year %100 != 0) || (year % 400 == 0))
			System.out.println("Y");
		else
			System.out.println("N");
		
		
	}
}
