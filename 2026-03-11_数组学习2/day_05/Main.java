package day_05;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.*;

public class Main {
	
	public static void main(String[] args) {
		
		/*
		 * 
		 * 顺序查找
		 */
		
//		Scanner input = new Scanner(System.in);
//		int data = 0;
//		try {
//			data = input.nextInt();
//			int[] a = new int[] {78,79,87,98,100};
//			
//			System.out.println("要查找的下标是" + MyArrayLinerSearch_02(a,data));
//		}catch(InputMismatchException e) {
//			
//			System.out.println("输入的格式不正确，请输入正整数");
//
//		}finally {
//			input.close();
//			
//			System.out.println("代码结束");
//		}
//	
		
		/*
		 * 二分查找
		 * 小明心里想一个1~100之间的数字，
		 * 小红来猜，小明根据小红的猜测的数字提示“猜大了”、”猜小了“、”猜对了“。
		 * 使用二分法模拟猜数字的过程
		 * 
		 * 
		 */
		
		
		
//		int data = 0;
//		Scanner input = new Scanner(System.in);
//		
//		data = input.nextInt();
//		
//		int[] a = new int[100];
//		
//		for(int i = 0; i<a.length;i++) {
//			a[i] = i;
//		}
//		
//		int index = MyArrayBinarySearch(a,data);
//		
//		System.out.println("下标是"+index);
		/*内存模型：程序的“后台管理” 

		栈 (Stack) ：
		形状：像一个细长的桶（后进先出）。
		
		职责：存放局部变量和引用地址（即指向堆内存的“指针”或“遥控器”）。
		
		特点：运行速度快，方法执行完自动释放。
		
		堆 (Heap) ：
		
		形状：像一个巨大的仓库。
		
		职责：存放所有 new 出来的实体（如数组 int[] a = new int[5]）。
		
		特点：空间大，由垃圾回收器（GC）负责清理。
		
		2. 一维数组查找算法：逻辑对比 
		
		线性查找 (Linear Search)：
		
		逻辑：从头到尾挨个比对。
		
		改进点：找到目标后应立即使用 return 或 break 结束，避免无效运行。
		
		二分查找 (Binary Search)：
		
		前提：数组必须是有序的。
		
		避坑：
		循环条件：必须是 while (left <= right)，否则会漏掉最后一个数的判断,在极端情况（左右边界值）下，两个指示器是有可能相等的
		
		指针挪动：left = mid + 1 或 right = mid - 1，这是为了打破取整带来的“原地踏步”，防止死循环。
		
		计算溢出：在大数据量下，建议用 mid = left + (right - left) / 2。
		 */
		
		/*
		 * 
		 * 
		 * 二维数组学习
		 * 输入一个正整数，输出一个n*n的回型方阵
		 * 
		 * 当n等于5时
		 * 思路：
		 * 将这个方阵分为四个部分，分别是在左上角，右上角，左下角，右下角
		 * 将左上角的小方阵按规律放置好
		 * 规律是；左上角里的数据总是当前坐标[i][j]。i,中较小的那个数字
		 *                                             i  j     i  n+1-j
		 * 然后按照对称性：由于已经把左上角的小方阵排出，按照a[1][1]和a[1][5],对应
		 * 因为是左右对称的原因，所以i不会动
		 * 那么上下对称则是j不会动，对角线对称就是i，j一起动。
		 * 
		 * 其中注意的有一点，就是回型方阵在二维数组中打印，那么放回型方阵的数组要比回型方阵大至少一圈
		 *  !!但是这并不是必须的，因为我的下标是从1 开始的，所以需要多一圈的
		 * ，但是如果将所有的数对其，那么这一圈可以省略!!
		 * 
		 * 
		 * 还有一点就是，放左上角方阵的时候，i，j的次数问题，因为至少大了一圈，所以i要从1开始。到（n+1）/2
		 * 结束，（n+1）/2是奇数回型方阵和偶数回型方阵通用的
		 * 
		 * 假设有一个回型方阵的大小是5*5，那么将他分成四个部分，左上角部分的i，j占这个回型方阵的一半，也就是n的一半，
		 * 但是由于 n是奇数，n/2 = 2 ； 但其实应该是3 ，所以给n+1再除以2
		 * 
		 * 偶数会不会受到影响呢？不会。假设有一个8*8的回型方阵，同样分为左上，右上，左下，右下四个部分
		 * 那么左上部分的大小 m*m（4*4）同样是n*n（8*8）的一半，即使是（n+1）/2 等价于9/2结果仍然是4，不影响
		 * 
		 * 
		 * 
		 * a[1][0] a[1][1] a[1][2]
		 * a[2][0] a[2][1] a[2][2] 
		 * a[3][0] a[3][1] a[3][2] 
		 * 
		 * 
		 * 		1 2 3 4 5 
		 * 
		 * 
		 * 1	1 1 1 1 1 
		 * 2	1 2 2 2 1
		 * 3	1 2 3 2 1
		 * 4	1 2 2 2 1
		 * 5	1 1 1 1 1
		 * 
		 * 
		 * 
		 * 第一版，
		 * 问题之一就是我为了方便观察而将坐标进行了偏移，由初始下标0改成了初始下标1
		 * 问题之二就是我将放回型的数组代码写死，只能写十以内的回型方阵
		 * 
		 * 
		 */
		
	
//		Scanner input = new Scanner(System.in);
//		int[][] arr = new int[10][10];
//		int n = input.nextInt();
//	
//		
//		for(int  i= 1;i<=(n+1)/2;i++) {
//			for( int j = 1; j<=(n+1)/2 ; j++) {
//				arr[i][j] = Math.min(i, j);
//				arr[i][n+1-j] = arr[i][j];
//				arr[n+1-i][n+1-j] = arr[i][j];
//				arr[n+1-i][j] = arr[i][j];
//			}
//		}
//		
//		
//		
//		for(int  i= 1;i<=n;i++) {
//			for( int j = 1; j<=n ; j++) {
//				
//				System.out.print(arr[i][j]+" ");
//				
//			}
//			System.out.println(" ");
//		}
//		
		
		
		/*
		 * 
		 * 回型数组第二版，这一版我将数字对其到所有的数组格中
		 * 
		 * 并且将对称的公式从第一版的(n+1)/2改成了(n-1)/2,在某一行中，j的对称即零和四，一和三，二和二，他们相加等于四，于是让n-1得出四再减去j得出对称
		 * 		 0 1 2 3 4
		 * 
		 *	 0	 1 1 1 1 1 
		 * 	 1	 1 2 2 2 1
		 *	 2	 1 2 3 2 1
		 * 	 3	 1 2 2 2 1
		 * 	 4	 1 1 1 1 1
		 * 
		 * 
		 * 为什么第一版代码切换到第二版时，会出现一圈 0？
		 * 
		 * 
		 */
		
		Scanner input = new Scanner(System.in);
		int[][] arr;
		int n = 0;
		
		try {
			n = input.nextInt();
			arr = new int[n][n];
			
			for(int  i= 0;i<(n+1)/2;i++) {
				for( int j = 0; j<(n+1)/2 ; j++) {
					arr[i][j] = Math.min(i, j);
					arr[i][n-1-j] = arr[i][j];
					arr[n-1-i][n-1-j] = arr[i][j];
					arr[n-1-i][j] = arr[i][j];
				}
			}
			for(int  i= 0;i<n;i++) {
				for( int j = 0; j<n ; j++) {
					//打印反向回型阵
					//System.out.print((n+1)/2 -arr[i][j] + "  ");
					System.out.print(arr[i][j] + "  ");
					
				}
				System.out.println(" ");
			}
		}catch( InputMismatchException e ) {
			System.out.println("请输入正整数");
			
		}catch( ArrayIndexOutOfBoundsException e ) {
			System.out.println("数组下标越界");
			
		}finally {
			System.out.println("代码结束");
		}
		
		/*
		 * 
		 * 反向回型阵
		 * 
		 * 当n=5时
		 * 		1 2 3 4 5
		 * 						 0 1 2
		 * 1	3 3 3 3 3  0 	 3 3 3
		   2	3 2 2 2 3  1  	 3 2 2
		   3	3 2 1 2 3  2	 3 2 1	
		   4	3 2 2 2 3 
		   5 	3 3 3 3 3
		   
		   
		   当n = 6 的时候
		   
		   	3 3 3 3 3 3 
			3 2 2 2 2 3 
			3 2 1 1 2 3 
			3 2 1 1 2 3 
			3 2 2 2 2 3 
			3 3 3 3 3 3	   
		   最大值是多少？在正向阵里，数值是增长的；
		   但在反向阵里，你需要知道“最高点”在哪。
		   观察 n=5（奇数），中心值是 1，最外层是 3。
		   观察 n=6（偶数），中心值是 1，最外层也是 3。
		   思考： 这个“最大值”和 n 之间有什么数学关系？（提示：看看 n=5 时，(n+1)/2 是多少？）
		   
		   当n=5的时候，最外面的一圈，也就是最大值为3
		   当n = 6 的时候， 最外面的值仍然为3
		   因为（n+1）/2这个代码机制，奇数和偶数的最高点是一样的
		   
		   还有个发现，最外层的数值最大，而最中心永远是第 1 层
		   第一层，是最大值-0
		   第二层，是最大值-1
		   第三层，是最大值-2
		   刚好对应i，j中较小的那个值
		   找出最小的那个值，然后用最大值减去它，就是当前层数的值
		   如果我们在 (0, 0)，距离边缘最近是 0步  最外圈。
		   如果我们在 (1, 2)，距离边缘最近是 1步（往上走）往里数第 1 圈。
		   
		   
		 * 
		 */
//		Scanner input = new Scanner(System.in);
//	
//		int n = input.nextInt();
//
//		int[][] arr = new int[n][n];
//		
//		for(int  i= 0;i<(n+1)/2;i++) {
//			for( int j = 0; j<(n+1)/2 ; j++) {
//				
//				int value =  (n+1)/2- Math.min(i, j);
//				
//				arr[i][j] =value;
//				arr[i][n-1-j] = value;
//				arr[n-1-i][n-1-j] = value;
//				arr[n-1-i][j] = value;
//
//			}
//			
//		}
//		
//		
//		
//		for(int  i= 0;i<n;i++) {
//			for( int j = 0; j<n ; j++) {
//				
//				System.out.print(arr[i][j]+" ");
//				
//			}
//			System.out.println(" ");
//		}
//		
//		
		
		
	}
	/*
	 * 第一版，能用但是不够简洁
	 * 
	 */

//	public static intMyArrayLinerSearch(int[] a, int data) {
//		
//		boolean flag = false;
//		int index = -1;
//		
//		
//		for(int i = 0; i<a.length;i++) {
//			if(a[i] == data ) {
//				index = i;
//				flag = true;
//				break;
//			}
//			
//		}
//		
//		if(flag) {
//			return index;
//			
//		}else {
//			return -1;
//		}
//
//	}
	
	/*
	 * 第二版
	 */
	
	public static int MyArrayLinerSearch_02(int[] a, int data) {

		for(int i = 0; i<a.length;i++) {
			if(a[i] == data ) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * 二分查找
	 */
	
	public static int MyArrayBinarySearch(int[] a , int data) {
		
		int LeftIndex = 0;
		int RightIndex = a.length-1;
		int MidIndex = (LeftIndex+RightIndex)/2;
		
		
		
		while(LeftIndex <= RightIndex) {
			
			MidIndex = (LeftIndex+RightIndex)/2;
			
			if(data < a[MidIndex]) {
				RightIndex = MidIndex-1;
				
			}else if(data > a[MidIndex]) {
				LeftIndex = MidIndex+1;			
				
			}else if (data == a[MidIndex]) {
				
				return MidIndex;

			}
	
		}
		return -1;

	}

}
