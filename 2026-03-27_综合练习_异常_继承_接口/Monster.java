package day_18_勇者斗恶龙;

import java.util.Random;

public class Monster extends Character_V3 implements FightAble {
	
	//当前英雄攻击别人
		@Override
		public void performAttack(FightAble target) {
			// TODO 自动生成的方法存根
		
			target.takeDamage(this.Attack );
		}
		//当前英雄职业
		@Override
		public String getJob() {
			// TODO 自动生成的方法存根
			return "怪物";
		}
		//当前英雄血量
		@Override
		public double getHp() {
			// TODO 自动生成的方法存根
			return this.Hp;
		}
		//当前英雄受到伤害
		@Override
		public void takeDamage(double damage) {
			// TODO 自动生成的方法存根
			
			Random random = new Random();
			boolean random1 =  random.nextBoolean();
			
			if(random1) {
				damage = 0;
				System.out.println(this.name+"躲过了这一击");
				super.setHp( this.Hp - damage );
				
				
			}else {
				
				super.setHp( this.Hp - damage );
				
			}
			 
			
			
			
		}
		
		
		
		public Monster( String name, double Hp, double Attack , int Speed ) throws GodError {
			
			
		
			
			
			super.setHp(Hp);
			this.name = name;
			
			super.setAttack(Attack);
			
			super.setSpeed(Speed);
			
			if( name.equals("God") ) {
				
				throw new GodError("竟敢挑战神明？");
			}
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
