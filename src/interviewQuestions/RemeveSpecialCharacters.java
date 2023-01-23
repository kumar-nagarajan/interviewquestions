package interviewQuestions;

public class RemeveSpecialCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sample = "%$#$APPLE $%^^ java111";
		System.out.println(removeSpecialChars(sample));
		//System.out.println(sample.replaceAll("[^ A-Za-z0-9]",""));
		
	}
	
	public static String removeSpecialChars(String str) {
		return str.replaceAll("[^ A-Za-z0-9]","");
	}

}
