package day_13_SayHello;

public class Chinese extends People {
	
	
	public Chinese() {
	
	}
	
	public Chinese( String name ) {
			this.Nation = "中国";
			this.name = name;
			
	}

	@Override
	public void sayHello() {
		// TODO 自动生成的方法存根
		System.out.println("你好");

		
	}

}
