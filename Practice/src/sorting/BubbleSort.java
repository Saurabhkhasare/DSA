package sorting;

public class BubbleSort {
	
	public static void bubbleSort(int arr[]) {
		//1.For each element until length-1(last element always sorted if all other are sorted)
		for (int i = 0; i < arr.length - 1; i++) {
			//2. compare adjacent elements
			for (int j = 0; j < arr.length-1; j++) {
				//3. swapping if they are in wrong order
				if (arr[j] > arr[j + 1])
					swap(arr, j, j+1);
			}
		}
	}
	
	public static void improvedBubbleSort(int arr[]) {
		//1.For each element until length-1(last element always sorted if all other are sorted)
		for (int i = 0; i < arr.length - 1; i++) {
			//2. compare adjacent elements
			for (int j = 0; j < arr.length-1-i; j++) {	//length-1-i BECAUSE,
				// At each iteration--> last element is sorting  
				//3. swapping if they are in wrong order
				if (arr[j] > arr[j + 1])
					swap(arr, j, j+1);
			}
		}
	}
	
	//It is useful when array is sorted at ANY PASS
	public static void moreImprovedBubbleSort(int arr[]) {
		//1.For each element until length-1(last element always sorted if all other are sorted)
		for (int i = 0; i < arr.length - 1; i++) {
			boolean swapFlag = false;
			//2. compare adjacent elements
			for (int j = 0; j < arr.length-1-i; j++) {	//length-1-i BECAUSE,
				// At each iteration--> last element is sorting  
				//3. swapping if they are in wrong order
				if (arr[j] > arr[j + 1]) {
					swapFlag = true;
					swap(arr, j, j+1);
				}
			}
			//checkig the swapping happend or not if not that means array is sorted
			if(!swapFlag)
				return;
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}