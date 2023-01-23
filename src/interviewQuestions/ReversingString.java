package interviewQuestions;

public class ReversingString {

	public static void main(String[] args) {
		String sample = "this is a test String";
		revStringMethod(sample);
		System.out.println(revStringMethod2(sample));
		String stringinput = "Independent";
	    // convert String to character array
	    // by using toCharArray
	    char[] resultarray = stringinput.toCharArray();
	    //iteration
	    for (int i = resultarray.length - 1; i >= 0; i--) {
	     // print reversed String
	        System.out.print(resultarray[i]);
		

	}System.out.println();
	    String str = "Independent";
	    StringBuffer sb = new StringBuffer(str);
System.out.println(sb.reverse());
	    }

	public static void revStringMethod(String str) {
		StringBuffer sb = new StringBuffer(str);
		//sb.reverse();
        //return String.valueOf(sb.reverse());
		System.out.println(sb.reverse());

	}
	
	public static String revStringMethod2(String str) {
		String rev = "";
		for(int i = str.length() - 1; i>=0; i--) {
             rev+=str.charAt(i);
             }
		return rev;
		
	}
	
}
