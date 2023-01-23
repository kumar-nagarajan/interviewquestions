package interviewQuestions;

import java.util.Stack;

public class IsBalanced {

	public static void main(String[] args) {
		 String sample = ")((()()()(()))))";
		
		System.out.println(isBalanced(sample));

	}
	
	public static boolean isBalanced(String str) {
		Stack<Character> charStack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				charStack.add(str.charAt(i));
			}else {
				if(str.charAt(i) == '(') {
                    if(charStack.pop() == ')') {
                    	return false;
                    }
			}
		}
	}
		return charStack.size() == 0;

	}}
