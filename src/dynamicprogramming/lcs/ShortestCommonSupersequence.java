package dynamicprogramming.lcs;


public class ShortestCommonSupersequence {

    public static void main() {

        String s1 = "manraayuy";
        String s2 = "dnarmuy";

        int lcs = longestCommonSubsequenceDPBU(s1, s2);

        System.out.println("Length of longest Common Subsequence is:" + lcs);

        // Detailed solution available below
        // System.out.println(LongestCommonSubsequence.longestCommonSubsequenceDPBU(s1.toCharArray(), s2.toCharArray()));

        System.out.println("Length of shortest common super-sequence is: " + (s1.length() + s2.length() - lcs));

    }


    public static int longestCommonSubsequenceDPBU(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] lcs = new int[m+1][n+1];

        for(int i = 0; i <= m ; i++) {
            for (int j = 0; j <= n ; j++) {
                if(i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        
        return lcs[m][n];
    }
}