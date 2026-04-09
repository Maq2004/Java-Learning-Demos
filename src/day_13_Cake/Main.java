package day_13_Cake;

import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("ÇëÊäÈëµ°¸âÃû³Æ");
		String name = input.next();
		System.out.println("ÇëÑ¡Ôñ³ß´ç");
		System.out.println("1.Áù´ç");
		System.out.println("2.°Ë´ç");
		System.out.println("3.Ê®´ç");
		int size = input.nextInt();
		boolean falg = true;
		
		while(falg) {
			
			switch(size) {
			case 1:
				size = 6;
				falg = false;
				break;
			case 2:
				size = 8;
				falg = false;
				break;
			case 3:
				size = 10;
				falg = false;
				break;
			default:
				System.out.println("Ñ¡Ôñ´íÎó,ÇëÖØĞÂÊäÈë");
				size = input.nextInt();
			}
		}
		
		
		Cake cake = CakeRoom.BakeCake(name, size);
		
		cake.gitCake();
		
		input.close();
		
		
		
		
	}
	

}
