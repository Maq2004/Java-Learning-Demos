//package day_14_复习;
//
//import java.util.Random;
//
//public class Main_V1 {
//	
//	public static void main( String[] args ) {
//		
//		Random r = new Random();// 先手
//		
//		
//		String heroName = "Link";
//		int heroAttack = 10;
//		int heroHp = 100;
//		int heroSpeed = r.nextInt(5);
//		
//		
//		String monsterName = "Goblin";
//		int monsterAttack = 5;
//		int monsterHp = 120;
//		int monsterSpeed = r.nextInt(5);
//		
//		int Round = 0;
//		
//		System.out.println("战斗开始!");
//		
//		while( true ) {
//			Round++;
//			System.out.println("-----第"+Round+"回合开始!-----");
//			heroSpeed = r.nextInt(5);
//			monsterSpeed = r.nextInt(5);
//			
//			if( heroSpeed >= monsterSpeed ) {
//				
//				System.out.println(heroName+"发动了攻击,攻击对象"+monsterName);
//				
//				monsterHp -= heroAttack;
//				
//				System.out.println(heroName+"剩余血量:"+heroHp);
//			
//				
//				
//				if( monsterHp <= 0  ) {
//					System.out.println(monsterName+"剩余血量:0");
//
//					
//					System.out.println(heroName+"胜利");
//					break;
//					
//				}
//				System.out.println(monsterName+"剩余血量:"+monsterHp);
//				
//				
//				
//			}else {
//				System.out.println(monsterName+"发动了攻击,攻击对象"+heroName);
//								
//				heroHp-= monsterAttack ;
//			 
//				System.out.println(monsterName+"剩余血量:"+monsterHp);
//		
//				
//				if( heroHp <= 0  ) {
//					System.out.println(heroName+"剩余血量:0");
//
//					
//					System.out.println(monsterName+"胜利");
//					
//					break;
//					
//				}
//				System.out.println(heroName+"剩余血量:"+heroHp);
//				
//			}
//			
//			System.out.println(" ");
//			System.out.println(" ");
//			System.out.println(" ");
//			System.out.println(" ");
//			
//			
//			
//		}
//		
//		
//	}
//	
//
//}
