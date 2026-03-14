package day_08;

public class Movie {
	
	String dirctor;
	
	String name;
	
	String[] actors;
	
	public void initActors( String[] acts ) {
		
		actors = acts;
		
	}
	
	
	public void show( ) {
			System.out.println(name);
			System.out.println(dirctor);
			for(int i = 0;i<actors.length;i++) {
				
				System.out.println(actors[i]);
				
				
			}
			
		}
	
	

}
