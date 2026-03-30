package day_22;

/**
 * 知识点：领域对象设计
 * - 封装书籍属性
 * - 重写toString()提供友好输出
 */
public class Book {
    
    // ============== 知识点：封装 ==============
    private String bookName;
    private int bookId;
    private String bookAuthor;
    
    /**
     * 构造方法：初始化书籍对象
     */
    public Book(String name, int id, String author) {
        this.bookName = name;
        this.bookId = id;
        this.bookAuthor = author;
    }
    
    // ============== 知识点：重写toString() ==============
    /**
     * 重写Object类的toString方法
     * 作用：提供对象的字符串表示，便于打印和调试
     * @return 书籍信息的字符串表示
     */
    @Override  // 知识点：@Override注解 - 标记重写父类方法
    public String toString() {
        return "书名: " + this.bookName + 
               ", 作者: " + this.bookAuthor + 
               ", 编号: " + this.bookId;
    }
    
    // ============== 知识点：getter/setter ==============
    // 标准访问器方法
    
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}