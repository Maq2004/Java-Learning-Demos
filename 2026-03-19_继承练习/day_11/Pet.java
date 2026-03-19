package day_11;

public class Pet {
	

	private String catName;
	private String color;
	private int  age;

	

	
	public Pet ( String name,String color ,int age){
		this.setCatName(name);
		this.setAge(age);
		this.setColor(color);
	}
	
	public void makeSound( String name ) {
		
		System.out.println("宠物:"+name+" 在发出声音");
		
	}
	
	

	public String getCatName() {
		return catName;
	}

	public void setCatName(String name) {
		this.catName = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
