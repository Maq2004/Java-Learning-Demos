package day02_1;

public class Calculate_grades {
	
	public static int getsum(int math , int chinese,int english) {
		
		
		return math+chinese+english;
		
	}
	
	public static int getavg(int math , int chinese,int english) {
		
		
		return getsum(math,chinese,english)/3;
		
		
	}
	//两个方法在不同的类当中，需要一个实例化的对象来引用
	//两个方法在同一个类大国中，可以直接调动
}
