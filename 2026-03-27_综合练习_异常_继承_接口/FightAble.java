package day_18_勇者斗恶龙;

public interface FightAble {
	
	void performAttack(FightAble target); // 用来执行攻击动作
	
	
	
	String getJob(); // 用来获取职业
	String getName();
	double getHp(); // 获取血量
	int getSpeed();
	
	
	
	void takeDamage( double damage );
	
	

}
