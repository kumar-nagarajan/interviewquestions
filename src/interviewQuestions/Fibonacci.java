package interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibNums(56));

	}
	
	public static List<Integer> fibNums(int max){
		
	List<Integer> nums = new ArrayList<Integer>();
		nums.add(0);
		nums.add(1);
		 int currentNum = 0;
		 while(true) {
			 currentNum = nums.get(nums.size() - 2) + nums.get(nums.size() - 1);
			 if(currentNum > max) {
		     break;
		 }nums.add(currentNum);
		 }
return nums;
	}

}
