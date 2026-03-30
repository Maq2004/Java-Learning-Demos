package day_22;

import java.util.ArrayList;
// 知识点：静态导入（进阶）但此处保持基础写法
import java.util.List;

/**
 * 知识点：单例工具类设计
 * - 静态集合存储数据
 * - 封装业务操作方法
 */
public class Student_Manager { // 修正：类名驼峰命名
    
    // ============== 知识点：集合声明 ==============
    /**
     * 存储所有学生对象的集合
     * 使用List接口引用指向ArrayList实现
     * 优势：解耦，未来可替换实现类
     */
    private static List<Student> studentList = new ArrayList<>();
    
    // ============== 知识点：封装业务方法 ==============
    
    /**
     * 添加学生到系统
     * @param student 要添加的学生对象
     * @return 添加是否成功（ArrayList.add()返回值）
     */
    public static boolean addStudent(Student student) {
        return studentList.add(student);
    }
    
    /**
     * 查看所有学生信息
     * 知识点：增强for循环遍历集合
     */
    public static void viewAllStudents() {
        System.out.println("===== 学生列表 =====");
        if (studentList.isEmpty()) {
            System.out.println("暂无学生数据");
            return;
        }
        
        for (Student stu : studentList) {
            System.out.println("编号: " + stu.getStudentId() 
                             + ", 姓名: " + stu.getStudentName()
                             + ", 性别: " + stu.getStudentSex());
        }
        System.out.println("==================");
    }
    

}