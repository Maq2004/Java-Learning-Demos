package day_08;

public class BookManager {
	
	Book[] books = new Book[50];
	
	
	
	public void initBook() {
		
		Book book  = new Book();
		
		book.name = "三国演义";
		book.zuozhe = "罗贯中";
		book.price = 100;
		
		books[0] = book;
		
	}
	
	
	public  boolean BookIn( Book book ) {
		boolean flag = false;
		
		
		for(int i = 0; i<books.length;i++) {
			if(books[i] == null) {
				books[i] = book;
				flag = true;
				break;
			}
		}
		return flag;
		

	}
	
	
	public void BookList( ) {
		
	
		System.out.println("书名"+"\t\t"+"作者"+"\t\t"+"价格");
		
		for(int i = 0 ; i< books.length;i++) {
			
			if(books[i] != null) {
				
				System.out.println(books[i].name+"\t\t"
									+books[i].zuozhe+"\t\t"
									+books[i].price);
									
				
			}
			
			
		}
		
		
	}

}
