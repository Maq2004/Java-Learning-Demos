package day_22;

/**
 * 知识点：面向对象封装
 * - 私有成员变量 + 公有getter/setter
 * - 构造方法初始化
 * - 遵循JavaBean命名规范
 */
public class Student {
    
    // 知识点：封装原则 - 成员变量私有化
    private String studentName;   // 修正：驼峰命名（student_Name → studentName）
    private int studentId;
    private String studentSex;
    
    /**
     * 知识点：构造方法
     * - 用于对象创建时初始化状态
     * @param name 学生姓名
     * @param id   学生编号
     * @param sex  学生性别
     */
    public Student(String name, int id, String sex) {
        this.studentName = name;
        this.studentId = id;
        this.studentSex = sex;
    }
    
    // ============== 知识点：getter/setter ==============
    // 生成标准访问器方法，遵循JavaBean规范
    
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }
}