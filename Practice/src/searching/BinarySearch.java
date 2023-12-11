package searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	private static int binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		int mid ;
		while (left <= right) {
			 mid = (left + right) / 2;
			if (arr[mid] == key)
				return mid;
			else {
				if (key < arr[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 88, 22, 33, 44, 66, 11, 99, 55 };
		Arrays.sort(arr);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to be found");
		int key = sc.nextInt();
		int found = binarySearch(arr, key);
		if (found == -1)
			System.out.println("No element found!!!");
		else
			System.out.println("index position of " + arr[found] + " is: " + found);
		sc.close();

	}

}
