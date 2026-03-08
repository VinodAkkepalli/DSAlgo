package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Description</b> : Given a word and a text, return the count of the
 * occurrences of anagrams of the word in the text
 * https://www.geeksforgeeks.org/count-occurrences-of-anagrams/
 * https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5
 *
 * @author Vinod Akkepalli
 */
public class CountOccurrencesOfAnagram {

    static void main() {
//        String str = "forxxorfxdofr";
//        String word = "for";
        String str = "aabaabaa";
        String word = "aaba";
        System.out.println(countAnagrams(str, word));
        System.out.println(countAnagrams2(str, word));
    }

    //Video explained approach with O(str.length()+word.length)
    private static int countAnagrams2(String str, String word) {
        // 1. Handle edge cases: Null inputs or a target word longer than the search string.
        if (str == null || word == null || str.length() < word.length()) {
            return 0;
        }

        // 2. Build the frequency map for the target word.
        // This map tracks how many of each character we still need to find.
        int result = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for(Character c : word.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }

        // 'count' tracks the number of DISTINCT characters we still need to match.
        // When count reaches 0, we've found a valid anagram.
        int count = hm.size();

        // Sliding window pointers
        int leftIndex = 0;
        int rightIndex = 0;

        // 3. Start sliding the window across the main string
        while (rightIndex < str.length()) {

            // --- EXPANDING THE WINDOW ---
            char rightChar = str.charAt(rightIndex);

            // Fetch the current requirement for the character entering our window.
            Integer rightVal = hm.get(rightChar);

            if (rightVal != null) {

                // We found a character we care about. Decrease its required frequency.
                hm.put(rightChar, rightVal-1);

                // If the requirement drops exactly to 0 (from 1), we've fully satisfied
                // the requirement for this specific distinct character.
                if(rightVal == 1) {
                    count--;
                }
            }

            // --- CHECKING AND SLIDING THE WINDOW ---
            // If our window size exactly matches the target word length, we evaluate and slide
            if(rightIndex-leftIndex+1 == word.length()) {

                // If count is 0, ALL distinct characters are fully matched. It's an anagram!
                if(count == 0) {
                    result++;
                }

                // Now we must slide the window forward by moving the 'left' pointer.
                // This means the character at the 'left' index is leaving the window.
                char leftChar = str.charAt(leftIndex);

                Integer leftVal = hm.get(leftChar);
                if (leftVal != null) {
                    // If the character leaving the window was one we needed, and its
                    // current mapped value is exactly 0, it means our window is about
                    // to lose a required character. We are no longer fully matched for it.
                    if(leftVal == 0) {
                        count++;
                    }

                    // Add the character back to our "required" frequency map
                    hm.put(leftChar, leftVal+1);
                }

                // Shrink the window from the left
                leftIndex++;
            }

            // Expand the window to the right for the next iteration
            rightIndex++;
        }

        return result;
    }


    // Two strings are anagram if the count
    // of characters of each string cancel
    // each other out.
    static boolean isAnagram(int[] cnt) {
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }

    static int countAnagrams(String text, String pattern) {

        // If length of pattern is greater than
        // text, then anagram is not possible.
        if (pattern.length() > text.length()) return 0;

        // Store the count of each char
        // of pattern in an array.
        int[] cnt = new int[26];
        for (int i=0; i<pattern.length(); i++) {
            char ch = pattern.charAt(i);
            cnt[ch - 'a']++;
        }

        for (int i = 0; i < pattern.length() - 1; i++) {
            char ch = text.charAt(i);
            cnt[ch - 'a']--;
        }

        int ans = 0;

        // Sliding window of size pattern.length
        for (int i = pattern.length() - 1; i < text.length(); i++) {

            // Add the character in array
            char ch = text.charAt(i);
            cnt[ch - 'a']--;

            // If anagram exists
            if (isAnagram(cnt)) ans++;

            // Remove the first character of the
            // window.
            char toDel = text.charAt(i - pattern.length() + 1);
            cnt[toDel - 'a']++;
        }

        return ans;
    }
}
