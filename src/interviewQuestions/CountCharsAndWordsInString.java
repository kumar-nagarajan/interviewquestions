package interviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCharsAndWordsInString {

	public static void main(String[] args) {
         System.out.println("Counting Chars:" + countChars("This is a test of test"));
         System.out.println("Counting Words:" + countWords("This is a test of test"));
         //System.out.println("Counting Words:" + countchar1("This is a test of test"));

	}
	
	public static Map<Character, Integer> countChars(String str){
		Map<Character,Integer> chars = new HashMap<Character, Integer>(); 
		for(int i = 0; i < str.length(); i++) {
			
			if(chars.containsKey(str.charAt(i))) {
				chars.put(str.charAt(i), chars.get(str.charAt(i))+1);
			}else {
				chars.put(str.charAt(i), 1);
			}
		}
		
		return chars;
	}
	
	public static Map<String, Integer> countWords(String str){
		Map<String,Integer> words = new HashMap<String, Integer>(); 
		
		    for(String w : str.split(" ")) {
		    	if(words.containsKey(w)){
		    		words.put(w, words.get(w) + 1);
		       	}else {
		       		words.put(w, 1);
		       	}
		    }
		return words;
	}}
	
//	public static ArrayList<ArrayList<Character>> countchar1(String str) {
//		ArrayList<ArrayList<Character>> temp = new ArrayList<>();
//		Set<Character> chars = new HashSet<>();
//		for(char c : str.toCharArray()) {
//			chars.add(c);
//	
//}
//		return temp;}}
