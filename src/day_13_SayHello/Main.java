package day_13_SayHello;

public class Main {
	
	public static void main(String[] args ) {
		
		People chinese = new Chinese( "李白" );
		People TheUS = new TheUS( "JIM" );
		People SouthKorea = new SouthKorea( "车银优" );
		
		
		SayHello sayhello = new SayHello();
		
		
		sayhello.sayHello(chinese);
		sayhello.sayHello(TheUS);
		sayhello.sayHello(SouthKorea);
		
		
		People[] person = new People[3];
		person[0] = chinese;
		person[1] = TheUS;
		person[2] = SouthKorea;
		
		// 多态的目的，统一调用
		for( People p : person ) {
			p.sayHello();
			
		}

		
		
	}
	

}
