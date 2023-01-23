package interviewQuestions;

public class SpecialReverseExample {

	public static void main(String[] args) {
		String text = "Jamil is a tester";
		System.out.println(specialReverse(text));
		
		//System.out.println(text);
		StringBuffer sb = new StringBuffer(text);
		//System.out.println(sb.reverse());
		
        System.out.println(reverseEachWord(text));
        reverseEachWord("str is the name");

		
}
		public static String specialReverse(String str) {
		String [] words = str.split(" ");
         String rev ="";
         
         for(int  i = words.length - 1; i>=0; i--) {
        	 rev+= words[i];
}
         return rev;
	}
		
		public static String reverseEachWord(String str) {
			String [] words = str.split(" ");
			String tempRev = "";
			
			String revWord ="";
			for (int i = 0; i < words.length; i++) {
				revWord = "";
			for(int j=words[i].length() - 1; j>=0; j--) {
				revWord+=words[i].charAt(j);
			}
	        	 tempRev += revWord + " ";
	         }
			
			
			return tempRev;
		}
		
}