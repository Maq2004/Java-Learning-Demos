package day_35;

public class MyThread_02 implements Runnable {
	
	public void t1() {
		

			for( int i = 0 ;  i < 10 ; i++) {
			 {				
				System.out.print(Thread.currentThread().getName()+"=");
				
				System.out.print("微");
				System.out.print("冷");
				System.out.print("的");
				System.out.print("雨");
				System.out.println();
			}
				// 由于性能太好，导致线程A输出一条，线程B输出一条的理想输出无法做到，就让抢进来的线程睡1毫秒，让另一个线程来
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
		}
	
	}
	
	public  void t2() {
		for( int i = 0 ;  i < 10 ; i++) {
		 {	
			System.out.print(Thread.currentThread().getName()+"=");
			
			System.out.print("狂");
			System.out.print("热");
			System.out.print("的");
			System.out.print("血");
			System.out.println();
			}
		}
	}
	
	@Override
	public void run() {
		
		t1();
		t2();
		

		
		
	}


}
