package interviewQuestions;

import java.util.ArrayList;
import java.util.TreeSet;

public class LargestSmallestSumAvgInArray {

	public static void main(String[] args) {
		int[] nums = { 1, 121, 321, 5, 11, 5, 12, 15, 1, 21, 5, 21, 113, 5, 111, 2, 1 };
		System.out.println("Largest "+findLargest(nums));
		System.out.println("Smallest: "+ findSmallest(nums));
		System.out.println("Sum "+ sumOfValues(nums));
		System.out.println("Average "+ avgOfValues(nums));
		System.out.println("Second Largest: "+ secondLargest(nums));
		System.out.println("Second Smallest: "+ secondSmallest(nums));
	
	}

	public static int findLargest(int[] nums) {
		int largest = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (largest < nums[i]) {
				largest = nums[i];
			}
		}
		return largest;
	}

	public static int findSmallest(int[] nums) {
		int smallest = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (smallest > nums[i]) {
				smallest = nums[i];
			}
		}
		return smallest;
	}

	public static int sumOfValues(int[] nums) {
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}

	public static double avgOfValues(int[] nums) {
		return (double) sumOfValues(nums) / nums.length;
	}

	public static int secondLargest(int[] nums) {
		int secondLargest = nums[0];
		int largest = findLargest(nums);

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < largest && secondLargest < nums[i]) {
				secondLargest = nums[i];
			}
		}
		return secondLargest;
	}
	
	public static int secondSmallest(int[] nums) {
        int secondSmallest = Integer.MAX_VALUE;

		//int secondSmallest = nums[0];
		int smallest = findSmallest(nums);

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > smallest && secondSmallest > nums[i]) {
				secondSmallest = nums[i];
			}
		}
		return secondSmallest;
	}
	
	
	//find the largest value in the array given at  position p that is given
	//ex:{1,2,3} p1 = 3,
	/*
	 * public static int findLargestWithPosition(int[] numbers, int p) {
	 * 
	 * TreeSet<Integer> temp = new TreeSet<>();
	 * 
	 * for (int i = 0; i < numbers.length; i++) { temp.add(numbers[i]); }
	 * if(p-1>numbers.length) { System.out.println("Does not exist"); return -1; }
	 * 
	 * ArrayList<Integer> numsSorted = new ArrayList<Integer>(temp); return
	 * numsSorted.get(numsSorted.size()-p);
	 * 
	 * int counter = 1; for (Integer num : temp) { if(p==counter++) { return num; }
	 * } return temp; }
	 */
}
