package sorting;
import sorting.MergeSort;
import java.util.Arrays;
public class SortingTester {

	public static void main(String[] args) {
		int arr[] = {8,3,9,1,5,7,2,6,4};
		System.out.println("*****Merge Sort*****");
		System.out.println("Before sorting: " + " " + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length-1);
		System.out.println("After sorting: " + " " + Arrays.toString(arr));
		System.out.println("------------------------------------------------");
		
		int arr1[] = {4,3,2,1};
		System.out.println("*****Quick Sort*****");
		System.out.println("Before sorting: " + " " + Arrays.toString(arr1));
		quickSort(arr1, 0, arr1.length-1);
		System.out.println("After sorting: " + " " + Arrays.toString(arr1));
		System.out.println("------------------------------------------------");
		
		int arr2[] = {8,3,9,1,5,7,2,6,4};
		System.out.println("*****Selection Sort*****");
		System.out.println("Before sorting: " + " " + Arrays.toString(arr2));
		selectionSort(arr2);
		System.out.println("After sorting: " + " " + Arrays.toString(arr2));
		System.out.println("------------------------------------------------");

		int arr3[] = {5,4,3,2,1};
		System.out.println("*****Bubble Sort*****");
		System.out.println("Before sorting: " + " " + Arrays.toString(arr3));
		bubbleSort(arr3);
		System.out.println("After sorting: " + " " + Arrays.toString(arr3));
		System.out.println("------------------------------------------------");
		
		int arr4[] = {8,3,9,1,5,7,2,6,4};
		System.out.println("*****Imporved Bubble Sort*****");
		System.out.println("Before sorting: " + " " + Arrays.toString(arr4));
		improvedBubbleSort(arr4);
		System.out.println("After sorting: " + " " + Arrays.toString(arr4));
		System.out.println("------------------------------------------------");
		
		int arr5[] = {1,2,3,4};
		System.out.println("*****More Imporved Bubble Sort*****");
		System.out.println("Before sorting: " + " " + Arrays.toString(arr5));
		moreImprovedBubbleSort(arr5);
		System.out.println("After sorting: " + " " + Arrays.toString(arr5));
		System.out.println("------------------------------------------------");

		int arr6[] = {4,8,9,3,1,7,2,6};
		System.out.println("*****Insertion Sort*****");
		System.out.println("Before sorting: " + " " + Arrays.toString(arr6));
		insertionSort(arr6);
		System.out.println("After sorting: " + " " + Arrays.toString(arr6));
		System.out.println("------------------------------------------------");
	}

	

}

