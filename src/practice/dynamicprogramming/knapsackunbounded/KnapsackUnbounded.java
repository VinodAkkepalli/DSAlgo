package practice.dynamicprogramming.knapsackunbounded;

import java.util.Arrays;

/**
 * <b>Description</b> : Unbounded knapsack problem
 *  https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
 *  https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13
 *  Solution to this problem can be understood best when compared against 0-1 knapsack problem
 *  Key differences with 0-1 knapsack:
 *      -We need only an array to store results as against 2-d array we needed in 0-1 knapsack problem
 *      -We can simply maintain the length of the array when we make recursive calls, to ensure unbounded property
 *
 * @author Vinod Akkepalli
 */
public class KnapsackUnbounded {
    public static void main(String[] args) {

        int[] values = new int[]{10, 40, 50, 70};
        int[] weights = new int[]{1, 3, 4, 5};
        int requiredWeight = 8;
        int valuesLength = values.length;
        System.out.println("Highest value is: " + knapSackUnboundedRec(requiredWeight, weights, values, valuesLength));

        int[] dp = new int[requiredWeight+1];
        Arrays.fill(dp, -1);
        knapSackUnboudedDPTD(requiredWeight, weights, values, valuesLength, dp);
        System.out.println("Highest value is: " + dp[requiredWeight]);

        System.out.println("Highest value is: " + knapSackUnboundedDPBU(requiredWeight, weights, values, valuesLength));
    }

    private static int knapSackUnboundedRec(int requiredWeight, int[] weights, int[] values, int length) {

        if (length == 0 || requiredWeight == 0) {
            return 0;
        }

        if (weights[length - 1] <= requiredWeight) {
            return Math.max(
                    values[length - 1] + knapSackUnboundedRec(requiredWeight - weights[length - 1], weights, values, length),
                    knapSackUnboundedRec(requiredWeight, weights, values, length - 1));
        } else {
            return knapSackUnboundedRec(requiredWeight, weights, values, length - 1);
        }
    }

    // Dynamic programming Top-Down solution with TC O(requiredWeight * length)
    // Returns the maximum value that can be put in a knapsack of capacity requiredWeight
    private static int knapSackUnboudedDPTD(int requiredWeight, int[] weights, int[] values, int length, int[] dp) {
        if (length == 0 || requiredWeight == 0) {
            return 0;
        }

        if(dp[requiredWeight] != -1) {
            return dp[requiredWeight];
        }

        if (weights[length - 1] <= requiredWeight) {
            dp[requiredWeight] = Math.max(
                    values[length - 1] + knapSackUnboudedDPTD(requiredWeight - weights[length - 1], weights, values, length, dp),
                    knapSackUnboundedRec(requiredWeight, weights, values, length - 1));
        } else {
            dp[requiredWeight] =  knapSackUnboudedDPTD(requiredWeight, weights, values, length - 1, dp);
        }
        return dp[requiredWeight];
    }


    private static int knapSackUnboundedDPBU(int requiredWeight, int[] weights, int[] values, int length) {
        int i, j;
        int[] dp = new int[requiredWeight + 1];

        // Build table K[] in bottom up manner
        for (i = 0; i <= length; i++) {
            for (j = 0; j <= requiredWeight; j++) {
                if (i == 0 || j == 0)
                    dp[j] = 0;
                else if (weights[i - 1] <= j)
                    dp[j] = Math.max(values[i - 1] + dp[j - weights[i - 1]], dp[j]);
                else
                    dp[j] = dp[j];
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[requiredWeight];
    }
}
