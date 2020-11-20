package practice.dynamicprogramming.lcs;

/**
 * 
 * @author Vinod Akkepalli
 *
 *	problem statement: Given a sequence, find the length of the longest palindromic subsequence in it
 *	https://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 *	https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26
 */
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";

		//Using Longest Common Subsequence algorithm
		System.out.println(LongestCommonSubsequence.longestCommonSubsequenceRec(str.toCharArray(),
				new StringBuilder(str).reverse().toString().toCharArray(),
				str.length(), str.length()));
		System.out.println(LongestCommonSubsequence.longestCommonSubsequenceDPBU(str.toCharArray(),
				new StringBuilder(str).reverse().toString().toCharArray()));

		System.out.println(longestPalindromicSubsequenceRec(str, 0, str.length()-1));
		System.out.println(longestPalindromicSubsequenceDP(str));
	}

	private static int longestPalindromicSubsequenceRec(String inStr, int i, int j) {

		if(i == j) {
			return 1;
		} else if (inStr.charAt(i) == inStr.charAt(j) && (i+1 == j)) {
			return 2;
		} else if(inStr.charAt(i) == inStr.charAt(j)){
			return longestPalindromicSubsequenceRec(inStr, i+1, j-1) + 2;
		} else {
			return Math.max(longestPalindromicSubsequenceRec(inStr, i+1, j),
					longestPalindromicSubsequenceRec(inStr, i, j-1));
		}
	}

	// Time complexity of this Dynamic Programming approach is O(n^2)
	static int longestPalindromicSubsequenceDP(String inStr) {
		char[] cStr = inStr.toCharArray();
		int sLength = cStr.length;
		int[][] lps = new int[sLength][sLength];

		// Strings of length 1 are palindromes of length 1
		for (int i = 0; i < sLength; i++) {
			lps[i][i] = 1;
		}
		int j;

		// lss is length of substring
		for (int lss = 2; lss <= sLength; lss++) {

			for (int i = 0; i < sLength - lss + 1; i++) {
				j = i + lss - 1;
				if (cStr[i] == cStr[j] && lss == 2) {
					lps[i][j] = 2;
				} else if (cStr[i] == cStr[j]) {
					lps[i][j] = lps[i + 1][j - 1] + 2;
				} else {
					lps[i][j] = Math.max(lps[i][j - 1], lps[i + 1][j]);
				}
			}
		}

		/*
		 * for (int i = 0; i < sLength; i++) {
		 * System.out.println(Arrays.toString(lps[i])); }
		 */
		return lps[0][sLength - 1];
	}

	

}
