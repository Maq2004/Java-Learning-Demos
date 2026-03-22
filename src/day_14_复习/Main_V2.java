package day_14_复习;

import java.util.Random;
import java.util.Scanner;

public class Main_V2 {
	
	public static void main( String[] args ) {
		
		Random r = new Random();
		
		
		
		System.out.println("请初始化英雄,Name,Hp,Attack,Speed");
		
		Scanner input = new Scanner(System.in);
		
		String name = input.next();
		int hp = input.nextInt();
		int attack = input.nextInt();
		int speed = input.nextInt();
		
		Character_V2 hero = new Character_V2(name,hp,attack,speed);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");

		System.out.println("请初始化怪兽,Name,Hp,Attack,Speed");
		
		
		 name = input.next();
		 hp = input.nextInt();
		 attack = input.nextInt();
		 speed = input.nextInt();
		
		Character_V2 monster = new Character_V2(name,hp,attack,speed);
		
		boolean falg = true;
		
		int i = 0;
		while( true ) {
			i++;
			System.out.println("--------第"+i+"回合--------");
			
			if( hero.getSpeed()+r.nextInt(5) >= monster.getSpeed()+r.nextInt(5) ) {
				
				hero.attack(monster);
				hero.isAlive();
				falg = monster.isAlive();
				
				if( falg != true) {
					
					System.out.println(hero.getName()+"获胜");
					break;
					
					
				}
				
			}else {
				
				monster.attack(hero);
				
				falg = hero.isAlive();
				monster.isAlive();
				if( falg != true) {
					
					System.out.println(monster.getName()+"获胜");
					break;
					
				}
				
			}
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			
		}
		
		
		
		
		
		
		
		
		
	}

}
