package javainterviewquestion1;
		public class SumOfDigitsExample4  {
				//function that finds the sum of digits of a number  
		static int findSum(int number)  {
				//variable that stores the sum          
		int sum=0;      
		//calculates sum in a single line  
		for (; number > 0; sum = sum + number % 10, number = number / 10);  
		//returns the sum  
		return sum;  
		}  
		//driver code  
		public static void main(String args[])  
		{  
		int number = 7812089;  
		//calling the user-defined method and prints the result   
		System.out.println("The sum of digits: "+findSum(number));  
		}  
		 

	}


