package dynamicprogramming.knapsack;

import java.util.Arrays;

/**
 * <b>Description</b> :
 *  Count the number of subsets with a given difference
 *
 *  Approach is to find subset with required sum where requiredSum = (sum + requiredDiff) / 2
 *
 * https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
 *
 * @author Vinod Akkepalli
 */
public class CountSubsetsWithGivenDifference {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3}; // ans 3
        int requiredDiff = 1;

        int sum = Arrays.stream(arr).sum();
        int requiredSum = (sum + requiredDiff) / 2;

        System.out.println(CountOfSubsetsOfGivenSum.countSubsetsOfGivenSumRec(arr, requiredSum, arr.length-1));
        System.out.println(CountOfSubsetsOfGivenSum.countSubsetsOfGivenSumDPBU(arr, requiredSum));
    }
}
