package interviewQuestions;

public class CombinationOf3NosInRange {

	public static void main(String[] args) {
	//	combinationInRange(1 , 5);
		
	//}
	
	//public static void combinationInRange(int start, int end) {
		int start=1, end =5;
	for(int i = start; i <= end; i++) {
			for(int j = start; j <= end; j++) {
				for(int k = start; k <= end; k++) {
					System.out.println(i + " , " + j + " , " + k);
				}
			}
		}
	}

}
