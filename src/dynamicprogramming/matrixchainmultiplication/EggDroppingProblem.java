package dynamicprogramming.matrixchainmultiplication;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <b>Description</b> :
 * You are given N floor and K eggs. You have to minimize the number of times you have to drop the eggs to find the critical floor where critical floor means the floor beyond which eggs start to break. Assumptions of the problem:
 *
 * If egg breaks at ith floor then it also breaks at all greater floors.
 * If egg does not break at ith floor then it does not break at all lower floors.
 * Unbroken egg can be used again.
 * Note: You have to find minimum trials required to find the critical floor not the critical floor.
 *
 * Example Input:
 *     4
 *     2
 *
 * Output: Number of trials when number of eggs is 2 and number of floors is 4: 3
 *
 * https://www.youtube.com/watch?v=S49zeUjeUL0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=43
 * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 *
 * @author Vinod Akkepalli
 */
public class EggDroppingProblem {
    static int[][] dp;

    public static void main(String[] args) {
        int numFloors = 20;
        int numEggs = 4;

        System.out.println(findMinAttemptsRec(numFloors, numEggs));

        dp = new int[numEggs+1][numFloors+1];
        Arrays.stream(dp).forEach(i -> Arrays.fill(i, -1));
        System.out.println(findMinAttemptsDPTD(numFloors, numEggs));
        System.out.println(findMinAttemptsDPBU(numFloors, numEggs));
    }

    private static int findMinAttemptsRec(int numFloors, int numEggs) {

        //0 trials needed for 0 number of floors
        //1 trial needed for 1 floor
        //we try each floor from lowest floor when only one egg available
        if(numFloors == 0 || numFloors == 1 || numEggs == 1) {
            return numFloors;
        }

        int min = Integer.MAX_VALUE;
        int temp;

        //consider dropping from 1st to kth floors and return the minimum
        for (int i = 1; i <= numFloors; i++) {
            temp = 1 + Math.max(findMinAttemptsRec(i-1, numEggs-1),
                    findMinAttemptsRec(numFloors-i, numEggs));
            min = Math.min(min, temp);
        }

        return min;
    }

    private static int findMinAttemptsDPTD(int numFloors, int numEggs) {
        if(numFloors == 0 || numFloors == 1 || numEggs == 1) {
            return numFloors;
        }

        int min = Integer.MAX_VALUE;
        int temp;

        if(dp[numEggs][numFloors] != -1) {
            return dp[numEggs][numFloors];
        }

        for (int i = 1; i <= numFloors; i++) {
            temp = 1 + Math.max(findMinAttemptsDPTD(i-1, numEggs-1),
                    findMinAttemptsDPTD(numFloors-i, numEggs));
            min = Math.min(min, temp);
        }

        return dp[numEggs][numFloors] = min;
    }

    private static int findMinAttemptsDPBU(int numFloors, int numEggs) {
        int[][] dp = new int[numEggs+1][numFloors+1];
        Arrays.stream(dp).forEach(i->Arrays.fill(i, Integer.MAX_VALUE));

        int temp;
        for (int i = 1; i <= numEggs; i++) {
            for (int j = 0; j <= numFloors; j++) {
                if (j == 0 || j == 1 || i == 1) {
                    dp[i][j] = j;
                } else {
                    for (int k = 1; k <=j ; k++) {
                        temp = 1 + Math.max(dp[i-1][k-1], dp[i][j-k]);
                        dp[i][j] = Math.min(dp[i][j], temp);
                    }
                }
            }
        }
        return dp[numEggs][numFloors];
    }
}
