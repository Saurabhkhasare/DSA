package searching;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveBinarySearch {

	private static int recursiveBinarySearch(int[] arr,int left,int right, int key) {
	
		if(right<left)
			return -1;
		int index;
		int mid = (left + right)/2;
		if(key==arr[mid])
			return mid;
		if(key<arr[mid])
			index = recursiveBinarySearch(arr, left, mid-1, key);
		else
			index = recursiveBinarySearch(arr, mid+1, right, key);
		return index;
	}

	public static void main(String[] args) {
		int[] arr = { 88, 22, 33, 44, 66, 11, 99, 55 };
		Arrays.sort(arr);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to be found");
		int key = sc.nextInt();
		int found = recursiveBinarySearch(arr,0,arr.length-1, key);
		if (found == -1)
			System.out.println("No element found!!!");
		else
			System.out.println("index position of " + arr[found] + " is: " + found);
		sc.close();

	}

}
