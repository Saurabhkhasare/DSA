package Recursion_1;

public class Factorial {

	public static int calfactorial(int n) {
		
		if(n==0 || n==1)
		{
			return 1;
		}
		int temp=calfactorial(n-1);
		int fact = n * temp;
		return fact;
	}
	public static void main(String[] args) {
		
		int n=5;
		int ans = calfactorial(n);
		System.out.println(ans);

	}

}
