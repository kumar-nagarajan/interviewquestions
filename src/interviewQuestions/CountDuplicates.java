package interviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicates {

	public static void main(String[] args) {
		String [] data= {"test" , "take" , "nice" , "pass" , "test" , "nice"};
		countDuplicatesInArray(data);

	}
	
	public static void countDuplicatesInArray(String[] data) {
		Map<String, Integer> temp = new HashMap<String, Integer>();
		Map<String, Integer> duplicates = new HashMap<String, Integer>();
		      for(int i = 0; i<data.length ; i++) {
		    	 
		    	  if(temp.containsKey(data[i])) {
		    		  temp.put(data[i], temp.get(data[i])+1);
		    	  }else {
		    		  temp.put(data[i],1);
		    	  }
		      }
		      
		      for(String key : data) {
		    	  if(temp.get(key) > 1) {
		    		  duplicates.put(key, temp.get(key));
		    	  }
		      }
	    	  System.out.println(duplicates);

	}

}
