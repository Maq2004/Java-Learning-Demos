package day_16_接口鱼类吃东西;

public class SharkFish extends Fish implements Inductor {

	
	
	public SharkFish(String name ) {
		this.name = name;
		
	}
	
	
	@Override
	public void Inductoring() {
		// TODO 自动生成的方法存根
		System.out.println(this.name + " 在感电中 ");
		
	}

	@Override
	public void swiming() {
		// TODO 自动生成的方法存根
		System.out.println(this.name + " 急速的游泳 ");
		
	}

	@Override
	public void eating() {
		// TODO 自动生成的方法存根
		
		System.out.println(this.name + " 快速的吃东西 ");
		
	}

}
