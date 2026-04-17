package day_38;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	public static void main(String[] args) {
		
		
		// ==============================================基于TCP协议的Socket传输=============================================== 
		
		/*
		System.out.println("=========阶段一：基础字符串通信============");
		
		1. 核心问题回顾：accept() 阻塞
		现象：服务端启动后，如果没有客户端连接，程序会一直停在 accept() 这一行。
		原因：accept() 是阻塞方法。TCP 需要完成三次握手，连接建立成功后，它才会返回一个 Socket 对象供后续读写，否则主线程直接挂起等待。
		局限：单线程下，必须处理完上一个客户端的所有请求，才能重新循环回到 accept() 接收下一个，无法并发。

		ServerSocket serverSocket = new ServerSocket(50000);
		Socket socket = serverSocket.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg;
		while( (msg = br.readLine())!= null ) {
			System.out.println("接收到的消息是: " + msg);
		}
		serverSocket.close();
		
		System.out.println("=========阶段一：基础字符串通信============");
		*/

		/*
		System.out.println("=========阶段二：对象序列化传输============");
		
		2. 核心问题回顾：传输对象
		现象：通过 ObjectInputStream 直接读取客户端发来的 Student 实例。
		原理：网络底层只认一维的字节流。对象传输的本质是序列化（对象 -> 字节）和反序列化（字节 -> 对象）。
		坑点：客户端和服务端的 Student 类不仅内部结构要一致，【包名】也必须完全相同，否则会报 ClassNotFoundException。

		ServerSocket serverSocket = new ServerSocket(50000);
		Socket socket = serverSocket.accept();
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		Student info = (Student)ois.readObject();
		System.out.print( "学生的信息是:"+ info.getName() + info.getPwd());
		serverSocket.close();
		
		System.out.println("=========阶段二：对象序列化传输============");
		*/
		
		/*
		System.out.println("=========阶段三：多线程并发接收============");
		
		3. 核心问题回顾：每次 accept 都 new 线程
		现象：使用 while(true) 死循环，来一个 Socket 就交给一个新的 MyThread 去处理。
		隐患：完全没有限制。线程的创建和销毁极度消耗 CPU 资源。如果瞬间并发量到达几万，系统会疯狂创建几万个线程，直接导致 OOM 内存溢出或卡死。
		
		ServerSocket serverSocket = new ServerSocket(50000);
		while( true ) {
			Socket socket = serverSocket.accept();
			MyThread t1 = new MyThread(socket);
			t1.start();
		}
		
		System.out.println("=========阶段三：多线程并发接收============");
		*/
		
		/*
		// System.out.println("=========阶段四：线程池并发处理============");
		// 4. 核心解决：使用线程池复用资源
		// 原理：创建一个固定核心线程数为 4 的线程池。
		// 现象：当第 5 个请求进来时，不会新建线程，而是放入底层的阻塞队列中排队。等前 4 个任务有执行完的，空闲线程会自动去队列抓取新任务。防崩盘利器。
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(50000);
			ExecutorService executor1 = Executors.newFixedThreadPool(4);
			
			while(true) {
				Socket socket = serverSocket.accept();
				MyTask task = new MyTask(socket);
				executor1.submit(task);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		*/
		// ==============================================基于TCP协议的Socket传输===============================================
		
		
		
		
		
		
		
		
		
		// ==============================================基于UDP协议的Socket传输===============================================
		DatagramSocket socket = null;
		
		try {
			socket = new DatagramSocket(50000);
			
			byte[] Bytes = new byte[1024];
			//这个DatagramPacket 构建一个Packet包，是为了接受数据所以不需要主机地址和端口
			DatagramPacket packet = new DatagramPacket(Bytes,Bytes.length);
			
			System.out.println("准备接收数据中...");
			// 使用socket方法接收数据包
			socket.receive(packet);
			// 将接收到的信息放入Bytes
			Bytes = packet.getData();
			// 因为是字节数据，使用String构造方法将字节数组转换为字符串打印
			System.out.println(new String(Bytes,0,packet.getLength()));
		
			// 准备返回信息
			Bytes = "这里是Receive的返回信息".getBytes();
			//这个DatagramPacket 构建一个Packet包，是为了发送数据所以需要主机地址和端口
			packet = new DatagramPacket(Bytes, 0, Bytes.length, InetAddress.getByName("localhost"), packet.getPort());
			
			socket.send(packet);
			
			
		} catch (SocketException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			socket.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}