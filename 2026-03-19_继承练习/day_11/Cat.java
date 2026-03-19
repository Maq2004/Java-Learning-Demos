package day_11;

public class Cat extends Pet {
//	public abstract int  Fishspeed(); 抽象方法必须放在抽象类中
	private String catName;
	private	String Variety; // 品种
	private String Bodytype; // 体型
	
	public String getVariety() {
		return Variety;
	}
	public void setVariety(String Variety) {
		this .Variety = Variety;
	}
	public String getBodytype() {
		return Bodytype;
	}
	public void setBodytype(String Bodytype) {
		this.Bodytype = Bodytype;
	}
	
	public Cat( String name,String color,int age ,String Variety , String Bodytype ) {
		
		super(name,color,age);//super调动父类构造只能放在子类构造中，并且只能在第一行
		
		this.catName = name;
		this.Variety = Variety;
		this.Bodytype = Bodytype;
		
		
	}

	@Override
	public void makeSound( String name ) {
		
		System.out.println("Cat:"+name+" 在喵喵叫");
		
	}
	
	
	public void changeSubOnly(String newName) {
        this.catName = newName; // 仅修改子类的变量 
    }

    public String getSubName() {
        return this.catName; // 返回子类的值
    }
    
    @Override
    public String toString() {
    	
    	return "CatName:"+catName + '\n';
    	
    	
    	
    }


	
	
}
