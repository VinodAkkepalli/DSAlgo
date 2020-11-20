package practice.dynamicprogramming.matrixchainmultiplication;

import java.util.Arrays;

/**
 * <b>Description</b> : https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of
 * the partition is a palindrome.
 * Determine the fewest cuts needed for a palindrome partitioning of a given string.
 *
 * If a string is a palindrome, then minimum 0 cuts are needed.
 * If a string of length n containing all different characters, then minimum n-1 cuts are needed
 *
 * https://www.youtube.com/watch?v=szKVpQtBHh8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=36
 *
 * @author Vinod Akkepalli
 */
public class PalindromePartition {

    public static void main(String[] args) {
        String inputStr = "ababbbabbababa"; //Expected output 3
//        String inputStr = "geek";   //Ouput 2
//        String inputStr = "aaaa";   //Ouput 0
//        String inputStr = "abcde";   //Ouput 4
//        String inputStr = "abbac";   //Ouput 1

        System.out.println("Minimum partitions needed: "
                + minimumPartitionsRec(inputStr, 0, inputStr.length()-1));

        int n = inputStr.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Minimum partitions needed(TopDown): "
            + minimumPartitionsDPTD(inputStr, 0, inputStr.length()-1, dp));

    }

    private static int minimumPartitionsRec(String str, int i, int j) {

        if(i == j || isPalindrome(str, i, j)) {
            return 0;
        }

        int temp;
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            temp = minimumPartitionsRec(str, i, k) + minimumPartitionsRec(str, k+1, j) + 1;

            if(min > temp) {
                min = temp;
            }
        }
        return min;
    }

    private static int minimumPartitionsDPTD(String str, int i, int j, int[][] dp) {

        if(i == j) {
            dp[i][j] = 0;
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(isPalindrome(str, i, j)) {
            dp[i][j] = 0;
            return 0;
        }

        int temp;
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {

            if(dp[i][k] == -1)
                dp[i][k] = minimumPartitionsDPTD(str, i, k, dp);
            if(dp[k+1][j] == -1)
                dp[k+1][j] = minimumPartitionsDPTD(str, k+1, j, dp);

            temp = dp[i][k] + dp[k+1][j] + 1;

            if(min > temp) {
                min = temp;
            }
        }
        return dp[i][j] = min;
    }


    private static boolean isPalindrome(String str, int i, int j) {
        while(i <= j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
