package interviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class RemoveVowelsFromString {

	public static void main(String[] args) {
		
		System.out.println(removeAllVowelChars("walgnkmijsfhew"));
		 System.out.println(countOfVowelChars1("aeiouppoppy"));
		 System.out.println(countOfVowelChars2("ithsaLopud"));

	}

	public static String removeAllVowelChars(String str) {
		return str.replaceAll("[aeiou]", "");
	}
	
	public static int countOfVowelChars1(String str) {
         return str.replaceAll("[^aeiou]","").length();
	}
	
	public static int countOfVowelChars2(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if("aeiou".contains("" + str.charAt(i))) {
				count++;
			}
		}
		
		return count;
	}
}
