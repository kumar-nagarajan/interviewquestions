package interviewQuestions;

public class FizzBizz {

	public static void main(String[] args) {
		//printFizzBizz(3);

	//}
	
	//public static void printFizzBizz(int n) {
		int n=20;
		for(int i = 1; i <=n; i++) {
			if(i % 3 == 0 && i % 5 == 0 ) {
				System.out.println("FizzBuzz");
			} else if(i % 3 == 0) {
					System.out.println("Fizz");
				}else if(i % 5 == 0) {
					System.out.println("Buzz");
			      }else {
			    	  System.out.println(i);
			      }
		}
	} 

}
