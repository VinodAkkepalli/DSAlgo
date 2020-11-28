package dynamicprogramming.knapsack;

import java.util.Arrays;

/**
 * <b>Description</b> :
 * Partition a set into two subsets such that the difference of subset sums is minimum
 *
 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 * https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
 * @author Vinod Akkepalli
 */
public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};  // output: 1
//        int[] arr = {3, 1, 4, 2, 2, 1}; // output: 1
//        int[] arr = {1, 2, 7};  // output: 4

        int sum = Arrays.stream(arr).sum();
        System.out.println(minSubsetSumDiffRec(arr, 0, arr.length-1, sum));

        int i = subsetSumDPBU(arr, sum);
        System.out.println(sum - 2 * i);
    }

    private static int minSubsetSumDiffRec(int[] arr, int firstSetSum, int ri, int sum) {
        if (ri < 0) {
            //difference between sums of two subsets
            return Math.abs(sum - 2 * firstSetSum);
        }

        return Math.min(
                //Case where we include arr[ri] as part of first set
                minSubsetSumDiffRec(arr, firstSetSum + arr[ri], ri - 1, sum),
                //Case where we DON'T include arr[ri] as part of first set
                minSubsetSumDiffRec(arr, firstSetSum, ri - 1, sum));
    }

    private static int subsetSumDPBU(int[] arr, int sum) {

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
//        Arrays.stream(dp).forEach(i -> System.out.println(Arrays.toString(i)));

        int ans = 0;
        for (int i = 0; i <= sum/2; i++) {
            if(dp[len][i]) ans = i;
        }
        return ans;
    }
}
