package day_08;

public class Book {
	
	private	String name;
	
	private String zuozhe;
	
	private int price;
	
	
	public Book(String name,String zuozhe,int price){
		this.name = name;
		this.zuozhe = zuozhe;
		this.price = price;
		
	}
	
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	
	
	public String getZuozhe() {
			
		return zuozhe;
	}
	
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
		
	}
	
	
		
	public int getPrice() {
			
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
		
	}
	
	
	
	

}
