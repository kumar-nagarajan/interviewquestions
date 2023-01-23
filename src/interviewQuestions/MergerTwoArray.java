package interviewQuestions;

public class MergerTwoArray {

	public static void main(String[] args) {
		int a[]={30,25,40};
		int b[]= {10,50,70};
		int al=a.length;
		int bl=b.length;
		int cl=al+bl;
		int c[]=new int[cl];
		for (int i=0;i<al;i++) {
			c[i]=a[i];
		}
		for(int i=0;i<bl;i++) {
			c[al+i]=b[i];
		}
			for( int i=0;i<cl;i++) {
				System.out.print(c[i]+" ");
		}
		
		
	}

	}
