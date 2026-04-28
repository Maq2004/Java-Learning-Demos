package day_44;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

public class Main {
	public static void main( String[] args ) {
		/*
		// ==============================================  查看XML文件 =============================================
		// 工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			// 工人
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File("E:\\eclipse\\Java code\\JavaLearningDemos\\src\\day_44\\books.xml");
			Document document = builder.parse(xmlFile);
			document.getDocumentElement().normalize();
			
			System.out.println("成功加载！整棵树的根节点是：" + document.getDocumentElement().getNodeName());
			NodeList list =  document.getElementsByTagName("book");
			
			for( int i = 0 ; i<list.getLength() ; i++ ) {
			
				// 每一个book都是一本书
				Element book = (Element)list.item(i); // Element 是继承Node的子类
				System.out.print( book.getAttribute("id")+"  " );
				System.out.println(book
						.getElementsByTagName("title") // 找到book元素中所有的title元素
						.item(0) // 找到title元素中的第一个title元素
						.getFirstChild() // 拿到title元素中的文本节点对象
						.getNodeValue()); // 提取节点文本对象中的字符串值
				
			}
		// ==============================================  查看XML文件 =============================================
			
		*/
		/*
		// ==============================================  增加XML文件 =============================================
		
		DocumentBuilderFactory BuilderFactory = DocumentBuilderFactory.newInstance();
		try {
		DocumentBuilder builder =  BuilderFactory.newDocumentBuilder();
		
		Document document = builder.parse("E:\\eclipse\\Java code\\JavaLearningDemos\\src\\day_44\\books.xml");
		
		Element  book  = document.createElement("book");
		book.setAttribute("id", "103");
		
		Element title = document.createElement("title");
		title.setTextContent("Git使用方法");
		
		Element price = document.createElement("price");
		price.setTextContent("91");
		
		
		Element author = document.createElement("author");
		author.setTextContent("王大爷");
		
		book.appendChild(title);
		book.appendChild(price);
		book.appendChild(author);
		
		document // 解析"E:\\eclipse\\Java code\\JavaLearningDemos\\src\\day_44\\books.xml"
		.getElementsByTagName("bookstore") // 返回所有的bookstore元素
		.item(0)// 拿取第一个bookstore节点
		.appendChild(book); // 将我光创建的book元素插入追加进去
		
		
		TransformerFactory TransFactory = TransformerFactory.newInstance();
		Transformer transBuilder = TransFactory.newTransformer();
		 
		
		transBuilder.transform(new DOMSource(document), new StreamResult("E:\\eclipse\\Java code\\JavaLearningDemos\\src\\day_44\\books.xml"));
		
		// ==============================================  增加XML文件 =============================================
		*/
		
		// ==============================================  删除XML文件 =============================================
		
		DocumentBuilderFactory BuilderFactory = DocumentBuilderFactory.newInstance();
		try {
		DocumentBuilder builder =  BuilderFactory.newDocumentBuilder();
		
		Document document = builder.parse("E:\\eclipse\\Java code\\JavaLearningDemos\\src\\day_44\\books.xml");
		
		Scanner input = new Scanner(System.in);
		String BookId = input.next();
		
		NodeList books = document.getElementsByTagName("book");
		
		for(int i = 0 ; i < books.getLength() ; i++) {
			
			Element book = (Element) books.item(i);
			
			if(BookId.equals(book.getAttribute("id"))  ) {
				
				Node parent = book.getParentNode();
				
				parent.removeChild(book);
				break;
				
			}
			
			
		}
		
		TransformerFactory TransFactory = TransformerFactory.newInstance();
		Transformer transBuilder = TransFactory.newTransformer();
		 
		
		transBuilder.transform(new DOMSource(document), new StreamResult("E:\\eclipse\\Java code\\JavaLearningDemos\\src\\day_44\\books.xml"));
		
		// ==============================================  修改XML文件 =============================================
		 
		
		/*
		 * 修改XML文件 book
		 * 				.getElementsByTagName("title") // 找到book中的所有title元素
		 * 				.item(0)//取出第一个
		 * 				.getFirstChild() // 拿到title元素中的文本节点对象
						.setNodeValue(" "));
						
					OR
					book
		 * 				.getElementsByTagName("title") // 找到book中的所有title元素
		 * 				.item(0)//取出第一个
		 * 				.setTextContent("");
		 * 
						
		 */
		// ==============================================  修改XML文件 =============================================


			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
