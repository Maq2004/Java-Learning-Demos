package day_18_勇者斗恶龙;

import java.util.*;

import java.io.*;


public class Main_V3 {
	
	public static void main(String[] args) throws IOException, GodError {
		
		
		File file = new File("battle_log.txt");
		
		PrintWriter writer = new PrintWriter(file);
		
		/*
		 * 初始化怪物和英雄
		 */
		FightAble hero = null;
		FightAble monster = null;
		
		Scanner input = new Scanner(System.in);
		System.out.println("请初始化英雄姓名，血量，攻击力，速度");
		
		
		String name = input.next();
		double Hp = 0.0;
		while(true) {
			try {
				Hp = input.nextDouble();
				
				if( Hp <= 0 ) {
					System.out.println("请重新输入，Hp不能小于等于0");
					continue;
				}
				break;
			}catch( InputMismatchException e ) {
				
				System.out.println("请输入数字");
				input.next(); // 错误的输入并不会消失，而是会一直留在缓存区，不写这一行代码会死循环，和c语言中的getchar一样
			}catch( Exception e ) {
				System.out.println(e.getMessage());
			}
		}
		
		
		double attack = 0.0;
		
		while(true) {
			try {
				attack = input.nextDouble();
				if( attack <= 0 ) {
					System.out.println("请重新输入，Hp不能小于等于0");
					continue;
				}
				break;
				
			}catch( InputMismatchException e ) {
				
				System.out.println("请输入数字");
				input.next();
			}catch( Exception e ) {
				System.out.println(e.getMessage());
			}
		}
		
		
		int speed  = 0;
		
		while(true) {
			try {
				speed = input.nextInt();
				
				if( speed <= 0 ) {
					System.out.println("请重新输入，Hp不能小于等于0");
					continue;
				}
				break;
				
			}catch( InputMismatchException e ) {
				
				System.out.println("请输入数字");
				input.next();
			}catch( Exception e ) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("请选择英雄的职业");
		System.out.println("1. 战士");
		System.out.println("2.  弓箭手");
		
		
		int num = input.nextInt();
		boolean flag = false;
		while( !flag ) {
		
			switch( num ) {
				case 1 :
					hero = new Warrior( name,Hp,attack,speed );
					flag = true;
					break;
				case 2:
					hero = new Archer(name,Hp,attack,speed);
					flag = true;
					break;
					
					
				default :
					System.out.println("输入有误,请重新输入");
					num = input.nextInt();
					break;
			}
		}
		
		
		System.out.println("请初始化怪兽姓名，血量，攻击力，速度");
		
		name = input.next();
		while(true) {
			try {
				Hp = input.nextDouble();
				
				if( Hp <= 0 ) {
					System.out.println("请重新输入，Hp不能小于等于0");
					continue;
				}
				
				
				
				break;
			}catch( InputMismatchException e ) {
				
				System.out.println("请输入数字");
				input.next();
			}catch( Exception e ) {
				System.out.println(e.getMessage());
			}
		}
		while(true) {
			try {
				attack = input.nextDouble();
				
				if( attack  <= 0 ) {
					System.out.println("请重新输入，Hp不能小于等于0");
					continue;
				}
				
				
				
				break;
			}catch( InputMismatchException e ) {
				
				System.out.println("请输入数字");
				input.next();
			}catch( Exception e ) {
				System.out.println(e.getMessage());
			}
		}
		
		while(true) {
			try {
				speed = input.nextInt();
				
				
				if( speed <= 0 ) {
					System.out.println("请重新输入，Hp不能小于等于0");
					continue;
				}
				
				
				
				break;
			}catch( InputMismatchException e ) {
				
				System.out.println("请输入数字");
				input.next();
			}catch( Exception e ) {
				System.out.println(e.getMessage());
			}
		}
		try {
		
		monster = new Monster(name,Hp,attack,speed);
		}catch (GodError e ) {
			
			System.out.println("创建失败，原因:" + e.getMessage());
			writer.println("游戏结束");
			writer.println("英雄: " + hero.getName());
			writer.println("剩余血量: " + hero.getHp());
			writer.println("怪物: God");
			writer.println("怪物剩余血量: ???");
			writer.println("结果: God胜利");
			
			
			return ;
			
		} 
		
		
		
		//==========================================================================
		
		
		System.out.println(  hero.getName()+"在密林里遇见了"+monster.getName()+"!");
		System.out.println("见面三秒开始战斗!");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		int i = 0;
	
		while(   hero.getHp() > 0 &&monster.getHp() > 0  ) {
			i++;
			System.out.println(  hero.getName() + "剩余血量: " + hero.getHp());
			System.out.println(  monster.getName() + "剩余血量: " + monster.getHp());
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("===================第"+i+"回合===================");
			nextTurn( (FightAble)hero,(FightAble)monster );
		}
		
		
		if( hero.getHp() <= 0 ) {
			System.out.println("胜者:"+monster.getName());
			
		}else {
			System.out.println("胜者:"+hero.getName());
		}
		
		System.out.println( "战斗结束，正在保存存档" );
		
		try {
		
		 writer = new PrintWriter(file);
		
		
		writer.println("=== 战斗结束报告 ===");
		writer.println("英雄: " + hero.getName());
		writer.println("剩余血量: " + hero.getHp());
		writer.println("怪物: " + monster.getName());
		writer.println("怪物剩余血量: " + monster.getHp());
		writer.println("结果: " + (hero.getHp() > 0 ? "英雄胜利" : "怪物胜利"));
		
		writer.close();

		System.out.println("保存成功！请查看项目根目录下的 battle_log.txt");
		}catch ( IOException e ) {
			System.out.println("写入磁盘错误，请检查权限");
			
		}
		
		
		
	}
	
	
	
	
	
	
	public static void nextTurn( FightAble p1,FightAble p2 ) {
		
			 Random r = new Random();
			 int player1 =  p1.getSpeed() + r.nextInt(3);
			 int player2 =  p2.getSpeed() + r.nextInt(3);
			 
			 if(player1 > player2 ) {
				 // p1攻击p2
				 System.out.println(p1.getName()+"攻击了"+p2.getName());
				 p1.performAttack(p2);
				 if(p2.getHp() <= 0) {
					 System.out.println(p2.getName()+"攻击了"+p1.getName());
					 p2.performAttack(p1);
				 }
				 
			 }else {
				 
				 System.out.println(p2.getName()+"攻击了"+p1.getName());
				 p2.performAttack(p1);
				 if(p1.getHp() <= 0) {
					 System.out.println(p1.getName()+"攻击了"+p2.getName());
					 p1.performAttack(p2);
				 }

			 }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
