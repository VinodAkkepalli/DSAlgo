package practice.dynamicprogramming.knapsackunbounded;

import java.util.Arrays;

/**
 * 
 * @author Vinod Akkepalli
 * 
 *         Problem Description: Given a rod of length n inches and an array of
 *         prices that contains prices of all pieces of size smaller than n.
 *         Determine the maximum value obtainable by cutting up the rod and
 *         selling the pieces
 *         https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 */

public class CuttingRodProblem {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 20, 22, 24, 26 };
		System.out.println("Maximum Obtainable Value is " + cuttingRodRec(arr, arr.length));

		int[] optPrice = new int[arr.length + 1];
		Arrays.fill(optPrice, Integer.MIN_VALUE);
		System.out.println("Maximum Obtainable Value is " + cuttingRodDPTD(arr, optPrice, optPrice.length - 1));

		int[] optPrice1 = new int[arr.length + 1];
		Arrays.fill(optPrice1, Integer.MIN_VALUE);
		System.out.println("Maximum Obtainable Value is " + cuttingRodDPBU(arr, optPrice1, optPrice1.length - 1));
	}

	// Recursive solution with exponential time complexity
	private static int cuttingRodRec(int[] arr, int size) {

		if (size <= 0) {
			return 0;
		}
		int arrLength = arr.length;
		int maxValue = Integer.MIN_VALUE;

		for (int i = 0; (i < arrLength && i < size); ++i) {
			maxValue = Math.max(maxValue, arr[i] + cuttingRodRec(arr, size - 1 - i));
		}

		return maxValue;
	}

	// Dynamic Programming Top-Down solution
	private static int cuttingRodDPTD(int[] arr, int[] optPriceArray, int size) {

		if (size <= 0) {
			return 0;
		}
		if (optPriceArray[size] != Integer.MIN_VALUE) {
			return optPriceArray[size];
		}
		int arrLength = arr.length;
		int maxValue = Integer.MIN_VALUE;

		for (int i = 0; (i < arrLength && i < size); ++i) {
			maxValue = Math.max(maxValue, arr[i] + cuttingRodDPTD(arr, optPriceArray, size - 1 - i));
		}
		optPriceArray[size] = maxValue;
		return optPriceArray[size];
	}

	// Dynamic Programming Bottom-Up solution TC: O(n^2)
	private static int cuttingRodDPBU(int[] arr, int[] optPriceArray, int size) {

		// optimum price for length 0 is 0
		optPriceArray[0] = 0;

		// Loop over optPriceArray to find optimum price for length i optPriceArray[i]
		for (int i = 1; i <= size; ++i) {
			// j to Loop over arr of prices
			for (int j = 0; j < i; ++j) {
				optPriceArray[i] = Math.max(optPriceArray[i], arr[j] + optPriceArray[i - j - 1]);
			}
		}
		// System.out.println(Arrays.toString(optPriceArray));
		return optPriceArray[size];
	}
}
