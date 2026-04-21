package day_44;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

public class Main {
	public static void main( String[] args ) {
		
		// 工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			// 工人
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File("E:\\eclipse\\Java code\\JavaLearningDemos\\src\\day_44\\books.xml");
			Document document = builder.parse(xmlFile);
			document.getDocumentElement().normalize();
			
			System.out.println("成功加载！整棵树的根节点是：" + document.getDocumentElement().getNodeName());
			NodeList list =  document.getElementsByTagName("title");
			NodeList Idlist =  document.getElementsByTagName("book");
			
			for( int i = 0 ; i<list.getLength() ; i++ ) {
			
			
				Node titleNode = list.item(i);
				String titleText = titleNode.getTextContent();
				
				System.out.println(" 书的名字是：" + titleText);
				
			}
			 
			// 拿到所有的book
			NodeList BookList = document.getElementsByTagName("book");
			for( int i = 0 ; i<list.getLength() ; i++  ) {
				Node BookNode  = BookList.item(i);
				if( BookNode.getNodeType() == Node.ELEMENT_NODE ) {
					Element bookElement  = (Element) BookNode;
					
					String idText = bookElement.getAttribute("id");
					System.out.println( list.item(i).getTextContent()+"这本书的编号是：" + idText);
				}
				
			}
			
			
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
