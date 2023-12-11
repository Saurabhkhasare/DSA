package sorting;

public class SelectionSort {
	public static void selectionSort(int arr[]) {
		
		for(int i =0;i<arr.length-1;i++) {	//if n-1 elements sorted then n-th element is already sorted so length-1
		//1.Choosing element and comparing with all other one's
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j])	//it will give ascending order
					swap(arr,i,j);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
