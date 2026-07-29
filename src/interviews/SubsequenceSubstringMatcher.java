package interviews;


/**
 *  Determine the maximum length of a subsequence from one string that is also a substring of another string.
 *  A subsequence of a string is created by removing zero or more characters from it, 
 *  while a substring consists of consecutive characters from the string
 * 
 *  String x is a string to find the subsequence of
 *  String y is a string to find the substring of
 *
 * Example: 
 * 
 * x = "abc"
 * y = "aedace"
 * 
 * output: 2 
 * "ac" is subsequnce of x present a substring of y
 */

public class SubsequenceSubstringMatcher {

    /**
     * Finds the maximum length of a sequence of characters that is a 
     * subsequence of string x and a substring of string y.
     *
     * @param x The string to extract the subsequence from.
     * @param y The string to extract the substring from.
     * @return The maximum length of the matching characters.
     */
    public static int maxSubsequenceSubstringLength(String x, String y) {
        if (x == null || y == null || x.isEmpty() || y.isEmpty()) {
            return 0;
        }

        int n = x.length();
        int m = y.length();

        // dp[j] stores the max length of a valid match ending exactly at y.charAt(j-1)
        int[] dp = new int[m + 1];
        int maxLength = 0;

        // Iterate through characters of the subsequence string (x)
        for (int i = 1; i <= n; i++) {
            // Iterate backwards through the substring string (y) to optimize space.
            // Going backwards prevents us from reading updated values from the 
            // current row (i) before we are done calculating them.
            for (int j = m; j > 0; j--) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[j] = Math.max(dp[j], dp[j - 1] + 1);
                    maxLength = Math.max(maxLength, dp[j]);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String x = "abc"; // We can skip characters in this string (subsequence)
        String y = "aedace";   // Characters must be contiguous in this string (substring)
        
        int result = maxSubsequenceSubstringLength(x, y);
        System.out.println("Maximum length: " + result); 
    }
}