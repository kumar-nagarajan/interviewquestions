package javainterviewquestion1;

public class SumofNumberGiven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int num=12321;
int sum=0;
while(num>0) {
	int n=num%10;
	sum=sum+n;
	num/=10;
}//System.out.println("sum of number"+sum);

String number = "a12b15c12";
SumofNumberGiven sn = new SumofNumberGiven();
System.out.println(sn.sumOfDigits(number));	
}

public  int sumOfDigits(String str) {
	int sum =0;
	for(int i = 0; i < str.length() ; i++) {
		if(Character.isDigit(str.charAt(i))) {
			String temp = str.substring(i, i+1);
			sum += Integer.parseInt(temp);
		}
	}
	return sum ;
}
//	int num=12321;
//	int count=0;
//	while(num>0) {
//		count++;
//		num/=10;
//	}System.out.println("count the digits"+count);

	
}
