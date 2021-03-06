package dynamicprogramming.knapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <b>Description</b> :
 * Given an array arr[] of length N and an integer X, the task is to find the number
 * of subsets with sum equal to X.
 *
 * https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
 * https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
 * @author Vinod Akkepalli
 */
public class CountOfSubsetsOfGivenSum {
    static int[][] dptd;

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 3}; // ans = 3
//        int sum = 6;

//        int[] arr = {1, 1, 1, 1};   // ans = 4
//        int sum = 3;

        int[] arr = {3, 3, 3, 3};   // ans = 6
        int sum = 6;

        System.out.println(countSubsetsOfGivenSumRec(arr, sum, arr.length-1));

        dptd = new int[arr.length+1][sum+1];
        IntStream.range(0,arr.length+1).forEach(i -> Arrays.fill(dptd[i], -1));
        System.out.println(countSubsetsOfGivenSumDPTD(arr, sum, arr.length-1));
//        Arrays.stream(dptd).forEach(i -> System.out.println(Arrays.toString(i)));

        System.out.println(countSubsetsOfGivenSumDPBU(arr, sum));
    }

    protected static int countSubsetsOfGivenSumRec(int[] arr, int sum, int ri) {
        if(sum == 0) {
            return 1;
        }
        if(ri < 0) {
            return 0;
        }

        if(arr[ri] <= sum) {
            return countSubsetsOfGivenSumRec(arr, sum-arr[ri], ri-1)
                    + countSubsetsOfGivenSumRec(arr, sum, ri-1);
        } else {
            return countSubsetsOfGivenSumRec(arr, sum, ri-1);
        }

    }

    protected static int countSubsetsOfGivenSumDPTD(int[] arr, int sum, int ri) {
        if(sum == 0) {
            if (ri >= 0) dptd[ri][sum] = 1;
            return 1;
        }
        if(ri < 0) {
            return 0;
        }

        if(dptd[ri][sum] != -1) {
            return dptd[ri][sum];
        }

        if(arr[ri] <= sum) {
            dptd[ri][sum] = countSubsetsOfGivenSumDPTD(arr, sum-arr[ri], ri-1)
                    + countSubsetsOfGivenSumDPTD(arr, sum, ri-1);
        } else {
            dptd[ri][sum] = countSubsetsOfGivenSumDPTD(arr, sum, ri-1);
        }

        return dptd[ri][sum];
    }

    protected static int countSubsetsOfGivenSumDPBU(int[] arr, int sum) {
        int len = arr.length;
        int[][] dp = new int[len + 1][sum + 1];

        IntStream.range(0, sum + 1).forEach(i -> dp[0][i] = 0);
        IntStream.range(0, len + 1).forEach(i -> dp[i][0] = 1);

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

//        Arrays.stream(dp).forEach(i -> System.out.println(Arrays.toString(i)));
        return dp[len][sum];
    }
}
