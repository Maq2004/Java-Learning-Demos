package day_09;

public class Vote {
	private static int maxVotes;
	private static 	String[] fans = new String[maxVotes];
	private static int count;
	
	public void initVote() {
		Vote.count = 0;
		
	}
	public void setMaxVotes( int num ) {
		
		if( num < 0 ) {
			
			Vote.maxVotes = 0;
			
		}else {
			Vote.maxVotes = num;
			fans = new String[num];
			
		
		}
		
	}
	
	public int getMaxVotes() {
		
		return maxVotes;
		
	}
	public void votefuntion( String name ) {
		
		boolean flag = true;
		if(maxVotes == count) {
			flag = false;
		}
		
		for(int i = 0; i<count;i++) {
			
			if( fans[i].equals(name)  ) {
				flag = false;
				break;
			} else if( fans[i] == null ) {
				break;
			}
		}
		
		
		if(flag) {
			fans[count] = name;
			count++;
			System.out.println("投票成功");
		}else{
			System.out.println("您已经投过票或人数已满");
		}
	}
	
	
	

}
