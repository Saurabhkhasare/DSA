package Assignment8;


import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			// implement here any DS
			while (!exit) {
				try {
					System.out.println("Enter a choice:\n"
							+ "1.Find Sum Of Digit of Number\n"
							+ "2.Find Square Of Number\n"
							+ "3.Find the factorial of Number\n"
							+ "4.To Check the num is Palindrom\n"
							+ "0.Exit ");
					switch (sc.nextInt()) {
					case 1:System.out.println("Enter a number: ");
						int result = sum(sc.nextInt());
						System.out.println("Sum of digit :" + result);
						break;
					case 2:
						System.out.println("Enter a number: ");
						result = square(sc.nextInt());
						System.out.println("Square of number :" + result);
						break;
					case 3:
						System.out.println("Enter a number: ");
						result = fact(sc.nextInt());
						System.out.println("Square of number :" + result);
						break;
					case 4:
						System.out.println("Enter a number: ");
						System.out.println("Number is Palindrom :" + isPalindrome(sc.nextInt()));
						break;
					case 0:
						exit = true;
						System.out.println("Thanks,Exiting!!!!");
						break;
					default:
						System.out.println("Invalid choice!!!!");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
					System.out.println("Please try again!!!");
				}
			}
		}
	}

	 public static boolean isPalindrome(int num) {
	        String str = Integer.toString(num);
	        return checkPalindrome(str, 0, str.length() - 1);
	    }

	    private static boolean checkPalindrome(String str, int start, int end) {
	        if (start >= end) {
	            return true;
	        } else if (str.charAt(start) != str.charAt(end)) {
	            return false;
	        } else {
	            return checkPalindrome(str, start + 1, end - 1);
	        }
	    }
	private static int fact(int num) {
		if(num==0)
			return 1;
		int res = num*fact(num-1);
		return res;
	}

	private static int square(int num) {
		if(num==0)
			return 0;
		int res = num + square(num-1) + (num - 1);
		return res;
	}

	private static int sum(int num) {
		//Base condition
		if(num==0)
			return 0;
		//recursive condition
		int res = num%10 + sum(num/10);
		return res;
	}

}