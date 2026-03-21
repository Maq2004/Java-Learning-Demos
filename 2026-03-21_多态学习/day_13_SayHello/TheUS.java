package day_13_SayHello;

public class TheUS  extends People{
	
	public TheUS() {
		
	}
	
	public TheUS( String name ) {
			this.Nation = "美国";
			this.name = name;
			
	}

	@Override
	public void sayHello() {
		// TODO 自动生成的方法存根
		
		System.out.println("Hello");
		
	}

}
