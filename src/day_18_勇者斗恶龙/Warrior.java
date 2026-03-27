package day_18_勇者斗恶龙;

import java.util.Random;

public class Warrior  extends Character_V3 implements FightAble  {
	
	
	// 获取当前英雄血量
	@Override
	public double getHp() {
		// TODO 自动生成的方法存根
		return this.Hp;
	}
	// 当前英雄受到伤害计算
	@Override
	public void takeDamage(double damage) {
		// TODO 自动生成的方法存根
		
		Random random = new Random();
		double random1 =  random.nextDouble()  ;
		
		if(random1 > 0.7) {
			System.out.println(this.name+"战士韧性！");
			damage = damage - 3;
			
			super.setHp( this.Hp - damage );// 战士减伤
		}else {
			
			super.setHp( this.Hp - damage );
			
			
		}
		
		
		 
		
	}

	// 当前英雄攻击别人伤害计算
	@Override
	public void performAttack(FightAble target) {
		// TODO 自动生成的方法存根

		target.takeDamage(this.Attack * 1);
		
	}
	
	

	// 当前英雄职业
	@Override
	public String getJob() {
		// TODO 自动生成的方法存根
		return "战士";
	}
	
	
	
	
	public Warrior( String name, double Hp, double Attack , int Speed ) {
		
		super.setHp(Hp);
		
		this.name = name;
		
		super.setAttack(Attack);
		
		super.setSpeed(Speed);
		
	}
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public double getAttack() {
		return Attack;
	}



	public int getSpeed() {
		return this.Speed;
	}







	


	
	
	

}
