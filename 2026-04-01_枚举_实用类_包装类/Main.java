package day_24;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;
public class Main {
	public static void main( String[] args ) {
		
		/*
		  
		 
//		数组和Integer都是对象类型，它们的变量存储的都是引用（地址）。当我用 b = a 赋值时，两个变量都指向同一个对象。但为什么：
//		数组：修改 a[0] 后，b[0] 也跟着改变
//		Integer：修改 a = 200 后，b 却保持不变
//		明明都是'指向同一个地址'，为什么行为完全不同
		
		//因为 在赋值阶段，数组a,b和Integer c,d是一样的。a,b保存的是同一个地址。c,d仍然是保存的同一个地址
		// 但是在修改截断，数组a,b直接循着地址去修改堆中的值，而Integer则是重建一个新的对象（隐式），然后存储新的地址。自然a，b会变。c，d不会变。
		

		// 创建数组对象
        int[] arr1 = new int[]{1, 2, 3};
        // arr1 存储的是数组对象的引用（地址）
        
        int[] arr2 = arr1;  // 复制引用，arr2和arr1指向同一个数组
        System.out.println("赋值后：");
        System.out.println("arr1地址: " + arr1);  // 例如：[I@1b6d3586
        System.out.println("arr2地址: " + arr2);  // 相同：[I@1b6d3586
        
        arr1[0] = 999;  //  通过引用修改数组内部数据
        System.out.println("修改arr1[0]后：");
        System.out.println("arr1[0] = " + arr1[0]);  // 999
        System.out.println("arr2[0] = " + arr2[0]);  // 999 跟着变
        
        // ============================================
        
        System.out.println("\n=== 包装类（不可变对象）===");
        
        // 创建Integer对象
        Integer num1 = new Integer(100);
        // num1 存储的是Integer对象的引用（地址）
        
        Integer num2 = num1;  // 复制引用，num2和num1指向同一个对象
        System.out.println("赋值后：");
        System.out.println("num1地址: " + System.identityHashCode(num1));
        System.out.println("num2地址: " + System.identityHashCode(num2));  // 相同
        
        // 这里不是"修改"，而是"重新赋值"
        num1 = 200;  // 创建新的Integer对象，num1指向新对象
        System.out.println("num1 = 200 后：");
        System.out.println("num1地址: " + System.identityHashCode(num1));  // 不同
        System.out.println("num2地址: " + System.identityHashCode(num2));  // 不变
        
        System.out.println("num1 = " + num1);  // 200
        System.out.println("num2 = " + num2);  // 100,没有改变
		
		
		*/
		
		
		//==========================================
		
		/*
		  为什么我们需要包装类？
		  因为在使用泛型的集合中，不允许存放基本数据类型，这个时候使用包装类可以将基本数据放进去
		  
		  
		  那么不使用泛型的集合能否直接放入基本数据类型？
		  答案是看似可以，实则不行。比如
		 		ArrayList list = new ArrayList(); 
	 	 	   	表面上看是添加了基本类型，实际上发生了自动装箱，
	 	 		list.add(100);     //实际上是 Integer.valueOf(100)
		 		list.add(3.14);   	// 		 Double.valueOf(3.14)
		 		list.add(true);     // 		 Boolean.valuesOf(true)
		 
		  		System.out.println(list.get(0).getClass());  // 查看类型
		 */
		
		
		//包装类的自动拆箱装箱和手动拆箱装箱。
//		
//		
//		Integer num = Integer.valueOf(124); // 手动装箱
//		int num1 = num.intValue(); // 手动拆箱
//		
//		
//		num1 = num; // 自动拆箱
//		Integer num3 = num1; //自动装箱
//
//		
//		
		
		//==========================================
		
		
		
/*
 *  实用类
 *  

		// Math类示例
		double result1 = Math.sqrt(16); // 4.0  开方
		double result2 = Math.pow(2, 3); // 8.0 平方
		int result3 = Math.max(5, 10); // 10 返回最大值

		// String类示例
		String str = "Hello World";
		int len = str.length(); // 11 长度
		boolean isEqual = str.equals("hello world"); // false 比较字符串内容
		boolean isIgnoreCase = str.equalsIgnoreCase("hello world"); // true  忽略大小写比较字符串内容
		String lower = str.toLowerCase(); // "hello world" 字符串转小写
		String upper = str.toUpperCase(); // "HELLO WORLD" 字符串转大写
		String concatStr = str.concat("!"); // "Hello World!" 字符串拼接
		int index = str.indexOf("World"); // 6 返回子串第一次出现的下标
		int lastIndex = str.lastIndexOf("o"); // 7 返回子串最后一次出现的下标
		String sub1 = str.substring(6); // "World" 裁剪字符串，从6开始到结束
		String sub2 = str.substring(0, 5); // "Hello" 裁剪字符串从0开始到五结束
		String trimmed = "  Hello  ".trim(); // "Hello" 去掉字符串前后的空格
		String replaced = str.replace('l', 'x'); // "Hexxo Worxd" 替换字符串中的字符
		String[] parts = str.split(" "); // ["Hello", "World"] 分割字符串

		// StringBuffer示例 
		// 可变字符串，适合大量字符串拼接操作，效率高于 String
		// 常用方法：append() 追加，insert() 插入
		StringBuffer sb = new StringBuffer();
		sb.append("北京");
		sb.append("天津");
		sb.insert(2, "上海");
		System.out.println(sb.toString()); // 北京上海天津

		// 随机数示例
		
		Random random = new Random(); // 如果给的种子相同，即使新实例一个对象，得到的随机书仍然相同
		int randomNumber = random.nextInt(100) + 1; // 1~100之间的随机数

		// 日期示例
		
		Date currentDate = new Date();

		*/
		
		
		
		//=====================================
		
		// 从键盘录入一个字符串，统计该字符串中的大写，小写，数字字符
		
		Scanner input =  new Scanner(System.in);
		String str = input.next();
		
		int smallint = 0;
		int bigint = 0;
		int number = 0;
		
		for( char item : str.toCharArray() ) {
			
			if( item >= 'a' && item <= 'z' ) {
				
				smallint++;
				
			}
			if (item >= 'A' && item <= 'Z') {
				
				bigint++;
				
			}
			if ( item >= '0' && item <= '9' ) {
				
				
				number++;
				
			}else {
				
			}
		}
		
		System.out.print( bigint+"  "+ smallint + "  "+number );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
