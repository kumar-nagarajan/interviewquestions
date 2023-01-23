package interviewQuestions;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class FindDuplicatesInArray {

	public static void main(String[] args) {
		String[] data = { "test", "take", "nice", "pass", "take", "test" };
		findDuplicates(data);
		findDuplicates2(data);

	}
	
		
	public static void findDuplicates(String[] data) {

		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].equals(data[j])) {
					System.out.println("Duplicates found: " + data[i] + " On indexes " + i + " and " + j);
				}
			}
		}
	}
	
	public static void findDuplicates2(String[] data) {
		Set<String> temp = new HashSet<>();
		//Set<String> temp = new LinkedHashSet<String>();
		//Set<String> temp = new TreeSet<String>();
		for(int i = 0; i<data.length; i++) {
			if(!temp.add(data[i])) {
				System.out.println("Duplicates found: " + data[i] + " On index " + i);

			}
		}
	}
}
