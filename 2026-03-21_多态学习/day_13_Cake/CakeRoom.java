package day_13_Cake;

public class CakeRoom {
	
	public static Cake BakeCake(String type,int size ) {
		Cake cake;
		
		if( type.equals("Musi") ) {
			
			cake = new Musi(size);
		}else if( type.equals("RedSiRong") ) {
			
			cake = new RedSiRong(size);
			
		}else {
			cake = new PaoFu(size);
			
		}
		
		
		
		return cake;
		
		
	}
	

}
