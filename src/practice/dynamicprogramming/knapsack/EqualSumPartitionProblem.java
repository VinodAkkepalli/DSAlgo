package practice.dynamicprogramming.knapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * @author Vinod Akkepalli
 *	Problem Description: Determine whether a given set can be partitioned into two subsets such that
 *	the sum of elements in both subsets is same.
 *	https://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 *	https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
 */

public class EqualSumPartitionProblem {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 5, 9, 12 };
		int arrLen = arr.length;

		if (findPartitionDPBU(arr, arrLen)) {
			System.out.println("Array can be divided into two subsets of equal sum");
		} else {
			System.out.println("Array can not be divided into two subsets of equal sum");
		}

		if (findPartitionRec(arr, arrLen)) {
			System.out.println("Array can be divided into two subsets of equal sum");
		} else {
			System.out.println("Array can not be divided into two subsets of equal sum");
		}

	}

	// DP Approach with TC O(Sum*arrLen)
	// Returns true if arr[] can be partitioned in two subsets of equal sum
	static boolean findPartitionDPBU(int[] arr, int arrLen) {
		int sum = Arrays.stream(arr).sum();

		if (sum % 2 != 0) {
			return false;
		}
		
		int half = sum/2;
		
		// part[i][j] is true if there sum i can be achieved with first j elements or arr
		boolean[][] part = new boolean[half + 1][arrLen + 1];

		// initialize top row as true
		IntStream.range(0,arrLen+1).forEach(i -> part[0][i] = true);

		// initialize leftmost column, except part[0][0] as false
		IntStream.range(1,half+1).forEach(i -> part[i][0] = false);

		// Fill the partition table in bottom up manner
		for (int i = 1; i <= half; i++) {
			for (int j = 1; j <= arrLen; j++) {
				
				part[i][j] = part[i][j - 1];
				if (i >= arr[j - 1]) {
					part[i][j] = part[i][j] || part[i - arr[j - 1]][j - 1];
				}
			}
		}

		//for (int i = 0; i <= arrLen; i++) {System.out.println(Arrays.toString(part[i]));}
		Arrays.stream(part).forEach(i->System.out.println(Arrays.toString(i)));
		return part[half][arrLen];
	}

	// Returns true if arr[] can be partitioned in two subsets of equal sum
	private static boolean findPartitionRec(int[] arr, int arrLen) {

		// Calculate sum of the elements in array
		int sum = Arrays.stream(arr).sum();

		// If sum is odd, there cannot be two subsets with equal sum
		if (sum % 2 != 0) {
			return false;
		}

		// Find if there is subset with sum equal to half of total sum
		return isSubsetSumRec(arr, arrLen, sum / 2);
	}

	// Recursive approach with TC O(2^n)
	// returns true if there is a subset of arr[] with sum equal to given sum
	static boolean isSubsetSumRec(int[] arr, int n, int sum) {
		// Base Cases
		if (sum == 0) {
			return true;
		}
		if (n == 0) {
			return false;
		}

		// If last element is greater than sum, then ignore it
		if (arr[n - 1] > sum) {
			return isSubsetSumRec(arr, n - 1, sum);
		}

		// else, check if sum can be obtained by any of the following
		// (a) including the last element (b) excluding the last element
		return isSubsetSumRec(arr, n - 1, sum) || isSubsetSumRec(arr, n - 1, sum - arr[n - 1]);
	}
}
