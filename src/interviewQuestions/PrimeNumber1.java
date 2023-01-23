package interviewQuestions;

public class PrimeNumber1 {

	public static void main(String[] args) {
		int i = 21;
		if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
			System.out.println(i + " is not a prime number.");
		} else {
			System.out.println(i + " is a prime number.");
		}

	}
}
