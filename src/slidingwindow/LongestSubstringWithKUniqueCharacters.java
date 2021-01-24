package slidingwindow;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <b>Description</b> :
 * Given a string you need to print the size of the longest possible
 * substring that has exactly k unique characters.
 *
 * Example:
 * Input:
 * aabacbebebe
 * 3
 * Output:
 * 7
 *
 * https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
 * https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10
 *
 * @author Vinod Akkepalli
 */
public class LongestSubstringWithKUniqueCharacters {

    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 4;

        int res  = findLongestStringWithKUniqueChars(str, k);
        System.out.println("Longest string is: " + res);
    }

    private static int findLongestStringWithKUniqueChars(String str, int k) {
        int res = 0;
        int strLen = str.length();
        int i =  0;
        int j = 0;
        Map<Character, Integer> charMap = new LinkedHashMap<>();

        while(j < strLen) {
            char c = str.charAt(j);
            charMap.put(c, charMap.containsKey(c) ? charMap.get(c) + 1 : 1);

            if(charMap.size() > k) {
                while(charMap.size() > k) {
                    c = str.charAt(i);
                    if (charMap.get(c) == 1) {
                        charMap.remove(str.charAt(i));
                    } else {
                        charMap.put(c, charMap.get(c) - 1);
                    }
                    i++;
                }
            }
            if(charMap.size() == k) {
                res = Math.max(res, j-i+1);
            }
            j++;
        }
        return res;
    }
}
