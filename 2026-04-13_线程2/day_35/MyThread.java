package day_31;

public class MyThread extends Thread {

	// 这个线程要干什么呢？为展示多线程，循环打印当前线程的名字
	@Override
	public void run() {
	
		for( int i = 0 ; i< 10 ; i++) {
			
			System.out.println("当前线程的名称是MyThread :"+Thread.currentThread().getName()+"-"+i);
			
			
		}
	
	}
	
	
}
