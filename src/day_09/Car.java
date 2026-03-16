package day_09;

public class Car {
	
	private String Brand; //品牌
	
	private String  Model; // 型号
	
	private int YearOfManufacture; // 出厂日期
	
	private int Mileage; // 行驶公里
	
	

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}
	
	
	

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}
	
	
	
	
	

	public int getYearOfManufacture() {
		return YearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		YearOfManufacture = yearOfManufacture;
	}
	
	
	
	

	public int getMileage() {
		return Mileage;
	}

	public void setMileage(int mileage) {
		if(mileage < 0 ) {
			Mileage = 0;
		}else
		Mileage = mileage;
	}
	
	public Car(String brand, String Model ,int YearOfManufacture) {
		
		this.Brand = brand;
		this.Model = Model;
		this.YearOfManufacture = YearOfManufacture;

	}
	
	public void show() {
		
		System.out.println("品牌:"+Brand);
		System.out.println("型号:"+Model);
		System.out.println("出厂日期:"+YearOfManufacture);
		System.out.println("行驶公里:"+Mileage);
		
	}
	
	
	
	

}
