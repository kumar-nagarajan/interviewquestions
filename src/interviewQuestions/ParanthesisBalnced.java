package interviewQuestions;

import java.util.Stack;

public class ParanthesisBalnced {

	public static void main(String[] args) {
		String sample1 = "()()()()()()()()()()()";
		 System.out.println("Sample 1: "+isEqual1(sample1));
		 String sample2 = "(((()()()(()))))";
		 System.out.println("Sample 2: "+isEqual2(sample2));
		 String sample3 = ")((()()()(()))))";
		 System.out.println("Sample 3: "+isEqual3(sample3));
		 String sample4 = "<(()){}{<((({{{{}}}})))>()<>()}>";
		 System.out.println("Sample 4: "+isEqual4(sample4));
		 String sample5 = "<{[()]}>";
		 System.out.println("Sample 5: "+isEqual5(sample5));
		 String sample6 = "<{[(test)(test2)]}>";
	     System.out.println("Sample 6: "+isEqual6(sample6));
        String sample7 = null;
		 System.out.println("Input was null");
   System.out.println("Sample 7: "+isEqual7(sample7));
		
		 
		 
	}
	
	public static boolean isEqual1(String sample1) {
		Stack<Character> charStack = new Stack<>();
		
		for(int i=0; i<sample1.length(); i++) {
			if(sample1.charAt(i) == '(') {
				charStack.add(sample1.charAt(i));
			}else {
				if(sample1.charAt(i) == ')') {
                  if(charStack.pop() != '(') {
                  	return false;
                  }
			}
		}
	}
		return charStack.size() == 0;

	}
	public static boolean isEqual2(String sample2) {
		Stack<Character> charStack = new Stack<>();
		
		for(int i=0; i<sample2.length(); i++) {
			if(sample2.charAt(i) == '(') {
				charStack.add(sample2.charAt(i));
			}else {
				if(sample2.charAt(i) == ')') {
                  if(charStack.pop() != '(') {
                  	return false;
                  }
			}
		}
	}
		return charStack.size() == 0;

	}
	
	public static boolean isEqual3(String sample3) {
		Stack<Character> charStack = new Stack<>();
		
		for(int i=0; i<sample3.length(); i++) {
			if(sample3.charAt(i) == '(') {
				charStack.add(sample3.charAt(i));
			}else {
				if(sample3.charAt(i) == '(') {
                  if(charStack.pop() == ')') {
                  	return false;
                  }
			}
		}
	}
		return charStack.size() == 0;

	}
	public static boolean isEqual4(String sample4) {
		Stack<Character> charStack = new Stack<>();
		
		for(int i=0; i<sample4.length(); i++) {
			if(sample4.charAt(i) ==( '(' | '<'| '{')) {
				charStack.add(sample4.charAt(i));
			}else {
				if(sample4.charAt(i) ==( ')' | '>'|'}')) {
                  if(charStack.pop() != ('(' | '<'| '{')) {
                  	return false;
                  }
			}
		}
	}
		return charStack.size() == 0;

	}	

	public static boolean isEqual5(String sample5) {
		Stack<Character> charStack = new Stack<>();
		
		for(int i=0; i<sample5.length(); i++) {
			if(sample5.charAt(i) ==( '(' & '<'& '{' &'[')) {
				charStack.add(sample5.charAt(i));
			}else {
				if(sample5.charAt(i) ==( ')' & '>'&'}' & ']')) {
                  if(charStack.pop() != ('(' & '<'& '{' & '[')) {
                  	return false;
                  }
			}
		}
	}
		return charStack.size() == 0;

	}	
	public static boolean isEqual6(String sample6) {
		Stack<Character> charStack = new Stack<>();
		
		for(int i=0; i<sample6.length(); i++) {
			if(sample6.charAt(i) ==( '(' & '<'& '{' &'[' )) {
				charStack.add(sample6.charAt(i));
			}else {
				if(sample6.charAt(i) ==( ')' & '>'&'}' & ']' )) {
                  if(charStack.pop() != ( '(' & '<'& '{' &'[' )) {
                  	return false;
                  }
			}
		}
	}
		return charStack.size() == 0;

	}	
	public static boolean isEqual7(String sample7) {
		
		
			if(sample7 == null) {
				return false;
			}

		return false;
		}
	}
		
 