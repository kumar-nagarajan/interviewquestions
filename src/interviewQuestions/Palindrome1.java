package interviewQuestions;

public class Palindrome1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             String str = "BoB";
             System.out.println(isPalindrome(str));

		
	}
	
	public static boolean isPalindrome(String str) {
		String rev = "";
		for(int i  = str.length() - 1; i>=0; i--) {
			rev += str.charAt(i);
			
		}
		System.out.println(rev);
		return str.equals(rev);
	}

}
