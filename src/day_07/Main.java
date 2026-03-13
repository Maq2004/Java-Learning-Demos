package day_07;

import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		
		
		/*
		 * 单列：
		 * Collection 接口存储一组不唯一，无序的对象
		 * LIst接口存储一组不唯一，有序的对象
		 * Set接口春初一组唯一，无序的对象
		 * 
		 * 双列：
		 * Map接口存储一组键值对，提供key到value的映射
		 * 
		 */
		
		
		 ArrayList list  = new ArrayList();
		 
		 list.add(20);
		 list.add(30);
		 list.add(40);
		 
		 
		 
		list.add(0,10);
		
		list.remove(3);
		Object data = 30;
		
		list.remove(data);
		
		
		
		for(int i = 0; i<list.size();i++) {
			 
			 System.out.print(" "+list.get(i));
			 
		 }

	} 

}
