package day_18_ÓÂÕß¶·¶ñÁú;

import java.util.Random;

public abstract class Character_V3  {
	String name;
	double Hp;
	double Attack;
	int Speed;
	Random r;
	
	public void setHp( double hp ) {
		
		if( hp <= 0) {
			
			this.Hp = 0;
			
			
		}else {
			this.Hp = hp;
		}
	}
	
	public void setAttack(double attack) {
		if ( attack <= 0  ) {
			this.Attack = 1;
		}
		else {
			this.Attack = attack;
		}
	}
	
	
	public void setSpeed(int speed) {
		if( speed <= 0 ) {
			this.Speed = 1;
		}
		else {
			this.Speed = speed;
		}
	}


}
