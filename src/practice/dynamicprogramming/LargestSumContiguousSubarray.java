package practice.dynamicprogramming;

/**
 * 
 * @author VinodAkkepalli
 *
 *         Problem Statement: Find a maximum sum in a largest contiguous
 *         subarray
 *         http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 
 *         Solution: Follow dynamic programming approach to store previous max
 *         to compare with current
 *
 *         TC: O(n)
 */

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {

		int[] a = { 10, -3, 4, -1, -2, 1, 5, -3 };
		// int[] a = {-3, -2, 3, 10, -4, 7, 2, -5};

		System.out.println("Maximum sum is: " + maxSubArraySum(a));
	}

	private static int maxSubArraySum(int[] a) {

		// Dynamic Programming approach which takes up O(n) time complexity
		int arrLength = a.length;
		// variable to store maximum after including ith element
		int currentMax = a[0];
		// variable to store global maximum achieved after comparing with currentMax
		int maxSoFar = a[0];

		for (int i = 1; i < arrLength; i++) {
			currentMax = Math.max(a[i], currentMax + a[i]);
			maxSoFar = Math.max(maxSoFar, currentMax);
		}

		return maxSoFar;
	}

}
