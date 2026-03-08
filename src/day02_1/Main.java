package day02_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int math = input.nextInt();
		int english = input.nextInt();
		int chinese = input.nextInt();
		System.out.print("平均分成绩 ："+Calculate_grades.getavg(math, chinese, english));
		System.out.print("总成绩 ："+Calculate_grades.getsum(math, chinese, english));
		
		


	}
}
