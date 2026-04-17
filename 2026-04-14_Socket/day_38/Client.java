package day_38;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	
	public static void main(String[] args) {
		
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		ObjectOutputStream oos = null;
		BufferedReader reader = null;
		Scanner input = new Scanner(System.in);
		
		try {
			socket = new Socket("localhost", 50000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			
			/*
			System.out.println("=========阶段一：发送字符串============");
			
			1. 核心问题回顾：流的单向关闭 shutdownOutput
			现象：发完数据后必须调用 socket.shutdownOutput()。
			原因：TCP 是全双工的持续流。如果不发 EOF（结束标志），服务端的 readLine() 或 readObject() 就会一直傻等新的数据，造成死锁阻塞。
			注意：千万不能直接调用 os.close()，那会把整个 Socket 都关掉，导致后续无法接收服务端的返回信息。
			
			String msg = "";
			System.out.print("请输入要发送的内容：");
			msg = input.next();
			os.write(msg.getBytes());
			socket.shutdownOutput();
			
			System.out.println("=========阶段一：发送字符串============");
			*/
			
			
			// System.out.println("=========阶段二：发送对象 (当前版本)============");
			// 2. 核心回顾：序列化约束
			// Q：传对象有什么强制要求？
			// A：Student 类必须 implements Serializable。这个接口里面什么方法都没有，纯粹就是给 JVM 看的一个“通行证”。
			
			Student student = new Student();
			System.out.print("请输入学生的姓名和学号: ");
			student.setName(input.next());
			student.setPwd(input.next());
			
			oos = new ObjectOutputStream(os);
			oos.writeObject(student);
			
			// 关键点：打断服务端的读取阻塞
			socket.shutdownOutput();
			
			// 接收服务端的响应数据
			String msg = "";
			while((msg = reader.readLine()) != null) {
				System.out.print("接收到的消息是: " + msg);
			}
			socket.shutdownInput();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null) reader.close();
				if(is != null) is.close();
				if(os != null) os.close();
				if(input != null) input.close();
				if(socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}