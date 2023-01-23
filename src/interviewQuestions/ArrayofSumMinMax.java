package interviewQuestions;

public class ArrayofSumMinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 156, 5, 1, 75, 545 };
		// int index = 0;
		// I want to see the sum of all of the integers in the array
		int total = 0;
		int smallest = num[0];
		int largest = num[0];
		int count = num.length;
		double avg = 0;
		// while (index < num.length) {
		for (int i = 0; i< num.length; i++) {
			// print the value of each index
			System.out.print(num[i] + ", ");
			// adding the current value to the sum
			total = total + num[i];
			// current index value > max ==== then assign the current value to max
			if (num[i] > largest) {
				largest = num[i];
			}
			// current index value < min ==== then assign the current value to min
			if (num[i] < smallest) {
				smallest = num[i];
			}
			// index++;
		}
		// going to the next line
		System.out.println();
		// finding average
		avg = (double) total / count;
		// printing the results
		System.out.println("Total    : " + total);
		System.out.println("Smallest : " + smallest);
		System.out.println("Largest  : " + largest);
		System.out.println("Average  : " + avg);
		System.out.println("Count    : " + count);

	}

}
