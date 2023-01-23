package interviewQuestions;

import java.util.Stack;

public class IsBalanced1 {

	public static void main(String[] args) {
		String s = "{{}}{{{}}}}}";
		System.out.println(validParenthesis(s));
	}

	public static boolean validParenthesis(String s) {
		if(s.length() % 2 != 0)
			return false;
		
		Stack<Character> stack = new Stack<Character>();
		for(char C : s.toCharArray()) {
			if(C == '(' || C == '{' || C =='[') {
				stack.add(C);
			}else if(C ==')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			}else if(C ==']' && !stack.isEmpty() && stack.peek() == '[') {
			    stack.pop();
			}else if(C =='}' && !stack.isEmpty() && stack.peek() == '{') {
		        stack.pop();
	}
		}
	return stack.isEmpty();

}

}
