package day_08;

import java.util.Scanner;

public class Main {
	public static  void main (String[] args) {
		
//	Movie movie1 = new Movie();
//	movie1.dirctor = "maqian";
//	movie1.name = "zhanlang";
//	
//	String[] initActor = new String[2];
//	initActor[0] = "maqian";
//	initActor[1] = "xiaobai";
//	
//	movie1.initActors(initActor);
//	
//	movie1.show();
//	
//	
//	
//	System.out.println("================================");
//	
//	Movie movie2 = new Movie();
//	movie2.dirctor = "maqian2";
//	movie2.name = "zhanlang2";
//	
//	String[] initActor2 = new String[2];
//	initActor2[0] = "maqian2";
//	initActor2[1] = "xiaobai2";
//	
//	movie2.initActors(initActor2);
//	
//	movie2.show();
		
		BookManager book = new BookManager();
		book.initBook();
		
		menu();
		
		
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		while(num != 0) {
			if(num == 1 ) {
				System.out.println("这里是图书管理列表");
				
				book.BookList();
				menu();
			}else if( num == 2 ) {
				
				System.out.println("这里是添加图书");
				Book book1 = new Book();
				System.out.println("请输入书名");
				book1.name = input.next();
				System.out.println("请输入作者");
				book1.zuozhe = input.next();
				System.out.println("请输入价格");
				book1.price = input.nextInt();
				
				boolean flag = book.BookIn(book1);
				
				if( flag) {
					System.out.println("添加成功");
					
				}else {
					System.out.println("失败");
					
				}
				menu();
			}
			num = input .nextInt();
			
		}
		
		
		
		

		
		
	
	
		
	}
	
	public static void menu() {
		System.out.println("欢迎来到图书馆里系统");
		System.out.println("1.图书列表");
		System.out.println("2.添加图书");
		System.out.println("0.退出系统");
		
	}
	
}
