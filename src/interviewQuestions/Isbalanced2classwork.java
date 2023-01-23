package interviewQuestions;

import java.util.Stack;

public class Isbalanced2classwork {

	public static void main(String[] args) {
		String s = "<({[](){}})>";
		System.out.println(validParenthesis(s));
	}

	public static boolean validParenthesis(String s) {
		
		
		Stack<Character> chars = new Stack<Character>();
		for(char c : s.toCharArray()) {
			if(c == '(' || c == '{' || c =='['|| c=='<') {
				chars.add(c);
			}else {
				if(chars.size()<1) {
				return false;
				}
			}if(c ==')' && chars.pop() !='(') {
				return false;
			}if(c =='}' && chars.pop()!='{') {
				return false;
			}if(c ==']' && chars.pop()!='[') {
				return false;
			}if(c =='>' && chars.pop()!='<') {
					return false;	
	       }
		}
		
   
	return chars.size()==0;
}
}