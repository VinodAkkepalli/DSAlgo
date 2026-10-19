package dynamicprogramming.lcs;

import java.util.Arrays;

/**
 * <b>Description</b> : Given a string, print the longest repeating subsequence
 * such that the two subsequence don’t have same string character at same position,
 * i.e., any i’th character in the two subsequences should not have the
 * same index in the original string.
 * https://www.geeksforgeeks.org/longest-repeated-subsequence/
 * https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30
 *
 * @author Vinod Akkepalli
 */
public class LongestRepeatingSubsequence {

    static int[][] dp;

    public static void main(String[] args) {
        String str;
        str = "aabb";  //ans = 2
        str = "axxxy";   //ans = 2
        str = "axxzxy";    //ans = 2
        str = "aab"; //ans = 1;
        str = "aabebcdd"; // ans=3

        int len = str.length();

        System.out.println(longestRepeatingSubsequenceRec(str, len-1, len-1));


        dp = new int[len+1][len+1];

        Arrays.stream(dp).forEach(arr1d -> Arrays.fill(arr1d, -1));
        System.out.println(longestRepeatingSubsequenceTD(str, len, len));

        System.out.println(longestRepeatingSubsequenceBU(str));

        System.out.println(longestRepeatingSubsequenceBUString(str));
    }

    //Recursive solution
    static int longestRepeatingSubsequenceRec(String str, int i, int j) {
        //base case: index < 0 => empty string
        if(i < 0 || j < 0) {
            return 0;
        }

        //Different index && same character
        if(i != j && str.charAt(i) == str.charAt(j)) {
            return 1 + longestRepeatingSubsequenceRec(str, i - 1, j - 1);
        }

        return Math.max(longestRepeatingSubsequenceRec(str, i-1, j), longestRepeatingSubsequenceRec(str, i, j-1));
    }

    //Top-Down Memoization solution
    static int longestRepeatingSubsequenceTD(String str, int i, int j) {
        //base case: index < 0 => empty string
        if(i == 0 || j == 0) {
            return dp[i][j] = 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        //Different index && same character
        if(i != j && str.charAt(i-1) == str.charAt(j-1)) {
            return dp[i][j] = 1 + longestRepeatingSubsequenceTD(str, i - 1, j - 1);
        }

        return dp[i][j] = Math.max(longestRepeatingSubsequenceTD(str, i-1, j), longestRepeatingSubsequenceTD(str, i, j-1));
    }

    //Bottom-Up Tabulation solution
    static int longestRepeatingSubsequenceBU(String str) {

        int len = str.length();
        int[][] dp = new int[len+1][len+1];

        for(int i=0; i<=len; i++){
            for(int j=0; j<=len; j++) {
                if(i == 0 || j == 0) {
                    //base case: index == 0 => empty string
                    dp[i][j] = 0;
                } else if (i != j && str.charAt(i-1) == str.charAt(j-1)) {
                    //Different index && same character
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[len][len];
    }


    //Bottom-Up Tabulation solution
    static String longestRepeatingSubsequenceBUString(String str) {

        int len = str.length();
        int[][] dp = new int[len+1][len+1];

        for(int i=0; i<=len; i++){
            for(int j=0; j<=len; j++) {
                if(i == 0 || j == 0) {
                    //base case: index == 0 => empty string
                    dp[i][j] = 0;
                } else if (i != j && str.charAt(i-1) == str.charAt(j-1)) {
                    //Different index && same character
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println( dp[len][len]);

        int i = len;
        int j = len;
        StringBuilder result = new StringBuilder();

        while(i > 0 && j > 0) {
            if(dp[i][j] == dp[i-1][j-1]+1) {
                result.append(str.charAt(i - 1));
                i--;
                j--;
            } else if(dp[i][j] == dp[i-1][j]) {
                i--;
            } else {
                j--;
            }
        }

        return new StringBuilder(result.toString()).reverse().toString();
    }
}
