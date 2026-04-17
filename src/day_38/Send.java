package day_38;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Send {
	public static void main( String[] args ) {
		
		byte[] Bytes = "Send端发送的数据".getBytes();
		
		DatagramSocket socket = null;
		
		try {
			socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(Bytes,0,Bytes.length ,InetAddress.getByName("localhost"),50000);
			socket.send(packet);
			
			Bytes = new byte[1024];
			packet = new DatagramPacket( Bytes,Bytes.length);
			socket.receive(packet);
			Bytes = packet.getData();
			
			System.out.print(new String(Bytes , 0 , packet.getLength() ));
			
			
		} catch (SocketException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		
		
	}

}
