package day_09;

public class Main {
	public static void main( String[] args ) {
		
//		
//		Car car1 = new Car("宝马","Q7", 20250721 );
//		car1.setMileage(100);
//		Car car2 = new Car("宝马","Q5", 20250711 );
//		car2.setMileage(200);
//		car1.show();
//		car2.show();
//		
//		
		
		
		Vote VoteManager = new Vote();

		VoteManager.setMaxVotes(1000);
		VoteManager.votefuntion("马谦");
		
		VoteManager.votefuntion("零四");
		VoteManager.show();
		
		
		StarVote zhoujielun = new  StarVote();
		zhoujielun.showStar();

		
		
		
	}

}
