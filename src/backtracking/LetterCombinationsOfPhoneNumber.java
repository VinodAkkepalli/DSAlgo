package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * LeetCode#17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * 
 */

public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
    
        String digits = "234";

        List<String> ans = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return;
        }
        
        // Map each digit to its corresponding letters on a phone keypad.
        // This lookup Array allows quick conversion of each digit to its letter options.
        String[] lettersArr = new String[] {"", "","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
 
        // Start backtracking from index 0 with an empty current combination.
        backtrack(digits, 0, new StringBuilder(), lettersArr, ans);
        System.out.println(ans);
    }

    public static void backtrack(String digits, int index, StringBuilder cStr, String[] lettersArr, List<String> ans) {
        // Base case: we've processed all digits, so add the complete combination to results.
        if(index == digits.length()) {
            ans.add(cStr.toString());
            return;
        }

        // Get all possible letters for the current digit.
        String lChars = lettersArr[digits.charAt(index)-'0'];

        // Try each letter: append it, recurse to the next digit, then backtrack (remove it).
        // This explores all possible combinations systematically.
        for (char ch : lChars.toCharArray()) {
            cStr.append(ch);  // Choose
            backtrack(digits, index+1, cStr, lettersArr, ans);  // Explore
            cStr.deleteCharAt(cStr.length()-1);  // Unchoose (backtrack)
        }
    }
}
