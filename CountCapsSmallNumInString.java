package javainterviewquestion1;

public class CountCapsSmallNumInString {

	public static void main(String[] args) {
		String str = "Aa12@#Bb56**";
		String small = "", caps = "", digits = "", splChar = "";
		int s = 0, c = 0, d = 0, sc = 0;

		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);

			if (Character.isUpperCase(a)) {
				caps = caps + a;
				c++;
			} else if (Character.isLowerCase(a)) {
				small = small + a;
				s++;
			} else if (Character.isDigit(a)) {
				digits = digits + a +" ,";
				d++;
			} else {
				splChar = splChar + a;
				sc++;
			}

		}
		System.out.println("Small letters : " + small + "  Count :" + s);
		System.out.println("Capital letters : " + caps + "  Count :" + c);
		System.out.println("Digits : " + digits + "  Count :" + d);
		System.out.println("Spl characters letters : " + splChar + "  Count :" + sc);

		

	}

}
