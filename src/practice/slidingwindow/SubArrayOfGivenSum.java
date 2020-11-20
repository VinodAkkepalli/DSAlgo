package practice.slidingwindow;

/**
 * 
 * @author VinodAkkepalli
 * 
 * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found

Method (Efficient) O(n)
Initialize a variable curr_sum as first element. curr_sum indicates the sum of current subarray. 
Start from the second element and add all elements one by one to the curr_sum. 
If curr_sum becomes equal to sum, then print the solution. If curr_sum exceeds the sum, then remove trailing elemnents 
while curr_sum is greater than sum.
 * 
 *
 */

public class SubArrayOfGivenSum {

	public static void main(String[] args) {
		int[] arr = {2, 4, 20, 3, 10, 5};
		//int[] arr = {1, 4, 0, 0, 3, 10, 5};
		int sum = 27;
		
		findSubArray(arr, sum);
	}

	private static void findSubArray(int[] arr, int sum) {
		int curr_sum = arr[0];
		int arrLen = arr.length;
		int start = 0;    // to point to starting index

		for (int i = 1; i <= arrLen; i++) {
			// If curr_sum exceeds the sum, then remove the starting elements
			while (curr_sum > sum && start < i - 1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			// If curr_sum becomes equal to sum, then return
			if (curr_sum == sum) {
				System.out.println("Sum found between indexes " + start + " to " + (i - 1));
				return;
			}

			// Add this element to curr_sum
			if (i < arrLen) {
				curr_sum = curr_sum + arr[i];
			}
		}

		// If we reach here, then no subarray
		System.out.println("No subarray found");
	}
}
