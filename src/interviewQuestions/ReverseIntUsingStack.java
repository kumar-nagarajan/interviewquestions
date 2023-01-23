package interviewQuestions;

import java.util.Stack;

public class ReverseIntUsingStack {

	public static void main(String[] args) {
		
		
	System.out.println(revInt(12345));	
	}	
		public static int revInt(int num) {
		int temp = 0;
		Stack<Integer> tempStack = new Stack<Integer>();
		
		while(num!=0) {
			tempStack.add(num % 10);
			num /= 10;
			temp = temp * 10 + tempStack.pop();
		}
		
		return temp;

	}

}
