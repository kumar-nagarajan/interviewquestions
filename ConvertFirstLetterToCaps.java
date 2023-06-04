package javainterviewquestion1;

public class ConvertFirstLetterToCaps {

	public static void main(String[] args) {
		String str = "welcome to java interview";
		String s2 = "";
		String []s3 = str.split(" ");
		for(String s4 : s3) {
			char ch = s4.charAt(0);
			char a = Character.toUpperCase(ch);
			String b = s4 .substring(1);
			s2 = s2 + a + b + " ";
		}
		System.out.println(s2);
	}

}
