package day_14_复习;

import java.util.Random;

public class Character_V2 {
	private String Name;
	private int Attack;
	private int Hp;
	private int Speed;
	
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	
	
	public int getAttack() {
		return Attack;
	}
	public void setAttack(int attack) {
		if(attack <= 0 )
			this.Attack = 1;
		else
			this.Attack = attack;
		
	}
	
	public int getHp() {
		return Hp;
	}
	public void setHp(int hp) {
		if(hp <= 0 )
			this.Hp = 1;
		else
			this.Hp = hp;
	}
	
	
	public int getSpeed() {
		return Speed;
	}
	public void setSpeed(int speed) {
		
		if( speed <= 0 ) {
			this.Speed = 1;
		}else {
			this.Speed = speed;
		}
		

		
		
	}
	
	
	public Character_V2( String name,int Hp,int Attack,int Speed ) {
		
		
		setName(name);
		setHp(Hp);
		setAttack(Attack);
		setSpeed(Speed);
	}
	
	public  void attack(Character_V2 target  ) {
		
		// I 来攻击 target
		System.out.println(this.getName()+"攻击"+target.Name);
		target.Hp -= this.Attack;
		
		
	}
	
	public  boolean isAlive() {
		
		if( this.Hp <= 0 ) {
			System.out.println(this.Name+"当前血量为:0");
			return false;
			
		}else {
			System.out.println(this.Name+"当前血量为:"+this.Hp);
			return true;
		}
	}
	
	

}
