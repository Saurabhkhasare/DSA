package sorting;

public class QuickSort {
	public static void quickSort(int arr[], int left, int right) {
		// 0.Base Condition--If partition has single element OR invalid partition
		if (left >= right)
			return;
		// Consider left element as pivot = arr[left](Pivot can be left/right/median
		// element)
		int pivot = left;
		int i = left, j = right;
		while (i < j) {
			// 1. From left(i-index),Find element greater than pivot
			while (i <= j && arr[i] <= arr[pivot])
				i++;
			// 2. From right(j-index), Find element lesser or equal than pivot
			while (arr[j] > arr[pivot])
				j--;
			// 3. Iff i less than j, swap i-th element with j-th element
			if (i < j)
				swap(arr, i, j);
			// 4. Repeat step 1-3, till i < j
		}
		// 5. Swap j-th element with pivot element
		swap(arr, j, pivot);
		// 6. Apply quickSort on left partition - (Left to j-1)
		quickSort(arr, left, j - 1);
		// 7. Apply quickSort on right partition - (j+1 to Right)
		quickSort(arr, j + 1, right);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
