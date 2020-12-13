package dynamicprogramming.matrixchainmultiplication;

import java.util.Arrays;

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
 * @author Vinod Akkepalli
 */
public class EggDroppingProblem {
    static int[][] dp;

    public static void main(String[] args) {
        int numFloors = 35;
        int numEggs = 2;

        System.out.println(findMinAttemptsRec(numFloors, numEggs));

        dp = new int[numEggs+1][numFloors+1];
        Arrays.stream(dp).forEach(i -> Arrays.fill(i, -1));
        System.out.println(findMinAttemptsDPTD(numFloors, numEggs));
    }

    private static int findMinAttemptsRec(int numFloors, int numEggs) {

        if(numFloors == 0 || numFloors == 1) {
            return 1;
        }
        if(numEggs == 1) {
            return numFloors;
        }

        int min = Integer.MAX_VALUE;
        int temp;

        for (int i = 1; i <= numFloors; i++) {
            temp = 1 + Math.max(findMinAttemptsRec(i-1, numEggs-1),
                    findMinAttemptsRec(numFloors-i, numEggs));
            min = Math.min(min, temp);
        }

        return min;
    }

    private static int findMinAttemptsDPTD(int numFloors, int numEggs) {
        if(numFloors == 0 || numFloors == 1) {
            return 1;
        }
        if(numEggs == 1) {
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
}
