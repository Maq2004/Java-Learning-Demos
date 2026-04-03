/*
package day_26;
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



package day_26;
import java.io.*;
public class Main {
	public static void main( String[] args ) {
		
		FileInputStream Fis = null;
		InputStreamReader Isr = null;
		BufferedReader Bed = null;
		
		
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
				
				BW.write(line);
				
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