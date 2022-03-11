package ca.number;

/**
 * Implement quick sort algorithms to sort random number
 * @author Chen Wang
 *
 */
public class QuickSort implements SortNumber 
{
	@Override
	public void sort(int[] array) 
	{
		if (array == null) {
			return;
		}
		int length = array.length;
		quickSort(array, 0, length - 1);
	}

	/**
	 * main code to implement quick sort
	 * @param array need to be sorted
	 * @param left start pointer of array
	 * @param right end pointer of array
	 */
	private void quickSort(int[] array, int leftIndex, int rightIndex) 
	{
		// only sort the array has more than one element
		if (leftIndex >= rightIndex) 
		{
			return;
		}
		
		// use the first element as pivot
		int pivot = array[leftIndex];
		int left = leftIndex, right = rightIndex;
		
		// scan both sides together until left equal right
		while (left != right) 
		{
			while (array[right] >= pivot && left < right) 
			{
				// find first element smaller than pivot from right to left
				right--;
			}

			// add the smaller element to left side
			array[left] = array[right];

			while (array[left] <= pivot && left < right) 
			{
				// find first element larger than pivot from left to right
				left++;
			}

			// add the larger element to right side
			array[right] = array[left];
		}

		// reset pivot position
		array[left] = pivot;

		// left side elements of pivot recursion
		quickSort(array, leftIndex, left - 1);
		// right side elements of pivot recursion
		quickSort(array, left + 1, rightIndex);

	}

}
