package day02;

public class UserInfo {

		String username;
		
		String userpasswd;
		
		public void register( UserInfo users[] , int index , String name ,String passwd ) {
			
			UserInfo temp = new UserInfo();
			temp.username = name;
			temp.userpasswd = passwd;
			users[index] = temp;
		}
}
