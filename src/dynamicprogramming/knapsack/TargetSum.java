package dynamicprogramming.knapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <b>Description</b> : Target Sum Problem
 * Given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 *
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 *
 * Approach: is similar to CountSubsetsWithGivenDifference, if we consider numbers with +ve operator
 * as part of one set and numbers with -ve operator as part of second set.
 *
 * https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12
 *
 * @author Vinod Akkepalli
 */
public class TargetSum {
    static int[][] dp = null;

    public static void main(String[] args) {

        int[] arr = {1,1,1,1,1};    // ans 5
        int requiredSum = 3;

//        int[] arr = {1, 1, 2, 3}; // ans 3
//        int requiredSum = 1;

        System.out.println(targetSumCountRec(arr, requiredSum, arr.length - 1, 0));

        int sum = Arrays.stream(arr).sum();
        dp = new int[arr.length+1][sum+1];
        Arrays.stream(dp).forEach(i -> Arrays.fill(i, -1));
        System.out.println(targetSumCountDPTD(arr, requiredSum, arr.length - 1, 0));

        // using CountSubsetsWithGivenDifference approach
        int firstSetSum = (sum + requiredSum)/2;
        System.out.println("CountOfSubsetsOfGivenSum recursive approach: "
                + CountOfSubsetsOfGivenSum.countSubsetsOfGivenSumRec(arr, firstSetSum, arr.length-1));

        System.out.println("CountOfSubsetsOfGivenSum DPBU approach: "
                + CountOfSubsetsOfGivenSum.countSubsetsOfGivenSumDPBU(arr, firstSetSum));
    }

    private static int targetSumCountRec(int[] arr, int requiredSum,
                                         int ri, int currentSum) {
        if(ri < 0)
            return currentSum == requiredSum ? 1 : 0;

        return targetSumCountRec(arr, requiredSum, ri-1, currentSum+arr[ri])
                + targetSumCountRec(arr, requiredSum, ri-1, currentSum-arr[ri]);
    }

    private static int targetSumCountDPTD(int[] arr, int requiredSum, int ri, int currentSum) {
        if(ri < 0) {
            return currentSum == requiredSum ? 1 : 0;
        }

        if(currentSum >= 0 && dp[ri][currentSum] != -1) {
            return dp[ri][currentSum];
        }

        return targetSumCountDPTD(arr, requiredSum, ri-1, currentSum+arr[ri])
                + targetSumCountDPTD(arr, requiredSum, ri-1, currentSum-arr[ri]);
    }

}
