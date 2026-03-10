package day_04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		/*
		 * 数据类型[] 数组名 = new 数据类型[大小]
		 * 数组的命名规则和变量名相同，遵循标识符命名规则
		 * 下标从零开始
		 * 
		 * 
		 */
		/*
		 * new int[]{1,2,3}匿名数组，
		 */
//		int[] arr = new int[3];
//		arr= new int[]{1,2,3,5,6};
//		
//		int[] arrb = arr;
//		arrb[4] = 8;
//		System.out.println(arr[4]);
		
		
		/*
		 * 
		 * 
		 * 动态赋值
		 * 
		 * int[] a = new int[10];
		
			for(int i = 0;i<a.length;i++) {
				a[i] = i;
			
			
				}
			for(int i = 0;i<a.length;i++) {
				System.out.println(a[i]);
			
			}
		 */
		
		/*
		 * 
		 * 数组求最值
		 * 
		 */
		
//		int[] a = new int[5];
//		Scanner input = new Scanner(System.in);
//		
//		for(int i = 0; i< a.length;i++) {
//			a[i] = input.nextInt();
//			
//		}
//		int max = a[0];
//		
//		for(int i = 0; i<a.length;i++) {
//			
//			if(a[i]>max) {
//				
//				max =a[i];
//				
//			}
//		}
//		System.out.println(max);
		
		/*
		 * 
		 * 求最小值
		 */
//		int[] a = new int[5];
//		Scanner input = new Scanner(System.in);
//		
//		for(int i = 0; i< a.length;i++) {
//			a[i] = input.nextInt();
//			
//		}
//		int min = a[0];
//		
//		for(int i = 0; i<a.length;i++) {
//			
//			if(a[i]<min) {
//				
//				min =a[i];
//				
//			}
//		}
//		System.out.println(min);
		
		
		/*
		 * 数组排序
		 * 
		 */
		
		
//		
//		int[] a = new int[5];
//		Scanner input = new Scanner(System.in);
//		
//		for(int i = 0; i< a.length;i++) {
//			a[i] = input.nextInt();
//			
//		}
//		
//		Arrays.sort(a);
//		
//		for(int i = 0; i< a.length;i++) {
//			System.out.print(" " + a[i]);
//			
//		}
//		
		
		/*
		陶陶家的院子里有一棵苹果树，每到秋天树上就会结出 10 个苹果。
		苹果成熟的时候，陶陶就会跑去摘苹果。陶陶有一张 30 厘米高的板凳，
		当她不能直接用手摘到苹果的时候，就会踩到板凳上再试试。
		现在已知 10 个苹果到地面的高度，以及陶陶把手伸直的时候能够达到的最大高度，
		请帮陶陶算一下她能够摘到的苹果的数目。假设她碰到苹果，苹果就会掉下来。
		 */
//		int[] a = new int[10];
//		int count = 0;
//	
//		Scanner input = new Scanner(System.in);
//		System.out.print("请输入涛涛的身高");
//		int High = input.nextInt();
//		
//		System.out.print("请输入苹果的高度");
//		for(int i = 0; i< a.length;i++) {
//			a[i] = input.nextInt();
//		}
//		
//		
//		
//		for(int i = 0; i< a.length;i++) {
//			if(High+30>a[i]) {
//				count++;
//
//			}
//		}
//	
//		System.out.print(count);
//		
		
		/*
		 * 插入元素
		 * 插入一个元素，需要先找到插入的位置(假设下标为index)，
		 * 将这个元素及其之后的所有元素依次往后移一位(注意要从后往前进行操作)
		 * ，再将给定的元素插入(覆盖)到位置 index。
			有一个升序排序的成绩数组，
			其中成绩值为78,87,95,98,100。
			增加一个学生的成绩，插入数组中后，
			保证数组元素依然升序排列。

		 * 
		 */
		
		//89                 1  2  3
//		int[] a = new int[] {78,87,95,98,100};
//		Scanner input = new Scanner(System.in);
//		int data = 0;
//		
//		try {
//			data = input.nextInt();
//		}catch( InputMismatchException e ) {
//			System.out.println("请输入整数");
//			
//		}
//		
//		
//		a = MyArrayListAdd_05(a,data);
//		
//		for(int i = 0; i< a.length;i++) {
//	
//			System.out.println(a[i]);
//
//		}
		
		
		/*
		 * 
		 * 删除元素
		 */
		
		int[] a = new int[] {78,87,95,98,100};
		Scanner input = new Scanner(System.in);
		int index = 1;
		
		a = MyArrayListDelect_03(a,index);
		
		for(int i = 0; i< a.length;i++) {
	
			System.out.println(a[i]);

		}
		
		
		
		
		
		
		
		
		
	}
	/*
	 * 不够优雅，人家给的是升序数组，我却需要手动输入index位置
	 */
//	public static int[] MyArrayList(int[] a ,int index,int data) {
//		
//		int[] temp = new int[a.length+1];
//		
//		for(int i = 0; i<index;i++) {
//			temp[i] = a[i];
//		}
//		
//		temp[index] = data;
//		
//		try {
//			for(int i = index+1; i<temp.length;i++) {
//				temp[i] = a[i-1];
//			}
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("数组越界异常");
//		}
//		
//		a = temp;
//		return a;
//		
//		
//	}
	
	/*
	 * 第二版	仍然不够优雅，居然有if补丁
	 * 
	 */
	
//		public static int[] MyArrayList_02(int[] a ,int data) {
//		
//		int[] temp = new int[a.length+1];
//		int i = 0;
//		try {
//			for( i = 0; i < a.length;i++ ) {
//				
//				if(a[i]<data) {
//					temp[i] = a[i];
//				}else {
//					temp[i] = data;
//					break;
//				}
//			}
//			
//			for(int j = i; j < a.length;j++ ) {
//				temp[j+1] = a[j];
//			}
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.print("数组又又又越界了");
//		}
//		
//		if(temp[temp.length-1] == 0) {
//			temp[temp.length-1] = data;
//		}
//		
//		a = temp;
//		return a;
//	
//	
//}
	/*
	 * 
	 * 第三版  仍然带着分支补丁
	 */
	
	
//		public static int[] MyArrayList_03(int[] a ,int data) {
//		
//		int[] temp = new int[a.length+1];
//		int i = 0;
//		try {
//			for( i = 0; i < a.length;i++ ) {
//				if(a[i]<data) {
//					temp[i] = a[i];
//				}else {
//					temp[i] = data;
//					break;
//				}
//			}
//			
//			if(i != a.length) {
//				for(int j = i; j < a.length;j++ ) {
//					temp[j+1] = a[j];
//				}
//			}else {
//				temp[temp.length-1] = data;
//			}
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.print("数组又又又越界了");
//		}
//		
//		
//		a = temp;
//		return a;
//	
//	
//	}
	
	/*
	 * 
	 * 第四版
	 * 这样写即使data是最大的一位，即因为i<a.length不符合条件后退出来，
	 * 那么下面也仍然会赋值给temp最后一位，
	 * 并且不会进入第二个while，
	 * 因为第二个while的条件就是i<a.length,
	 * 如果是因为a[i]<data退出第一个while那就更好了，
	 * 第二个会给他走完
	 * 
	 * 
	 * 但是有很大的bug，是因为无论 a[i] < data 是否成立，都会进入while，这代表
	 * i 都会一直加下去，直到跳出 while(i < a.length)
	 * 这样根本起不到定位的作用，当a[i] 大于 data 后，代表已经应该在当前位置插入data了，我们应该干什么？跳出整个while循环，但是他这里会继续进入while循环，
	 * while循环的条件是i<a.length
	 * 
	 * while的任务是如果在a.length的范围内并且a[i]小于data，就把它搬进去，但是我设置的while条件只满足了a.length即在范围内，
	 * 并没有限制大小，所有即使data大于了a[i],仍然会进入while循环，
	 * 哪怕是我在里面设置了if，但是这并不能阻止i++的发生
	 * 
	 * 1. 逻辑错位
			第一个循环的目标是“定位”，
			但由于 i++ 放在了判断逻辑之外，
			导致它变成了“全量扫描”。
			即使找到了插入点，i 也会因为惯性直接冲到数组尽头。
	
		2. 连锁反应
			因为 i 冲到了头，导致：
	
			temp[i] = data 永远只能插在最后一位。
	
			第二个 while 循环因为 i < a.length 瞬间失效，
			原本应该往后挪的那些“大数”（如 95, 98, 100）全部被遗忘在旧数组里，没有搬进新家。
	
		3. 核心教训
			循环的“进入条件”和“自增条件”必须高度统一。
			 如果你想让循环在满足某个数值关系时停止，
			 那个关系就必须写在 while 的括号里，或者用 break 强行刹车。
			 否则，i++ 就是一辆没有刹车的赛车。
		 * 
	 * 
	 * 
	 */

	
//		public static int[] MyArrayList_04(int[] a ,int data) {
//			
//		int[] temp = new int[a.length+1];
//		int i = 0;
//		try {
//			while(i<a.length) {
//				if(i<a.length && a[i]<data) {
//					temp[i] = a[i];	
//				}
//				i++;
//			}
//			temp[i] = data;
//			
//			while(i<a.length ){
//				
//				temp[i+1] = a[i];
//				i++;
//			}
//			
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.print("数组又又又越界了");
//		}
//		
//		
//		a = temp;
//		return a;
//	
//	
//	}
	
	/*
	 * 插入元素
	 * 第五版 消灭掉了所有不必要的IF，从逻辑层面上剔除了数组越界的空间
	 */
	
	
		public static int[] MyArrayListAdd_05(int[] a ,int data) {
			
		int[] temp = new int[a.length+1];
		int i = 0;
		try {
			while(i<a.length && a[i]<data) {
					temp[i] = a[i];
					i++;
			}
			
			temp[i] = data;
			
			while(i<a.length ){
				
				temp[i+1] = a[i];
				i++;
			}
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("数组又又又越界了");
		}
		
		
		a = temp;
		return a;


		}
		/*
		 * 
		 * 数组删除一个元素
		 */
		
//		public static int[] MyArrayListDelect(int[] a ,int index) {
//			int i = 0;
//				
//		
//			for(i = index-1 ; i <a.length-1; i++) {
//				
//				a[i] = a[i+1];
//	
//			}
//			
//			a[a.length-1] = 0;
//			
//			return a;
//
//
//			}
//		
		
		/*
		 * 第二版， 完美，应该...但是while条件判断有点生硬
		 * 
		 */
		
		
//		public static int[] MyArrayListDelect_02(int[] a ,int index) {
//			int i = 0;
//			int[] temp = new int[a.length-1];
//			
//			
//			
//			
//			while(i<temp.length && i != index-1 ) {
//					temp[i] = a[i];
//					i++;
//			}
//			
//			
//			while(i<temp.length ){
//				
//				temp[i] = a[i+1];
//				i++;
//			}
//			
//			
//
//			return temp;
//
//
//			}
//	
//		

		public static int[] MyArrayListDelect_03(int[] a ,int index) {
			int i = 0;
			int[] temp = new int[a.length-1];
		
			while(i<index-1) {
				temp[i] = a[i];
				i++;
				}
		
		
				while(i<temp.length ){
					
					temp[i] = a[i+1];
					i++;
				}
			
			

			return temp;


			}
	
}
