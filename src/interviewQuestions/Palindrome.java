package interviewQuestions;

public class Palindrome {

	public static void main(String[] args) {
		String str = "madam";
		isPalindrome1(str);
		System.out.println(isPalindrome2(str));
		System.out.println(isPalindrome3(str));
	}
	
	/**
	 * @param str
	 * @return
	 */
	public static void isPalindrome1(String str) {
		StringBuilder sb = new StringBuilder(str);
		System.out.println(str.equals(String.valueOf(sb.reverse())));
	}
	
	public static boolean isPalindrome2(String str) {
		String rev = "";
		for (int i = str.length()-1; i>=0; i--) {
			rev += str.charAt(i);
		}
		return str.equals(rev);
	}
	
	public static boolean isPalindrome3(String str) {
		for(int fwd = 0, bck = str.length()-1 ; fwd<str.length(); fwd++, bck--){
			if(fwd == bck || fwd > bck) {
				return true;
			}
			if(str.charAt(fwd) == str.charAt(bck)) {
				//System.out.println("fwd:" + fwd+","+ "bck:" + bck);

				continue;
			}
			return false;
		}
			
		return false;
	}

}
