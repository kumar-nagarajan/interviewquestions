package javainterviewquestion1;

public class SecondSmallestNumberInArray {

	public static void main(String[] args) {
		int[] array = new int[5];
		array[0] = 100;
		array[1] = 600;
		array[2] = 800;
		array[3] = 500;
		array[4] = 400;

		secondSmallestNumber(array);
	}

	public static void secondSmallestNumber(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(arr[1]);
	}

}
