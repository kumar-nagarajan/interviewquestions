package interviewQuestions;

public class FreedomSumLogics {
	public FreedomSumLogics(int a, int b, int c) {
		if (a == 10) {
			System.out.println("0");
		}
		if (b == 10) {
			System.out.println(a);
		}
		if (c == 10) {
			System.out.println(a + b);
		} else {
			System.out.println(a + b + c);
		}
	}

	public void freedomSum(int a, int b, int c) {
		/*
		 * if(a == 10) { System.out.println("0"); }if(b == 10) { System.out.println(a);
		 * }if(c == 10) { System.out.println(a+b); }else { System.out.println(a+b+c); }
		 */
	}

	public static void main(String[] args) {
		new FreedomSumLogics(10, 1, 10);
	}
}
