/**
 * Using merge sort to sort large numbers array
 * 
 * @author Chen Wang
 *
 */
public class SortNumbers {

	/**
	 * create a temporary array which has same size of passed array
	 * 
	 * @param randomArray array need to be sorted
	 */
	public static void sort(int[] randomArray) {
		int[] temp = new int[randomArray.length];
		sort(randomArray, 0, randomArray.length - 1, temp);
	}

	/**
	 * divide array to two parts and sort each part separately
	 * 
	 * @param array array need to be sorted
	 * @param left start pointer of array
	 * @param right end pointer of array
	 * @param temp used to save temporary array
	 */
	private static void sort(int[] array, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(array, left, mid, temp);
			sort(array, mid + 1, right, temp);
			merge(array, left, mid, right, temp);
		}
	}

	/**
	 * Merge both sides array and make sure the data is still sorted 
	 * 
	 * @param array array need to be merged
	 * @param left start pointer of array
	 * @param mid middle pointer of array
	 * @param right end pointer of array
	 * @param temp used to save temporary array
	 */
	private static void merge(int[] array, int left, int mid, int right, int[] temp) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		
		// Compare two arrays data one by one then put in temporary array
		while (i <= mid && j <= right) {
			if (array[i] <= array[j]) {
				temp[t++] = array[i++];
			} else {
				temp[t++] = array[j++];
			}
		}
		
		// add remain data of each array to temporary array
		while (i <= mid) {
			temp[t++] = array[i++];
		}
		while (j <= right) {
			temp[t++] = array[j++];
		}
		
		// Loop temp and put in original array in descending order
		for (i = 0; i < t; i++) {
			array[left + i] = temp[i];
        }
		
	}

}
