package searching;

import java.util.Scanner;

public class Linear_searching {
private static int linearSearch(int arr[],int key) {
	for(int i=0;i<arr.length;i++) {
		if(arr[i]==key)
			return i+1;
	}
	return -1;
}
	public static void main(String[] args) {
		int []arr = {88,22,33,44,66,11,99,55};
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a number to be found");
		int key = sc.nextInt();
		int found = linearSearch(arr, key);
		if(found==-1)
			System.out.println("No element found!!!");
		else
			System.out.println("index position of "+arr[found]+" is: "+found);
		sc.close();
	}

}
