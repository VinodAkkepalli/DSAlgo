package codingcontest;

/**
 * 
 * @author Vinod Akkepalli
 *
 *         Problem Description: Check for Majority Element in a sorted array
 *         https://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/
 *         TC: O(log n)
 */

public class MajorityElement {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 3, 3, 3, 10 };
		int x = 3;
		isMajority(arr, x);
	}

	// returns true if the x is present more than n/2 times in arr
	static void isMajority(int arr[], int x) {
		boolean result = false;
		int arrLength = arr.length;
		int arrHalfLength = arrLength / 2;

		// finds the index of first occurrence of x in arr
		int i = MyBinarySearch(arr, 0, arrLength - 1, x);

		// result false if element is not present
		if (i == -1) {
			result = false;
		} else if (((i + arrHalfLength) <= (arrLength - 1)) && arr[i + arrHalfLength] == x)
			// element found; then check if element is present more than n/2 times
			result = true;
		else {
			// case where element is not present more than n/2 times
			result = false;
		}

		System.out.println(result);
	}

	// If x is present in arr[low...high] then returns the index of first occurrence
	// of x, otherwise returns -1
	static int MyBinarySearch(int arr[], int low, int high, int x) {

		if (high >= low) {
			int mid = (low + high) / 2;

			// arr[mid] is first occurrence of x if one of the following is true:
			// (i) mid == 0 and arr[mid] == x
			// (ii) arr[mid-1] < x and arr[mid] == x
			if ((mid == 0 && arr[mid] == x) || (arr[mid - 1]) < x && arr[mid] == x)
				return mid;
			else if (x > arr[mid])
				return MyBinarySearch(arr, (mid + 1), high, x);
			else
				return MyBinarySearch(arr, low, (mid - 1), x);
		}

		return -1;
	}
}
