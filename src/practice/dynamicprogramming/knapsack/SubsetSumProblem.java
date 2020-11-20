package practice.dynamicprogramming.knapsack;

import java.util.Arrays;

/**
 * <b>Description</b> :
 * Problem description: Given a set of non-negative integers, and a value sum, determine
 * if there is a subset of the given set with sum equal to given sum.
 *
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7
 *
 * @author Vinod Akkepalli
 */
public class SubsetSumProblem {
    public static void main(String[] args) {

        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
//        int[] arr = {3, 4, 5, 2};
//        int sum = 8;

        boolean result = subsetSumRec(arr, sum, arr.length-1);
        System.out.println("Subset sum exists : " + result);
        System.out.println("Subset sum exists DP solution : " + subsetSumDPBU(arr, sum));
    }

    private static boolean subsetSumRec(int[] arr, int sum, int rightIndex) {
        if(sum == 0)
            return true;
        if(rightIndex < 0)
            return false;

        if(arr[rightIndex] <= sum) {
            return subsetSumRec(arr, sum-arr[rightIndex], rightIndex-1)
                    || subsetSumRec(arr, sum, rightIndex-1);
        } else {
            return subsetSumRec(arr, sum, rightIndex-1);
        }
    }

    private static boolean subsetSumDPBU(int[] arr, int sum) {

        int len = arr.length;
        boolean[][] dp = new boolean[len+1][sum+1];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= sum; j++) {
                if(j==0) {
                    dp[i][j] = true;
                } else if(i==0){
                    dp[i][j] =  false;
                } else if(arr[i-1] <= j) {
                    dp[i][j] =  dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        Arrays.stream(dp).forEach(i -> System.out.println(Arrays.toString(i)));
        return dp[len][sum];
    }
}
