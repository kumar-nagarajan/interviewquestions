package interviewQuestions;

public class ReversingArrayOfString {

	public static void main(String[] args) {
		String[] arr ={"test1", "test2", "test3"};
		String[] result=new String[arr.length];
		int x=0;		
		for (int i = arr.length-1; i >= 0; i--) {
		result[x++] = arr[i];
		System.out.print(arr[i]+" ");
       /*  String [] words = {"test1", "test2","test3" };
	    // for(String s: revStringArray(words)) {
	    	// System.out.print(s+" ");
	   //  }
	   
         
	//public static String[] revStringArray(String [] strArr) {
		String [] temp = new String[words.length];
		int x = 0;
		
		for (int i = words.length-1; i >= 0; i--) {
			temp[x++] = words[i];
			System.out.print(words[i]+" ");*/
		}
		
		
		//return temp;
	}

	
	
}
