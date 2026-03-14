package day_08;

public class StudentGrades {
	
	public static void StudentGrades(int arr[]) {

		int count = arr.length;
		int max = arr[0];
		int sum = 0;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]>max) {
				
				max =arr[i];
				
			}
			sum = sum+arr[i];
			
			
		}
		
	
		System.out.print("平均成绩是:"+sum/count);
		System.out.println("最高成绩是:"+max);
		
		
		
		
	}
	

}
