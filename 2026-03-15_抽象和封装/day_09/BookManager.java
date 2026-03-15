package day_08;

public class BookManager {
	
	Book[] books = new Book[50];
	
	 int count = 0;
	
	
	
	
	public void initBook() {
		
		Book book  = new Book("西游记","罗贯中",100);
		count = 1;
		books[0] = book;
		
	}
	
	
	public  boolean BookIn( Book book ) {
		boolean flag = false;
		if( count < books.length) {
			books[count] = book;
			flag = true;
			count ++;
		}
		return flag;
	}
	
	
	public void BookList( ) {
		
	
		System.out.println("书名"+"\t\t\t\t"+"作者"+"\t\t"+"价格");
		
		for(int i = 0 ; i< count;i++) {
				System.out.println(books[i].getName()+"\t\t\t\t"
									+books[i].getZuozhe()+"\t\t"
									+books[i].getPrice());
		}
	}

	
	
	public Book[] BigBook( Book[] books ) {
		Book[] BigBooks = new Book[(int) (books.length * 1.5)];
		for(int i = 0; i<count; i++) {
			BigBooks[i] = books[i];
		}
		this.books = BigBooks;
		return books;
	}
	
	public boolean DelectBook(  int index) {
		//首先明确传进来的是下标是从0 开始数，还是从1 开始数，
		//按照大众的习惯我用从1 开始数的原则写
		boolean flag = false;
		
		if( index <= count && index > 0 ) {
			books[index -1] = null;
			for(int i = index-1 ; i<count-1;i++) {
				
				books[i] = books[i+1]; 
				
			}
			books[count-1] = null;
			flag = true;
			count --;
			
			return flag;
			
		}else {
			return flag;
			
		}
		
		
	}
	
	

}
