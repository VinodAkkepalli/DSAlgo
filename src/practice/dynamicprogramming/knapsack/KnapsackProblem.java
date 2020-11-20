package practice.dynamicprogramming.knapsack;

import java.util.Arrays;

/**
 * 
 * @author Vinod Akkepalli
 * Problem Description: 0-1 Knapsack Problem
 * Given weights and values of n items, put these items in a knapsack of capacity W to
 * get the maximum total value in the knapsack
 * https://www.geeksforgeeks.org/knapsack-problem/
 *
 */
public class KnapsackProblem {

	public static void main(String[] args) {

		int[] values = new int[] { 60, 100, 120 };
		int[] weights = new int[] { 10, 20, 30 };
		int requiredWeight = 50;
		int valuesLength = values.length;
		System.out.println("Highest value is: " + knapSackRec(requiredWeight, weights, values, valuesLength));

        int[][] dp = new int[valuesLength+1][requiredWeight+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        knapSackDPTD(requiredWeight, weights, values, valuesLength, dp);
        System.out.println("Highest value is: " + dp[valuesLength][requiredWeight]);

        System.out.println("Highest value is: " + knapSackDPBU(requiredWeight, weights, values, valuesLength));
	}

	private static int knapSackRec(int requiredWeight, int[] weights, int[] values, int length) {

		if (length == 0 || requiredWeight == 0) {
			return 0;
		}

		if (weights[length - 1] <= requiredWeight) {
			return Math.max(
					values[length - 1] + knapSackRec(requiredWeight - weights[length - 1], weights, values, length - 1),
					knapSackRec(requiredWeight, weights, values, length - 1));
		} else {
			return knapSackRec(requiredWeight, weights, values, length - 1);
		}
	}

    // Dynamic programming Top-Down solution with TC O(requiredWeight * length)
    // Returns the maximum value that can be put in a knapsack of capacity requiredWeight
    private static int knapSackDPTD(int requiredWeight, int[] weights, int[] values, int length, int[][] dp) {
        if (length == 0 || requiredWeight == 0) {
            return 0;
        }

        if(dp[length][requiredWeight] != -1) {
            return dp[length][requiredWeight];
        }

        if (weights[length - 1] <= requiredWeight) {
            dp[length][requiredWeight] = Math.max(
                    values[length - 1] + knapSackDPTD(requiredWeight - weights[length - 1], weights, values, length - 1, dp),
                    knapSackRec(requiredWeight, weights, values, length - 1));
        } else {
            dp[length][requiredWeight] =  knapSackDPTD(requiredWeight, weights, values, length - 1, dp);
        }
        return dp[length][requiredWeight];
    }

	// Dynamic programming Bottom-Up solution with TC O(requiredWeight * length)
	// Returns the maximum value that can be put in a knapsack of capacity
	// requiredWeight
	private static int knapSackDPBU(int requiredWeight, int[] weights, int[] values, int length) {
		int i, j;
		int[][] dp = new int[length + 1][requiredWeight + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= length; i++) {
			for (j = 0; j <= requiredWeight; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (weights[i - 1] <= j)
					dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		/*
		 * for (i = 0; i < length; i++) {
		 * System.out.println(Arrays.toString(dp[i])); }
		 */
		return dp[length][requiredWeight];
	}

}
