package practice.dynamicprogramming.lcs;

import java.util.Arrays;

/**
 * 
 * @author Vinod Akkepalli 
 * 	Problem Description: Given two sequences, find the length of longest subsequence present
 * 	in both of them. A subsequence is a sequence that appears in the same relative order,
 * 	but not necessarily contiguous.
 *
 *	https://www.geeksforgeeks.org/longest-common-subsequence/
 *  https://www.youtube.com/watch?v=4Urd0a0BNng&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=19
 */

public class LongestCommonSubsequence {

	static int[][] dp;

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] s1Chr = s1.toCharArray();
		char[] s2Chr = s2.toCharArray();

		dp = new int[s1Chr.length+1][s2Chr.length+1];
		Arrays.stream(dp).forEach(i -> Arrays.fill(i, -1));

		System.out.println("Using Recursive approach is: "
				+ longestCommonSubsequenceRec(s1Chr, s2Chr, s1Chr.length, s2Chr.length));

		System.out.println("Using DP Top-down approach is: "
				+ longestCommonSubsequenceDPTD(s1Chr, s2Chr, s1Chr.length, s2Chr.length));

		System.out.println("Using DP Bottom-Up approach is: "
				+ longestCommonSubsequenceDPBU(s1Chr, s2Chr));

	}

	// Recursive approach with TC(2^n)
	static int longestCommonSubsequenceRec(char[] str1, char[] str2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (str1[m - 1] == str2[n - 1]) {
			return 1 + longestCommonSubsequenceRec(str1, str2, m - 1, n - 1);
		} else {
			return Math.max(longestCommonSubsequenceRec(str1, str2, m, n - 1),
					longestCommonSubsequenceRec(str1, str2, m - 1, n));
		}
	}

	// Dynamic Programming Top-down approach with TC O(m*n)
	static int longestCommonSubsequenceDPTD(char[] str1, char[] str2, int m, int n) {
		if (m == 0 || n == 0) {
			dp[m][n] = 0;
			return 0;
		}

		if(dp[m][n] != -1) {
			return dp[m][n];
		}

		if (str1[m - 1] == str2[n - 1]) {
			dp[m][n] = 1 + longestCommonSubsequenceRec(str1, str2, m - 1, n - 1);
		} else {
			dp[m][n] = Math.max(longestCommonSubsequenceRec(str1, str2, m, n - 1),
					longestCommonSubsequenceRec(str1, str2, m - 1, n));
		}
		return dp[m][n];
	}

	// Dynamic Programming Bottom-up approach with TC O(m*n)
	static int longestCommonSubsequenceDPBU(char[] str1, char[] str2) {

		int m = str1.length;
		int n = str2.length;

		// lcs[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		int[][] lcs = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (str1[i - 1] == str2[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

//		Arrays.stream(lcs).forEach(i -> System.out.println(Arrays.toString(i)));

		return lcs[m][n];
	}
}
