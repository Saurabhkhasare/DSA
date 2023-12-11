package sorting;

public class MergeSort {
	public static void mergeSort(int arr[], int left, int right) {
		//BASE CONDITION OF RECURSION
		if(left >= right)
			return;
		// divide the array into two equal partition
		int mid = (left + right) / 2;
	//RECURSIVE CALLS start
		// sort left partition [left to mid]
		mergeSort(arr, left, mid);
		// sort right partition [ mid+1 to right]
		mergeSort(arr, mid+1, right);
	//RECURSIVE CALLS end
		// create a temporary array to accommodate both the partition [right - left + 1]
		int temp[] = new int[right - left + 1];
		// MERGE two sorted partition into temporary array
			int i = left, j = mid+1, k = 0;
			// -----MERGING----
			// Compare elements from both partition & copy the smaller one into temp array
			// (until any of the one partition is exhausted)
			while(i<=mid && j<=right) {
				if(arr[i]<arr[j])
					temp[k++] = arr[i++];
				else
					temp[k++] = arr[j++];
			}
			//copy remaining elements from other partition into temp array
			while(i <= mid)	//if RIGHT partition exhausted,coping LEFT partition elements
				temp[k++] = arr[i++];
			while(j <= right) //if LEFT partition exhausted,coping RIGHT partition elements
				temp[k++] = arr[j++];
		//Over write the original array from temp array
			for(i =0;i<temp.length;i++)
				arr[left + i] = temp[i];
			
	}
	
}
