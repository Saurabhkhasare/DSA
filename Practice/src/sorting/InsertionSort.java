package sorting;

public class InsertionSort {
	public static void insertionSort(int []arr) {
		//1. For N elements iterate a loop
		for(int i = 0;i <=arr.length-1;i++) {
			//2. Storing the elements in a key
			int key = arr[i];
			int j;
			//3. compare it with all elements from before the key index(i-1) to first element of the array
			for(j = i-1; j>=0 && arr[j]>key;j--) {
				//3.1If element is greater then key , then RIGHT SHIFT the array
				arr[j+1]  = arr[j];
			}
			//HERE j becomes -1 if all previous element are greater than key, 
			//OTHERWISE j is at where element is equal or less then key element
			
			//3.2 So just add key at its Appropriate position which is after the j index(which is equal to or smaller than key)
			arr[j+1] = key;
		}
		
	}
}
