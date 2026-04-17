package day_38;

import java.net.Socket;
import java.io.*;
import java.net.*;

public class MyThread  extends Thread {
	
	
	 private Socket socket;
	
	public MyThread (  Socket socket ) {
		this.socket = socket;
		
	}
	
	
	 public void  run(){
		 InputStream is = null;
		 OutputStream os = null;
		 ObjectInputStream ois = null;
		 
		 try {
			 is = socket.getInputStream();
			 os  = socket.getOutputStream();
			 
			ois = new ObjectInputStream( is );
			Student student =  (Student)ois.readObject();
			System.out.println("传输到服务器的信息是:"+student.getName()+' ' + student.getPwd());
			socket.shutdownInput();  
			String msg = "这里是服务器的回应";
			
			os.write(msg.getBytes());
			socket.shutdownOutput();
			  
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				ois.close();
				is.close();
				os.close();
				socket.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		 
		 
		 
		
	}

}
