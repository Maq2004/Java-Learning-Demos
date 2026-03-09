package day02_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	    public static void main(String[] args) {
//	        // 场景 A
//	        int[] arr = new int[3]; 
//	        arr[10] = 1; // 👈 这里会发生什么？
//	        

//	        // 场景 B
//	        String s = null; 
//	        System.out.println(s.length()); // 👈 这里又会发生什么？
	    	
	    	
//	    	try {
//	    		int num = 10 / 0;
//	    	}catch(ArithmeticException e) {
//	    		System.out.println("⚠️ 错误提示：数学老师说除数不能为 0 哟！");
//	    	}
//
//	            String input = "abc";
//
//	            try {
//	                // 1. 请在这里调用 Integer.parseInt(input) 并赋值给一个 int 变量
//	                
//	            	Integer.parseInt(input);
//	            	
//	            } catch (  NumberFormatException e) { // 2. 请在这里填写正确的异常类型
//	                // 3. 请在这里写一句你喜欢的错误提示
//	                System.out.println("出错了！");
//	            }
//
//	            System.out.println("程序顺利结束！");
	    
	    	
//	    	Scanner sc = new Scanner(System.in);
//	        
//	        try {
//	            System.out.println("请输入一个整数除数：");
//	            int num = sc.nextInt(); // 风险点 1：可能输入字母
//	            int result = 100 / num; // 风险点 2：可能输入 0
//	            System.out.println("结果是：" + result);
//	            
//	        } catch (InputMismatchException e) {
//	            System.out.println("⚠️ 错误：必须输入整数，不能输入字母！");
//	            
//	        } catch (ArithmeticException e) { // 练习 1：请填入处理“除以 0”的异常名
//	            System.out.println("⚠️ 错误：数学老师说不能除以 0！");
//	            
//	        } catch (Exception e) { // 练习 2：请填入那个“兜底”的父类异常名
//	            System.out.println("⚠️ 发生了未知的神秘错误...");
//	        }
//	        
//	        System.out.println("🛡️ 无论是否报错，程序都安全着陆了。");
	    	
	    	
	    	
	    	
//	    	try {
//	    		Scanner input =new Scanner(System.in);
//	    		int number = input.nextInt();
//	    	}catch( InputMismatchException e  ) {
//	    		
//	    		System.out.println("不要输入字母");
//	    		
//	    		
//	    	}finally {
//	    		System.out.print("代码结束");
//	    	}
	    	
	    	
//	    	try {
//	    		int[] arr = new int[3];
//	    		arr[10] = 1;
//	    		
//	    	}catch( ArrayIndexOutOfBoundsException e) {
//	    		
//	    		System.out.println("警告数组越界");
//	    		
//	    	}finally {
//	    		
//	    		
//	    		System.out.println("代码结束");
//	    	}
	  
	    	
	    	
//	    	try {
//	    		
//	    		int num = 10;
//	    		Scanner input = new Scanner(System.in);
//	    		int num1 = input.nextInt();
//	    		
//	    		int num2 = num/num1;
//	    	}catch( ArithmeticException e ) {
//	    		
//	    		System.out.println("除数不能为0");
//	    	}finally {
//	    		System.out.println("代码结束");
//	    	}
//	   
	    	


//	    try {
//    		
//    		String s = null;
//    	int num = 	s.length();
//    		
//    		
//    		
//    	}catch( NullPointerException e ) {
//    		
//    		System.out.println("空指针异常");
//    	}finally {
//    		System.out.println("代码结束");
//    	}
	    	
	    	


//	    try {
//    			
//	    	int num = Integer.parseInt("abc");
//	    	
//
//    	}catch( NumberFormatException e ) {
//    		
//    		System.out.println("格式转换异常");
//    	}finally {
//    		System.out.println("代码结束");
//    	}
//	    	
	    	
	    	
	    	

	    	
	    	
		    try {
			
		    	Object obj = "我是一个字符串"; //
		    	Integer num = (Integer) obj; // 
		    	
    	

		    }catch( ClassCastException e ) {
		
		    	System.out.println("类转换异常");
		    }finally {
		    	System.out.println("代码结束");
	}
	    
	    }
}
