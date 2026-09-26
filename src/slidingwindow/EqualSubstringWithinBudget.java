package slidingwindow;

/**
 * LeetCode#1208. Get Equal Substrings Within Budget
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
 * 
 */

public class EqualSubstringWithinBudget {

    public static void main(String[] args) {
        
        String s = "abcd";
        String t = "abcd";
        int maxCost = 3;

        System.out.println(equalSubstring(s, t, maxCost));
    }


    public static int equalSubstring(String s, String t, int maxCost) {
        int maxLength = 0;
        int sum = 0;
        int leftIndex = 0;

        for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            sum += Math.abs(s.charAt(rightIndex) - t.charAt(rightIndex));

            while (sum > maxCost && leftIndex <= rightIndex) {
                sum -= Math.abs(s.charAt(leftIndex) - t.charAt(leftIndex));
                leftIndex++;
            }

            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
        }

        return maxLength;
    }

}
