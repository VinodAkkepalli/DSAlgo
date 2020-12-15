package dynamicprogramming;

import java.util.Arrays;

/**
 * <b>Description</b> :
 * You are given an array A of size N. The array contains integers and is of even length.
 * The elements of the array represent N coin of values V1, V2, ....Vn.
 * You play against an opponent in an alternating way.
 * In each turn, a player selects either the first or last coin from the row,
 * removes it from the row permanently, and receives the value of the coin.
 * You need to determine the maximum possible amount of money you can win if you go first.
 *
 * Example 1:
 *
 * Input:
 * N = 4
 * A[] = {5,3,7,10}
 * Output: 15
 * Explanation: The user collects maximum
 * value as 15(10 + 5)
 * Example 2:
 *
 * Input:
 * N = 4
 * A[] = {8,15,3,7}
 * Output: 22
 * Explanation: The user collects maximum
 * value as 22(7 + 15)
 * Your Task:
 * Complete the function maximumAmount() which takes an array arr[] (represent values of N coins) and N as number of coins as a parameter and returns the maximum possible amount of money you can win if you go first.
 *
 * Expected Time Complexity : O(N*N)
 * Expected Auxiliary Space: O(N*N)
 *
 * Constraints:
 * 2 <= N <= 100
 * 1 <= Ai <= 106
 *
 * https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
 *
 * @author Vinod Akkepalli
 */
public class OptimalStrategyForAGame {

    static long[][] dp;

    public static void main(String[] args) {

//        int[] arr = {5, 3, 7, 10}; // output 15
//        int[] arr = {8, 15, 3, 7};  // output 22
        int[] arr = {2, 2, 2, 2};   // output 4
//        int[] arr = {20, 30, 2, 2, 2, 10};  // output 42

        int n = arr.length;
        System.out.println(countMaximumRec(arr, 0, n-1));

        dp = new long[n+1][n+1];
        Arrays.stream(dp).forEach(i -> Arrays.fill(i, -1));
        System.out.println(countMaximumDPTD(arr, 0, n-1));

        System.out.println(countMaximumDPBU(arr));
    }

    static long countMaximumRec(int[] arr, int li, int ri){
        //array has only one element
        if(li == ri) return arr[li];
        //array has only two elements
        if(li+1 == ri) return Math.max(arr[li], arr[ri]);


        return Math.max(
                //user choses left value
                arr[li] + Math.min(countMaximumRec(arr, li+2, ri), countMaximumRec(arr, li+1, ri-1)),
                //user choses right value
                arr[ri] + Math.min(countMaximumRec(arr, li, ri-2), countMaximumRec(arr, li+1, ri-1)));
    }

    static long countMaximumDPTD(int[] arr, int li, int ri){
        //array has only one element
        if(li == ri) return arr[li];
        //array has only two elements
        if(li+1 == ri) return Math.max(arr[li], arr[ri]);

        if(dp[li][ri] != -1) return dp[li][ri];

        // user choses arr[li] opponent choses arr[li+1]
        long leftLeft = 0;
        if(dp[li+2][ri] == -1) {
            leftLeft = countMaximumDPTD(arr, li+2, ri);
        }

        // user choses arr[li] opponent choses arr[ri]
        long leftRight = 0;
        if(dp[li+1][ri-1] == -1) {
            leftRight = countMaximumDPTD(arr, li+1, ri-1);
        }

        // user opponent chose left and right each
        long rightRight = 0;
        if(dp[li][ri-2] == -1) {
            rightRight = countMaximumDPTD(arr, li, ri-2);
        }
        return dp[li][ri] = Math.max(
                arr[li] + Math.min(leftLeft, leftRight),
                arr[ri] + Math.min(rightRight, leftRight));
    }

    //TODO: understand and simplify this; code collected from GFG
    static long countMaximumDPBU(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        int x, y, z;



        int i;
        for (int gap = 0; gap < len; ++gap) {
            i = 0;
            for (int j = gap; j < len; ++j) {

                x = ((i + 2) <= j) ? dp[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? dp[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(
                        arr[i] + Math.min(x, y),
                        arr[j] + Math.min(y, z));
                i++;
            }
        }

        return dp[0][len - 1];
    }
}
