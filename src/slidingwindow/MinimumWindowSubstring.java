package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Description</b> :
 * Given two strings s and t, return the minimum window in s which will contain all the
 * characters in t. If there is no such window in s that covers all characters in t,
 * return the empty string "".
 *
 * Note that If there is such a window, it is guaranteed that there will always be
 * only one unique minimum window in s.
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: 4
 *
 * https://www.youtube.com/watch?v=iwv1llyN6mo&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=13
 * https://leetcode.com/problems/minimum-window-substring/
 * @author Vinod Akkepalli
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String str = "TOTMTAPTAT";
        String t = "TTA";   // ans = 3

//        String str = "ADOBECODEBANC";
//        String t = "ABC";   //ans = 4

//        String str = "a";
//        String t = "a"; //  ans = 1

//        String str = "TTTTA";
//        String t = "TA";    //ans = 2

//        String str = "abcdabcddabc";
//        String t = "aba";   //ans = 5
        System.out.println("length of smallest substring is: " + minimumWindowSubstring(str, t));
    }

    private static int minimumWindowSubstring(String str, String t) {
        int ans = Integer.MAX_VALUE;
        char c;
        char[] cStr = str.toCharArray();

        Map<Character, Integer> cMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            if(cMap.containsKey(c)) {
                cMap.put(c, cMap.get(c)+1);
            } else {
                cMap.put(c, 1);
            }
        }

        int count = cMap.size();
        int i = 0;
        int j = 0;
        int sLen = str.length();

        while(j < sLen) {
            c = cStr[j];
            if(cMap.containsKey(c)) {
                cMap.put(c, cMap.get(c)-1);
                if(cMap.get(c) == 0) {
                    count--;
                }
            }

            if(count == 0) {
                while(count == 0) {
                    if(cMap.containsKey(cStr[i])) {
                        cMap.put(cStr[i], cMap.get(cStr[i]) + 1);
                        if (cMap.get(cStr[i]) > 0) {
                            count++;
                        }
                    }
                    i++;
                }
                ans = Math.min(ans, j - i + 2);
            }
            j++;
        }

        return ans;
    }
}
