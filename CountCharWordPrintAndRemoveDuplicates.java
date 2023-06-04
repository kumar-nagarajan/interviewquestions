package javainterviewquestion1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CountCharWordPrintAndRemoveDuplicates {

	public static void main(String[] args) {
		String str= " this is this is my first my interview";
		countChars(str);
		countWords(str);
	}
	public static  Map<Character, Integer> countChars(String str){
		Map<Character, Integer> chars = new HashMap<Character, Integer>();
		Map<Character, Integer> dup = new HashMap<Character, Integer>();
		for(int i =0; i<str.length();i++) {
			char a= str.charAt(i);
			if(chars.containsKey(a)) {
				chars.put(a, chars.get(a)+1);
			}else {
				chars.put(a, 1);
			}
		}			System.out.println("Print all character in String: "+chars);

		char[] data = str.toCharArray();
		for(char key : data) {
			if(chars.get(key)>1) {
				dup.put(key, chars.get(key));
			}
		}
		System.out.println("Print all duplicates character in string: "+dup);
		String s="";
		Set<Entry<Character, Integer>> entryset= chars.entrySet();
		for(Entry<Character, Integer> entry: entryset) {
			s=s+entry.getKey();
		}
		System.out.println("After remove duplicate characters in string : "+s);
		
		
		
		return chars ;
	}	
	public static Map<String, Integer> countWords(String str){
	Map<String, Integer> words = new HashMap<String,Integer>();
	Map<String, Integer> dupwords = new HashMap<String,Integer>();
	for(String s: str.split(" ")) {
		if(words.containsKey(s)) {
			words.put(s, words.get(s)+1);
		}else {
			words.put(s, 1);
		}
	}
	System.out.println("count the words in the String "+words);
	
	for(String s:str.split(" ")) {
		if(words.get(s)>1) {
			dupwords.put(s, words.get(s));
		}
		
		
	}System.out.println("count duplicates in words: "+dupwords);
	
	/*
	 * Set<String> dup = new HashSet<String>(); for(String s:str.split(" ")) {
	 * if(!dup.contains(s)) { dup.add(s); } }System.out.println(dup);
	 */
	 
	String t="";
	Set<Entry<String, Integer>> entryset= words.entrySet();
	for(Entry<String, Integer> entry: entryset) {
		t=t+entry.getKey();
	}
	System.out.println("After remove duplicates in words : "+t);
	
	return words;
	}
	}
