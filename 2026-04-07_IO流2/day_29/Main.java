package day_29;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ================== 第一部分：基础文件操作 (File Class) ==================
        // 前因：在读写文件之前，我们需要先确认文件是否存在，或者进行创建/删除。
        // 后果：File 类只能操作文件属性，不能读写内容。
        
        File file = new File("C:\\Users\\acer\\OneDrive\\Desktop\\readme2233.md");
        
        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("文件名字: " + file.getName());
                System.out.println("文件相对路径: " + file.getPath());
                System.out.println("文件绝对路径: " + file.getAbsolutePath());
                System.out.println("文件大小: " + file.length());
                
                if (file.delete()) {
                    System.out.print("删除成功");
                } else {
                    System.out.print("删除失败");
                }
            }
            if (file.isDirectory()) {
                System.out.println("是目录");
            }
        } else {
            System.out.println("文件不存在");
            try {
                file.createNewFile(); // 尝试创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            if (file.exists()) {
                System.out.println("创建成功");
            } else {
                System.out.println("失败");
            }
        }

        // ================== 第二部分：字符流与编码处理 (解决乱码) ==================
        // 前因：我们需要读写文本文件。直接使用字节流读取中文可能会出现乱码。
        // 从基础的 FileInputStream 配合 InputStreamReader，
        // 到使用 BufferedReader 提高效率。
        
        // --- 实验 1：基础读取 (InputStreamReader)
        // 说明：这是最基础的读取方式，手动指定了 UTF-8 编码，防止中文乱码。
        FileInputStream Fis = null;
        InputStreamReader Isr = null;
        try {
            Fis = new FileInputStream("C:\\Users\\acer\\OneDrive\\Desktop\\readme.md");
            Isr = new InputStreamReader(Fis, "UTF-8"); // 强制指定编码
            
            char[] chars = new char[1024];            
            // 这里通常需要配合 BufferedReader 才能按行读取，单纯的 Isr 需要循环读取字符
           int dataNumber =  Isr.read(chars);
           
           while( dataNumber != -1  ) {
        	   
        	   for( char item: chars ) {
        		   System.out.print(item);
        		   
        	   }
        	   
           }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 资源释放
            try { if (Isr != null) Isr.close(); } catch (IOException e) { e.printStackTrace(); }
            try { if (Fis != null) Fis.close(); } catch (IOException e) { e.printStackTrace(); }
        }

        // --- 实验 2：缓冲流读取 (BufferedReader) - 推荐
        // 说明：BufferedReader 提供了 readLine() 方法，可以按行读取，效率更高。
        // 注意：BufferedReader 通常包装 InputStreamReader 使用。
        /*
        标准的文本读取流程：
        
        BufferedReader Bed = null;
        try {
            // 1. 字节流读取文件
            Fis = new FileInputStream("C:\\...\\readme.md");
            // 2. 转换流：将字节流转为字符流，并指定编码
            Isr = new InputStreamReader(Fis, "UTF-8");
            // 3. 缓冲流：包装字符流，提供缓冲功能
            Bed = new BufferedReader(Isr);
            
            String line;
            while ((line = Bed.readLine()) != null) { // 按行读取
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Bed != null) {
                try { Bed.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
        */

        // ================== 第三部分：文件复制与写入 (流的综合应用) ==================
        // 前因：我们需要将 readme.md 的内容复制到 readme2233.md。
        // 后果：展示了读取流和写入流的配合使用。
        
        // 1. 确保目标文件存在（如果不存在则创建）
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.print("创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 2. 写入与复制逻辑
        FileOutputStream FOS = null;
        OutputStreamWriter OSW = null;
        BufferedWriter BW = null;
        
        try {
            String path = file.getAbsolutePath();
            FOS = new FileOutputStream(path);
            OSW = new OutputStreamWriter(FOS, "UTF-8");
            BW = new BufferedWriter(OSW);
            
            // 步骤 A：写入新内容
            BW.write("这是写入的第一句");
            BW.newLine(); // 写入换行符
            
            // 步骤 B：读取源文件并写入目标文件
            // 这里复用了上面的读取逻辑，将内容追加进去
            Fis = new FileInputStream("C:\\Users\\acer\\OneDrive\\Desktop\\readme.md");
            Isr = new InputStreamReader(Fis, "UTF-8");
            BufferedReader reader = new BufferedReader(Isr); // 为了使用 readLine
            
            String line;
            while ((line = reader.readLine()) != null) {
                BW.write(line);
                BW.newLine(); // 复制时也要写入换行
            }
            BW.flush(); // 强制将缓冲区内容写出
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭写入流
            try { if (BW != null) BW.close(); } catch (IOException e) { e.printStackTrace(); }
        }

        // ================== 第四部分：底层字节流与二进制处理 ==================
        // 前因：FileReader/FileWriter 适合处理文本，但处理图片、视频或需要精确控制字节时，
        // 必须使用 FileInputStream/FileOutputStream。
        // 实验：我尝试了直接读取字节、使用 DataInputStream 以及使用字符数组的对比。
        
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
            // --- 尝试 1：直接字节流读取 (基础)
            file1 = new FileInputStream("C:\\...\\readme.md");
            file2 = new FileOutputStream("C:\\...\\readme2244.md");
            
            // --- 尝试 2：FileReader (可能会乱码)
            // 说明：FileReader 使用默认平台编码，如果文件是 UTF-8 而平台是 GBK，就会乱码。
            // 这就是为什么后面要改用 InputStreamReader 指定编码的原因。
            /*
            file3 = new FileReader("C:\\...\\readme.md");
            sb = new StringBuffer();
            char[] chars = new char[1024];
            int length = file3.read(chars);
            while (length != -1) {
                sb.append(chars, 0, length); // 注意：这里需要截取有效长度
                length = file3.read(chars);
            }
            System.out.print(sb);
            */
            
            // --- 尝试 3：InputStreamReader (解决编码问题)
            // 说明：这是 FileReader 的升级版，可以指定编码。
            /*
            file4 = new InputStreamReader(file1, "UTF-8");
            char[] chars = new char[1024];
            int length = file4.read(chars);
            while (length != -1) {
                for (int i = 0; i < length; i++) {
                    System.out.print(chars[i]);
                }
                length = file4.read(chars);
            }
            */

            // --- 尝试 4：DataInputStream (处理基本数据类型)
            // 说明：DataInputStream 可以读取 Java 的基本数据类型（int, double 等）。
            // 虽然这里用来读文件有点大材小用，但它常用于网络传输或特定二进制格式。
            /*
            file5_in = new FileInputStream("C:\\...\\saber.jpg");
            DIS = new DataInputStream(file5_in);
            
            file6_out = new FileOutputStream("C:\\...\\saber1.jpg");
            DOS = new DataOutputStream(file6_out);
            
            int data;
            while ((data = DIS.read()) != -1) { // read() 返回 int，-1 表示结束
                DOS.write(data);
            }
            DOS.flush();
            */

        } catch (FileNotFoundException e) {
            System.out.print("没找到文件");
        } catch (IOException e) {
            System.out.print("IO读取错误");
        } finally {
            // 统一关闭资源
            try { if (file1 != null) file1.close(); } catch (IOException e) { e.printStackTrace(); }
            try { if (file2 != null) file2.close(); } catch (IOException e) { e.printStackTrace(); }
            // ... 其他流的关闭
        }

        // ================== 第五部分：对象序列化 (Object Serialization) ==================
        // 前因：我们希望直接把 Java 对象（如 List<Book>）保存到硬盘，而不是一行行字符串。
        // 后果：使用 ObjectInputStream/ObjectOutputStream。
        
        FileInputStream file7 = null;
        FileOutputStream file8 = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            // 1. 序列化：将对象写入文件
            file8 = new FileOutputStream("C:\\Users\\acer\\OneDrive\\Desktop\\book.bin");
            oos = new ObjectOutputStream(file8);
            
            List<Book> book_list = new ArrayList<>();
            Book b1 = new Book("钢铁是怎样炼成的", 125);
            Book b2 = new Book("在人间", 65);
            book_list.add(b1);
            book_list.add(b2);
            
            oos.writeObject(book_list); // 直接写入整个对象
            System.out.println("对象写入成功");

            // 2. 反序列化：从文件读取对象
            file7 = new FileInputStream("C:\\Users\\acer\\OneDrive\\Desktop\\book.bin");
            ois = new ObjectInputStream(file7);
            
            // 强制类型转换
            book_list = (List<Book>) ois.readObject();
            
            // 验证读取结果
            for (Book book : book_list) {
                System.out.println("读取到书籍: " + book.getName() + ", 价格: " + book.getPrice());
            }

        } catch (FileNotFoundException e) {
            System.out.print("没找到文件");
        } catch (IOException e) {
            System.out.print("IO读取错误");
        } catch (ClassNotFoundException e) {
            System.out.print("类转换错误 (反序列化时找不到对应的类)");
        } finally {
            // 关闭序列化流
            try { if (oos != null) oos.close(); } catch (IOException e) { e.printStackTrace(); }
            try { if (ois != null) ois.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
}