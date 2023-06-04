package javainterviewquestion1;

public class PrimenumberorNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a=17;
int count=0;
for(int i=2;i<=a/2;i++) {
	if(a%i==0) {
		count++;
	}
}if(count==0) {
	System.out.println( a +" is a prime number");
}else {
	System.out.println( a +" is not a prime number");
}
	}

}
