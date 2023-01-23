package interviewQuestions;

public class RverseIntegerMyPractice {

	public static void main(String[] args) {
	int number=12345, rev=0;
	while(number!=0) {
		int remainder=number%10;
		rev=rev*10+remainder;
		number=number/10;
		//System.out.print(rev);

	}System.out.print(rev);

	}

}
