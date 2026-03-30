package day_22;

import java.util.*;

/**
 * 知识点：程序入口与综合实践
 * 包含：
 * 1. 集合框架核心用法（List/Set/Map）
 * 2. 学生管理系统简易实现
 * 3. 手动数组扩容原理
 */
public class Main {
    
    public static void main(String[] args) {
        
        // ====================== 知识点1：List集合基础 ======================
        System.out.println("===== List集合基础操作 =====");
        
        // 创建List（接口引用指向ArrayList实现）
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        
        // 遍历List（传统for循环）
        for (int i = 0; i < numberList.size(); i++) {
            System.out.println("元素[" + i + "]: " + numberList.get(i));
        }
        
        // ====================== 知识点2：自定义对象集合 ======================
        System.out.println("\n===== 自定义对象集合 =====");
        
        // 创建书籍列表
        List<Book> bookList = new ArrayList<>();
        
        // 添加书籍对象
        Book b1 = new Book("计算机组成原理", 1, "余玉霞");
        Book b2 = new Book("计算机网络基础", 2, "李婷婷");
        bookList.add(b1);
        bookList.add(b2);
        
        // 遍历并打印
        System.out.println("初始书籍列表:");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i)); // 自动调用toString()
        }
        
        // 插入元素（指定位置）
        Book b3 = new Book("大学数学", 3, "王梅");
        bookList.add(0, b3); // 在索引0位置插入
        System.out.println("\n插入新书后:");
        for (Book book : bookList) {
            System.out.println(book);
        }
        
        // 删除元素
        bookList.remove(0); // 删除索引0的元素
        System.out.println("\n删除首元素后:");
        for (Book book : bookList) {
            System.out.println(book);
        }
        
        // 检查元素存在性
        System.out.println("\n是否包含b3? " + (bookList.contains(b3) ? "包含" : "不包含"));
        
        // ====================== 知识点3：LinkedList特性 ======================
        System.out.println("\n===== LinkedList特性 =====");
        
        LinkedList<Book> linkedBooks = new LinkedList<>();
        linkedBooks.addFirst(b1); // 头部添加
        System.out.println("首元素: " + linkedBooks.getFirst());
        
        // ====================== 知识点4：Set集合特性 ======================
        System.out.println("\n===== Set集合特性 =====");
        
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(b1);
        Book b4 = b1; // 同一对象引用
        bookSet.add(b4);  // 实际未添加新元素
        
        System.out.println("Set大小: " + bookSet.size() + 
                          " (因为b1和b4是同一对象)");
        
        // ====================== 知识点5：Map集合核心 ======================
        System.out.println("\n===== Map集合核心 =====");
        
        // 正确初始化Map（使用泛型）
        Map<String, String> bankMap = new HashMap<>();
        
        // 添加键值对 (修正：银行名称准确对应)
        bankMap.put("CCB", "中国建设银行");
        bankMap.put("ABC", "中国农业银行");
        bankMap.put("ICBC", "中国工商银行");
        
        // 常用方法
        System.out.println("键集合: " + bankMap.keySet());
        System.out.println("值集合: " + bankMap.values());
        System.out.println("完整Map: " + bankMap);
        System.out.println("Map大小: " + bankMap.size());
        
        // 检查键存在性
        System.out.println("是否存在ICBC? " + 
                          (bankMap.containsKey("ICBC") ? "存在" : "不存在"));
        
        // 遍历Map（entrySet方式 - 推荐！）
        System.out.println("\n===== 高效遍历Map =====");
        for (Map.Entry<String, String> entry : bankMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // ====================== 知识点6：学生管理系统实战 ======================
        System.out.println("\n===== 学生管理系统 =====");
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("请输入学生姓名: ");
        String name = input.next();
        
        System.out.print("请输入学生性别: ");
        String sex = input.next();
        
        System.out.print("请输入学生ID: ");
        int id = input.nextInt();
        
        // 添加学生
        boolean success = Student_Manager.addStudent(new Student(name, id, sex));
        System.out.println(success ? "添加成功!" : "添加失败!");
        
        // 查看所有学生
        Student_Manager.viewAllStudents();
        
        input.close(); // 重要：关闭资源
    }
    
    // ====================== 知识点7：手动数组扩容原理 ======================
    /**
     * 模拟ArrayList扩容机制
     * 知识点：
     * - 数组长度不可变
     * - 扩容 = 创建新数组 + 复制元素 + 引用替换
     * - 1.5倍扩容策略
     */
    public static int[] resizeArray(int[] oldArray) {
        // 1. 计算新容量 (1.5倍)
        int newCapacity = oldArray.length + (oldArray.length >> 1); // 位运算优化
        
        // 2. 创建新数组
        int[] newArray = new int[newCapacity];
        
        // 3. 复制元素 (实际应使用System.arraycopy，此处教学用循环)
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        
        // 4. 返回新数组（原数组由GC回收）
        return newArray;
    }
}