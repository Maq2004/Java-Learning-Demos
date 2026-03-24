package day_16_接口鱼类吃东西;

public class GoldFish extends Fish {

	public GoldFish(String name ) {
		this.name = name;
		
	}
	
	
	
	@Override
	public void swiming() {
		// TODO 自动生成的方法存根
		System.out.println(this.name+"在欢快的游泳");
		
	}

	@Override
	public void eating() {
		// TODO 自动生成的方法存根
		System.out.println(this.name+"在欢快的吃东西");
		
	}
	
	

}
