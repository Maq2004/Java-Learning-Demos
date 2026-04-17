package day_38;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyTask  implements Runnable  {
	 static int i = 0;
	 
	Socket socket;
	
	public MyTask( Socket socket ) {
		this.socket = socket;
		
		
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		InputStream is = null;
		 OutputStream os = null;
		 ObjectInputStream ois = null;
		 i++;
		 
		 try {
			 is = socket.getInputStream();
			 os  = socket.getOutputStream();
			 
			ois = new ObjectInputStream( is );
			Student student =  (Student)ois.readObject();
			System.out.println("这是任务" +i +":"+student.getName()+' ' + student.getPwd());
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
