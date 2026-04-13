package day_31;

public class MyThread_01 extends Thread{
	
	public synchronized void t1() {
		for( int i = 0 ;  i < 20 ; i++) {
	
			System.out.print(Thread.currentThread().getName()+"=");
			
			System.out.print("Î¢");
			System.out.print("Àä");
			System.out.print("µÄ");
			System.out.print("Óê");
			System.out.println();
		
		}
	}
	
	public synchronized void t2() {
		for( int i = 0 ;  i < 20 ; i++) {
	
			System.out.print(Thread.currentThread().getName()+"=");
			
			System.out.print("¿ñ");
			System.out.print("ÈÈ");
			System.out.print("µÄ");
			System.out.print("Ñª");
			System.out.println();
		
		}
	}
	
	@Override
	public void run() {
		
		t1();
		t2();
		

		
		
	}

}
