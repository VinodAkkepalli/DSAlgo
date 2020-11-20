package practice.dynamicprogramming.lcs;

/**
 * <b>Description</b> :
 * Given a string of size ‘n’. The task is to remove or delete minimum
 * number of characters from the string so that the resultant string is palindrome.
 * Note: The order of characters should be maintained.
 *
 * https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
 * https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=28
 *
 *
 * @author Vinod Akkepalli
 */
public class MinDeletionsToConvertStringToPalindrome {

    public static void main(String[] args) {
        String str = "abrakadabra";

//        using Longest Palindromic Subsequence method
        System.out.println(str.length() - LongestPalindromicSubsequence.longestPalindromicSubsequenceDP(str));
        System.out.println(convertToPalindromeRec(str.toCharArray(), 0, str.length()-1));
    }

    private static int convertToPalindromeRec(char[] str, int li, int ri) {
//        when left index and right index has same char
        if(li == ri || (str[li] == str[ri] && (li+1 == ri))) {
            return 0;
        } else if(str[li] == str[ri]){
            return convertToPalindromeRec(str, li+1, ri-1);
        } else {
            return 1 + Math.min(convertToPalindromeRec(str, li+1, ri),
                    convertToPalindromeRec(str, li, ri-1));
        }
    }
}
