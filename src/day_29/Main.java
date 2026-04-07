/*
package day_29;
import java.io.*;
public class Main {
	public static void main( String[] args ) {
		
		
		File file = new File("C:\\Users\\acer\\OneDrive\\Desktop\\readme2233.md");
			
		if( file.exists() ) {
			
			if(file.isFile()) {
				System.out.println("文件名字:"+file.getName());
				System.out.println("文件相对路径:"+file.getPath());
				System.out.println("文件绝对路径:"+file.getAbsolutePath());
				System.out.println("文件大小:"+file.length());
				if(file.delete()) {
					System.out.print("删除成功");
					
				}else {
					System.out.print("删除失败");
				}
				
				
				
			}
			if( file.isDirectory() ) {
				System.out.println("是目录");
				
			}
			
			
		}else {
			
			System.out.println("文件不存在");
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			
			if( file.exists()) {
				System.out.println("创建成功");
			}else {
				System.out.println("失败");
			}
			
			
			
			
		}

	}
}

*/


/*
package day_29;
import java.io.*;
public class Main {
	public static void main( String[] args ) {
		
		FileInputStream Fis = null; // 文件路径
		InputStreamReader Isr = null; // 文件翻译 将gbk翻译成UTF8一类
		BufferedReader Bed = null; // 文件缓冲 -- 更快的读取文件
		
		
		try {
			
			
			Fis = new FileInputStream("C:\\Users\\acer\\OneDrive\\Desktop\\readme.md");
			Isr = new InputStreamReader(Fis,"UTF-8");
			Bed = new BufferedReader(Isr);
			
			String line;
			
			while( (line= Bed.readLine()) != null ) {
				
				System.out.println(line);
				
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			
			if( Bed != null ) {
				
				
				try {
					Bed.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}else {
				System.out.println("关闭失败");
			}
			
		}
		
		File file = new File("C:\\Users\\acer\\OneDrive\\Desktop\\readme2233.md");
		
		if( file.exists() ) {
			
		}else {
			
			try {
				file.createNewFile();
				System.out.print("创建成功");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		FileOutputStream FOS = null;
		OutputStreamWriter OSW = null;
		BufferedWriter BW = null;
		
		
		
		
		
		try {
			
			String path = file.getAbsolutePath();
			
			
		  FOS= new FileOutputStream(path);
		  OSW=new OutputStreamWriter( FOS,"UTF-8" );
		  BW = new BufferedWriter(OSW );
		  
		  BW.write("这是写入的第一句");
		  
		  Fis = new FileInputStream("C:\\Users\\acer\\OneDrive\\Desktop\\readme.md");
		  Isr = new InputStreamReader(Fis,"UTF-8");
			Bed = new BufferedReader(Isr);
			
			String line;
			
			while( (line= Bed.readLine()) != null ) {
				
				BW.write(line+'\n');
				
			}
			
			BW.flush();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			
			if( BW != null ) {
				try {
					BW.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
			
		}
	
		

	}
}
*/
package day_29;
import java.io.*;
import java.util.Scanner;
public class Main {
	public static void main( String[] args ) {
		
		
		File file = new File("C:\\Users\\acer\\OneDrive\\Desktop\\readme.md");
		
		FileInputStream file1 = null;
		FileOutputStream file2 = null;
		
		FileReader file3 = null;
		
		InputStreamReader file4 = null;
		StringBuffer sb = null;
		
		
		DataInputStream DIS = null;
		DataOutputStream DOS = null;
		
		FileInputStream file5_in = null;
		FileOutputStream file6_out = null;
		
		
		
		
		
		try {
			file1 =  new FileInputStream("C:\\Users\\acer\\OneDrive\\Desktop\\readme.md");
		 	file2 = new FileOutputStream("C:\\Users\\acer\\OneDrive\\Desktop\\readme2244.md");
			file3 = new FileReader("C:\\\\Users\\\\acer\\\\OneDrive\\\\Desktop\\\\readme.md");
			file4 = new InputStreamReader(file1,"UTF-8");
			
			file5_in = new FileInputStream("C:\\\\Users\\acer\\\\OneDrive\\\\Desktop\\\\saber.jpg");
			DIS = new DataInputStream(file5_in);
			
			file6_out = new FileOutputStream("C:\\\\Users\\acer\\\\OneDrive\\\\Desktop\\\\saber1.jpg");
			DOS = new DataOutputStream(file6_out);
			
			
			
			
			sb = new StringBuffer();
			
			int data;
			
			byte[] bytes = new byte[1024];
			char[] chars = new char[1024];
			
//			字节流读取文件 , 使用构造方法将字节数组变为字符串，从第0个字节开始到length长度
//			
//			while( (file1.available()) != 0 ) {
//				
//				
//				int data = file1.read(bytes);
//				String str = new String( bytes , 0 , data );
//				
//				System.out.println(str);	
//			}
//			
//		
//		 	 字节流写入文件
//			Scanner input = new Scanner(System.in);
//			
//			String words = input.nextLine();
//			
//			bytes  = words.getBytes();
//			
//			
//			file2.write(bytes);
//			
//			file2.flush();
//			
			
			
//			字符流读取文件，但是乱码,使用StringBuffer来拼接字符串
//			int length = file3.read(chars);
//			if( length != -1 ) {
//				
//				sb.append(chars);
//				length  = file3.read(chars);
//			}
//			
//			System.out.print(sb);
//			
//			
			

			/*
			 * 
			 * 字符流读取文件，使用InputStreamReader可以指定UTF-8读取，使用for循环来打印字符串
			int length  = 	file4.read(chars);
			
			while( length != -1 ) {
			
				for(int i = 0 ; i<length;i++) {
					
					System.out.print(chars[i]);
					
				}
			
			length  = file4.read(chars);
			}
			
	
			
*/
			

			
			
			
		/*
		 * 二进制流读取图片
		 *  while ( (data=  DIS.read()) != -1 ) {
				 
				 DOS.write(data);
				 data = DIS.read();	 
				 
			 }
			 
			 DOS.flush();
		 */
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			
			System.out.print("没找到文件");
		} catch (IOException e) {
			
			System.out.print("IO读取错误");
		}finally {
			
			try {
				file1.close();
				file2.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	
		

	}
}





























