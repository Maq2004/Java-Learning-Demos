package day_44;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/*
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
*/

public class Main {
    public static void main(String[] args) {

        /* ==============================================================================
         * 阶段一：基于官方 DOM 解析 XML (已被淘汰的历史测试代码)
         * ==============================================================================
         * Q: 为什么弃用官方 DOM 操作？
         * A: 代码过于繁琐。增删改查都需要极其冗长的步骤，且强依赖父节点关系。
         * * Q: DocumentBuilder 的作用是什么？
         * A: 基于工厂模式创建，用于将物理 XML 文件解析为内存中的 Document 树。
         * * Q: 修改完 DOM 后必须做哪一步？
         * A: 必须使用 Transformer 类，将内存中的 Document 对象重新写入并覆盖到物理文件中，否则修改仅停留在内存。
         * ==============================================================================
        
        try {
            // 查
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("E:\\eclipse\\Java code\\JavaLearningDemos\\src\\day_44\\books.xml"));
            document.getDocumentElement().normalize();
            
            NodeList list = document.getElementsByTagName("book");
            for(int i = 0; i < list.getLength(); i++) {
                Element book = (Element)list.item(i);
                System.out.println(book.getElementsByTagName("title").item(0).getFirstChild().getNodeValue());
            }

            // 增
            Element newBook = document.createElement("book");
            newBook.setAttribute("id", "103");
            document.getElementsByTagName("bookstore").item(0).appendChild(newBook);
            
            // 删
            // Node parent = book.getParentNode();
            // parent.removeChild(book);

            // 保存写入
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transBuilder = transFactory.newTransformer();
            transBuilder.transform(new DOMSource(document), new StreamResult("E:\\eclipse\\Java code\\JavaLearningDemos\\src\\day_44\\books.xml"));
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        */


        /* ==============================================================================
         * 阶段二：基于 DOM4J 解析 XML (日常主力方案的历史测试代码)
         * ==============================================================================
         * Q: DOM4J 的核心优势？
         * A: API 设计优雅，支持链式编程（如 addElement().addAttribute()），大幅缩减代码量。
         * * Q: 为什么整型学号末尾要加 L？
         * A: Java 默认整型数字为 int，超过其最大容量(约21亿)会报错。加 L 是通知编译器分配 long 类型内存。
         * * Q: 删除节点最快的方法？
         * A: 找到目标 Element 后直接调用 detach() 方法使其脱离 DOM 树，无需寻找父节点。
         * * Q: elements() 方法有什么局限性？
         * A: 只能获取当前节点的直接子标签（亲儿子）。如果遇到多层嵌套，必须写多层嵌套的 for 循环。
         * ==============================================================================
         
        try {
            // 增：创建文件与写入数据
            Document newDocument = DocumentHelper.createDocument();
            Element root = newDocument.addElement("Students");
            
            Long studentId = 202522430201L;
            Element studentElement = root.addElement("student").addAttribute("学号", studentId.toString());
            studentElement.addElement("name").setText("Maaa");
            studentElement.addElement("Age").setText("20");
            
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(new FileOutputStream("E:\\eclipse\\Java code\\JavaLearningDemos\\Students.xml"), format);
            writer.write(newDocument);
           

            // 查、改、删
            SAXReader reader = new SAXReader();
            Document document = reader.read("E:\\eclipse\\Java code\\JavaLearningDemos\\Students.xml");
            Element readRoot = document.getRootElement();
            
            List<Element> studentList = readRoot.elements("student");
            for(Element student : studentList) {
                if("202522430201".equals(student.attributeValue("学号"))) {
                    student.element("name").setText("Maaa"); // 改
                }
                if("202522430200".equals(student.attributeValue("学号"))) {
                    student.detach(); // 删
                }
            }
            
            // 必须再次使用 XMLWriter 保存到硬盘
            writer.writer(document);
            writer.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        */


        // ==============================================================================
        // 阶段三：基于 XPath 提取深层数据 (当前最新版本的有效代码)
        // ==============================================================================
        // Q: 为什么要引入 XPath？
        // A: 解决 DOM4J 处理深层嵌套结构时需要反复 for 循环的痛点。XPath 类似文件系统路径，可一步到位。
        //
        // Q: 使用 XPath 的前置条件是什么？
        // A: 必须下载 jaxen.jar 包（纯净版，不能是 javadoc 版），并 Add to Build Path，否则运行时报 NoClassDefFoundError。
        //
        // Q: selectNodes() 和 selectSingleNode() 的区别？
        // A: 前者用于一网打尽，返回 List<Node>；后者用于精准狙击，只返回首个命中的 Node。
        //
        // Q: 核心语法中 // 和 @ 的作用？
        // A: // 代表无视层级的地毯式全局搜索；@ 用于指代和匹配标签的属性（如 [@id='xxx']）。
        // ==============================================================================
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File("E:\\eclipse\\Java code\\JavaLearningDemos\\src\\day_44\\XpathStudent.xml"));
            Element root = document.getRootElement();
            
            // 任务一：无视层级地毯式搜索
            for(org.dom4j.Node studentName : root.selectNodes("//Student/Name")) {
                System.out.println(studentName.getText());
            }
            
            // 任务二：精准属性狙击
            System.out.println(root.selectSingleNode("//Student[@id='SZU999']/Age").getText());
            
            // 任务三：条件过滤获取属性
            for(org.dom4j.Node school : root.selectNodes("//School[@type='大学']") ) {
                Element schoolElement = (Element)school; // 强转为Element以调用attributeValue
                System.out.println(schoolElement.attributeValue("name"));
            }
            
            // 任务四：路径与条件结合 - 骨灰级
            for(org.dom4j.Node studentNameNode : root.selectNodes("//School[@name='南山中学']//Student/Name")) {
                System.out.println(studentNameNode.getText());
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}