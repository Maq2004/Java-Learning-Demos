package day_31;
import java.lang.*;
import java.util.*;
import java.util.concurrent.*;

public class Main {
	public static void main(String[] args) {
		
	/*	
	
 		线程和进程
	
		
		//获取到现在正在进行的线程，因为只有主线程，所以获取到的就是主线程。
		Thread thread = Thread.currentThread();
		System.out.println("当前线程的名称："+thread.getName());
		//修改当前线程的名字
		thread.setName("主线程");
		System.out.println("当前线程的名称："+thread.getName());
		
		
		
		
		System.out.println("=============================");
		
		MyThread myThread = new MyThread();
		MyRunnable myRunnable = new  MyRunnable();
		// Runnable 接口中没有start方法，所以不能直接调用
		//但是Thread类中有一个构造方法可以将Runnable接口的实例放入，利用Thread类的start来启动线程
		Thread threadMyRunnable = new Thread(myRunnable);
		
		myThread.start();
		threadMyRunnable.start();
	
		try {
		myThread.join();
		threadMyRunnable.join();
		}catch( InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("=============================");
		
		*/
		
		/*
		System.out.println("=========线程的同步问题============");
		
		// 创建两个线程，当两个线程时桶同一份资源（实例）的时候，会因为互相抢cpu资源，从而造成打印不成形（资源混乱） !! 但是并没有吞掉数据，每一个字符都被打印出来了  ！！
		
		/*
		MyThread_01 MyThread_01 = new MyThread_01();
		Thread thread_01 = new Thread(MyThread_01);
		
		Thread thread_02 = new Thread(MyThread_01);
		
		
		thread_01.start();
		thread_02.start();
		
		try {
			thread_01.join();
			thread_02.join();
			}catch( InterruptedException e) {
				e.printStackTrace();
			}
		
		 System.out.println("Final count: " + MyThread_01.getCount());
		*/
		
		/*
		 // 真正的资源竞争，会吞掉数据的那种，造成底层数据丢失
		class Counter {
		    private int count = 0;

		    // 计数器加一的操作
		    public  void increment() {
		        // 这里是争抢资源的地方：多个线程会争抢访问这个共享变量
		        count++;
		    }

		    public int getCount() {
		        return count;
		    }
		}
		
		Counter counter = new Counter();

        // 创建两个线程，这两个线程都会访问和修改同一个 `counter` 对象的 `count` 变量
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment(); // 每次加 1
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment(); // 每次加 1
                }
            }
        });

        // 启动两个线程
        thread1.start();
        thread2.start();

        // 等待两个线程执行完毕
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印最终结果，应该是 2000，但因为争抢资源，可能会看到比 2000 小的值
        System.out.println("Final count: " + counter.getCount());
		
		*/
		
		/*
		1. 核心问题回顾
		现象：在方法上添加了 synchronized 关键字，但多线程运行时输出依然混乱，并未实现互斥。
		初衷：误认为 synchronized 是锁定方法代码本身，只要加锁，所有线程都应排队执行。
		
		MyThread_01 MyThread_01 = new MyThread_01();
		Thread thread_01 = new Thread(MyThread_01);
		MyThread_01 MyThread_02 = new MyThread_01();
		Thread thread_02 = new Thread(MyThread_02);
		
		
		2. 锁的本质：对象锁
		锁的对象：synchronized 锁定的不是代码，而是对象实例。
		锁的生效条件：
		实例1 和 实例2 分别进入了两个线程 ，线程1 和 线程2 自然都是给自己的实例1 和 实例2上了锁， 但是输出依旧混乱。问题在于两个线程 执行两个实例。实际上锁的作用是
		在两个线程抢一个实例（资源）的情况下才会有用，两个线程两个实例虽然各自都加上锁了，但是混乱根源在于两个线程根本没去抢同一个实例
		如果创建了多个实例（例如 new 了两次），每个实例拥有独立的锁。线程 A 锁住实例 A，线程 B 依然可以锁住实例 B，互不干扰。
		结论：要实现同步，必须确保多个线程共享同一个实例对象。
		
		3. 线程与实例的区别
		实例（对象）：
		通过 new 关键字创建（如 new MyThread()）。
		此时它只是一个普通的 Java 对象，存在于堆内存中。
		它定义了任务逻辑（run 方法），但尚未具备执行能力。
		线程（执行流）：
		通过调用 .start() 方法启动。
		此时 JVM 才会请求操作系统开辟新的执行路径（栈帧）。
		关键点：new 出来的是“死”的任务，start() 之后才是“活”的线程。
		
		4. 正确的并发模型
		错误的调用方式：
		创建两个 MyThread 实例，分别启动。
		结果：两个线程操作两个不同的资源，无竞争，锁失效。
		正确的调用方式：
		创建一个 MyThread 实例（共享资源）。
		创建两个 Thread 对象（或复用 Thread），将同一个实例传入。
		结果：两个线程争夺同一个实例的锁，synchronized 生效，实现互斥访问。
		非法操作：
		对同一个 Thread 实例调用两次 .start() 是非法的，会抛出 IllegalThreadStateException。
		
		5. 总结
		资源共享是前提：没有共享同一个实例，就没有线程竞争，也就观察不到锁的效果。
		语法与模型：理解多线程不能只看代码语法，必须理解内存中对象的分配与线程的执行路径。
		
		
		System.out.println("=========线程的同步问题============");
		*/
		
		
		
		/*
		
		
		
		System.out.println("=========锁的颗粒度问题============");
		
		
		//1.不想让线程A把十条全输出完后，线程B再进去输出。涉及到了颗粒度的问题，使用synchronized ( this ){}只把那六条输出代码包裹起来而不是整个for循环就可以做到
		// 由于性能太好，导致线程A输出一条，线程B输出一条的理想输出无法做到，就让抢进来的线程睡1毫秒，让另一个线程来
		
		MyThread_02 MyThread_02 = new MyThread_02();
		Thread thread_03 = new Thread(MyThread_02);
		
		Thread thread_04 = new Thread(MyThread_02);
		
		
		thread_03.start();
		thread_04.start();
		
		try {
			thread_03.join();
			thread_04.join();
			}catch( InterruptedException e) {
				e.printStackTrace();
			}
		
		System.out.println("=========锁的颗粒度问题============");
		
		
		
		*/
		
	//	System.out.println("=========线程池的问题============");
		
		/*
		 * 因为创建和销毁线程非常昂贵，为了复用线程，于是就有了线程池。
		 * 线程池大致是这样工作的， excutor. submit( Runnable task ) 接受一个实现了Runnable接口类的任务，如果线程池中有空闲的核心线程，则使用这个空闲的线程去执行任务
		 * 如果没有空闲的核心线程，则进入等待区，等待核心线程把手上的任务做完，再交给核心线程。如果等待区也满了，则开始创建非核心线程，如果非核心线程的创建也达到了上线，则拒绝齿形
		 * 此外， 线程池中的线程分为核心线程和非核心线程
		 *核心线程永不销毁，非核心线程用完等待一些时间不用自动销毁
		 *
		 *线程池七大参数
		 * corePoolSize 核心线程数
		 * maximumPoolSize 最大线程数 ： 非核心线程 + 核心线程数 = 最大
		 *keepAliveTime 存活时间： 非核心线程数的存活时间
		 *unit时间单位 ； 存活时间的时间单位
		 *workQueue等待区大小
		 *ThreadFactory 给线程起名字 的地方
		 *handler 拒绝策略： AbortPolicy（默认，直接报错） ， CallerRunsPolicy（谁呼叫谁执行） ， DiscardPolicy（直接丢弃） ， DiscardOldestPolicy（把最旧的任务丢掉，把新任务加入等待区）
		 * 
		 */
		// 四大常用线程池
		
		ExecutorService executor1 = Executors.newFixedThreadPool(4); // 固定数量线程池。 四个全是核心线程 ， 等待区是21亿 ， 适合并发比较平稳的环境 ， 不然排队能排到内存爆炸
		ExecutorService executor2 = Executors.newCachedThreadPool(); // 缓存线程池 。 没有核心线程 ， 全是非核心线程 ，最大线程数21亿 ， 60秒销毁 ，等待区为0 适合任务量非常大，但是任务执行时间短 ， 但是如果瞬间来十万个请求，系统会创建十万个线程，cpu上天
		ExecutorService executor3 = Executors.newSingleThreadExecutor();//单线程池 核心线程数为 1 ， 没有非核心线程 ， 等待区是 21 亿 写日志，顺序处理文件，不会发生资源竞争，锁都不用加 ， 但是容易排队到内存爆炸
		ExecutorService executor4 = Executors.newScheduledThreadPool(4); // 周期线程池 ， 核心线程为传输参数 最大线程数Integer.MAX_VALUE ， 任务队列DelayedWorkQueue，适用于执行定时任务，心跳检测，周期性轮询  但是如果瞬间来十万个请求，系统会创建十万个线程，cpu上天

		
		
        // 提交5个任务
        for (int i = 0; i < 6; i++) {
            final int taskId = i + 1;  // 任务编号
            //匿名实现类， 并立刻实例出一个Runnable对象。
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        // 模拟任务执行需要一定时间
                        System.out.println("任务 " + taskId + " 开始执行: " + Thread.currentThread().getName());
                        Thread.sleep(2000);  // 每个任务执行2秒
                        System.out.println("任务 " + taskId + " 执行完毕: " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executor1.submit(task);  // 提交任务
        }

        executor1.shutdown();  // 关闭线程池
		
		
		
   //     System.out.println("=========线程池的问题============");
		
		
		
		
		
	}

}
