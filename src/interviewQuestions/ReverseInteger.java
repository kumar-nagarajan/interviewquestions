package interviewQuestions;

public class ReverseInteger {

	public static void main(String[] args) {
		reverseNumber(1000);
		reverseInteger1(1256);
		reverseNumber1(1234);
	}

	public static void reverseNumber(int num) {

		while (num > 0) {
			int rev = num % 10;
			System.out.print(rev);
			num = num / 10;
			}
		System.out.println();
	}

	public static void reverseInteger1(int num) {
		if (num < 10) {
			System.out.println(num);
			return;
		} else {
			System.out.print(num % 10);
			reverseInteger1(num / 10);
		}
	}

	public static void reverseNumber1(int num) {
		for (; num > 0; num = num / 10) {
			int rev = num % 10;
			System.out.print(rev);
		}
		System.out.println();
	}
}
