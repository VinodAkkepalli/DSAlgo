package dynamicprogramming.lcs;

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

    public static void main(String[] args) {
        String str = "aabb";

        int count = methodRec(str);
    }

    private static int methodRec(String str) {

        return 0;
    }
}
