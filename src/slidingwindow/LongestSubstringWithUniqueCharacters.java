package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * <b>Description</b> :
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 * Example:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring
 *
 * https://www.youtube.com/watch?v=L6cffskouPQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=11
 * @author Vinod Akkepalli
 */
public class LongestSubstringWithUniqueCharacters {
    public static void main(String[] args) {
        String str = "qwerpwskewl"; // ans = 6
        System.out.println("Longest substring with unique characters is: " + longestSubstringWithUniqueChars(str));
    }

    private static int longestSubstringWithUniqueChars(String str) {
        int res = 0;
        int strLen = str.length();
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();

        while(j < strLen) {
            char c = str.charAt(j);
            if(!set.contains(c)) {
                set.add(c);
                res  = Math.max(res, set.size());
            } else if(set.contains(c)) {
                while(set.contains(c)) {
                    set.remove(str.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return res;
    }
}
