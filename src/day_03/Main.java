//package day_03;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class Main {
//	
//	public static void main(String[] args) {
//		
//		
//		Scanner input = new Scanner(System.in);
//		
//	
//		
//		try {
//			int num1 = input.nextInt();
//			int num2 = input.nextInt();
//			int num3 = num1/num2;
//			System.out.println(num3);
//
//		

//		}catch( InputMismatchException e) {
//			System.out.println("除数和被除数都必须是整数");
//			
//		}catch( ArithmeticException e) {
//			
//			System.out.println("除数不能为零");
//
//		}catch(Exception e) {
//			System.out.println("程序出现状况外异常");
//		1、多个catch块组成，而且是从子类写到父类，最后用Exception进行收尾。
//		2、多路异常捕获机制开发中用的比较多，必须掌握。
//		}
//		finally {
//			
//			System.out.println("程序结束");
//
//		}
//		
//		
//		
//		
//	}
//
//}




/*
 * 提示输入1-7之间的任意数组，程序将输出相应的星期名称，
 * 如果输入不是数字给出提示，如果输入的是1-7之外的数字，提示无对应数据
 * 
 * 
 * 
 * 
 */

//package day_03;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class Main {
//	
//	public static void main(String[] args) {
//		
//		Scanner input = new Scanner(System.in);
//		int num = 0;
//		
//		try {
//			 num = input.nextInt();
//			
//		}catch(InputMismatchException e) {
//			
//			System.out.print("输入的不是数字");
//			return;
//			
//			
//		}
//		 switch(num) {
//			case 1:
//			case 2:
//			case 3:
//			case 4:
//			case 5:
//			case 6:
//			case 7:
//				System.out.print("输入合规");
//				break;
//			default:
//				System.out.print("无对应数据");
//		 }
//		
//
//		
//		
//	}
//
//}
/*
 * 
 * 核心问题：异常捕获后程序会停止吗？
解答： 不会。在 Java 中，如果 catch 成功捕获了异常并执行完毕（且没有在 catch 内部写 return 或再次 throw），程序会继续向下运行。

现象： 代码在报错后依然执行了 switch，是因为 catch 处理完后，控制权交回了主流程。

注意： 只有当异常未被捕获，或者你在 catch 里主动执行了中断指令（如 return）时，后面的代码才会被跳过。

二、 加不加 finally 的本质区别
解答： 区别不在于变量数值，而在于执行的“强制性”。

执行保障： 如果你在 try 或 catch 块里写了 return（结束方法），不加 finally 的代码会失效；而 finally 块里的内容会在方法彻底返回前“强行”执行。

清理现场： finally 主要用于关闭那些“借来”的资源（如 Scanner、文件流、数据库连接）。

三、 如何判断写 finally 是否“无伤大雅”？
解答： 可以通过以下三个维度快速评估：

看对象： 如果是 int、String、List 等内存变量，不写无所谓；如果是 文件、网络连接、数据库、Scanner 等外部资源，必须关闭。

看状态： 如果操作是成对出现的（比如：加锁/解锁、显示加载中/隐藏加载中），必须在 finally 里确保“闭环”。

看路径： 如果你的 catch 块里有 return、throw 或 break，那么必须把收尾逻辑写在 finally 里，否则它会被直接跳过
 * 
 * 
 * 
*/


/*
 * 异常分为两大类：检查异常：必须处理的异常 和 运行异常：代码跑起来的时候才出现的异常
 * 
 * 
 * 检查异常是指：这个操作可能会出现问题，必须提前想好对策，不然编译不通过，
 * 比如读写一个文件，那这个文件有没有可能不存在？不存在的时候怎么办？IOException
 * 比如数据库操作异常		SQLException
 * 比如找不到类 		 	ClassNotFoundException
 * 
 * 运行异常：通常是由逻辑错误和代码缺陷引起的
 * 
 * 常见的
 * 空指针		NullPointException
 * 数组越界		ArrayIndexOutOfBoundsException
 * 除0异常		ArithmeticException
 * 类型转换异常	CalssCastException
 * 	对于非受检异常：重点应放在代码规范上。比如在操作数组前检查长度，在操作对象前判断非空，而不是到处写 try-catch。
 *
 *	对于受检异常：这通常是 Java 在提醒你“这里可能会出问题，请给出备用方案”。例如：如果文件打不开，你是要提示用户重新选择路径，还是记录日志？必须写出try-catch
 * 
 */



//package day_03;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//
//public class Main {
//	
//	public static void calc(int a , int b ) throws InputMismatchException,ArithmeticException,Exception {
//		/*throws:
//		 * 当一个方法有异常的时候，我可以将异常上报给方法的调用方。
//		 * 也就是是我告诉别人这里面可能有问题，你得有处理方法再用，但是也可能没问题
//		 * 可以声明多个异常，每个异常之间用逗号分割。
//		 * 
//		 * throw:
//		 * 用于抛出异常而不是上报异常，这说明，异常真的出来了，真真切切的出现了异常
//		 * 
//		 * throw 和 throws 可以配合使用
//		 */
//		if( b == 0) {
//			throw new ArithmeticException("除数不能为0");
//			
//		}
//		
//		System.out.println("结果是:"+a/b);
//		
//		
//		
//	}
//	
//	public static void main(String[] args) {
//		
//
//		try {
//			calc(5,1);
//		} catch (Exception e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();// 包含异常的类型，异常的文字信息，英文信息，引发错误的代码的行号，看着吓人
//			e.getMessage();//只是打印异常信息的字符串，看着不吓人
//			
//			System.out.print("除数不能为0");
//			
//		}
//		
//		
//	}
//
//}
//

/*
 * 
package day_03;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		int age = input.nextInt();
	
		
		try {
			if(age<0) {
				
				throw new AgeException("年龄出错");
				
			}else {
				System.out.println("年龄是"+age);
			}
			
		}catch(AgeException ex){
			System.out.print(ex.getMessage());
		}finally {
			System.out.print("代码结束");
		}
		
	}

}

*/









package day_03;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		
		try {
		int age = input.nextInt();
		int age1 = input.nextInt();
		
		System.out.println(age/age1);
		
		}catch(InputMismatchException e) {
			
			System.out.println("不要输入小数");
			
		}catch(ArithmeticException e) {
			
			System.out.println("除0错误");
			
		}catch(Exception e) {
			
			System.out.println("程序未知错误");
			
		}finally {
			
			System.out.println("程序结束");
			
		}
		
		
	}

}







































