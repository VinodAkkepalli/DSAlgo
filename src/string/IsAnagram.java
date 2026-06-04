package string;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 * LeetCode#242
 */
public class IsAnagram {

    static void main() {
        String first = "anagram";
        String second = "nagaram";

        System.out.println(isAnagram_UsingStreams(first, second));
        System.out.println(isAnagram(first, second));
    }

    public static boolean isAnagram_UsingStreams(String s, String t) {

        Map<Character, Long> frequency = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        for (char c : t.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0L) - 1);
        }

        Optional<Long> any = frequency.values().stream().filter(i -> i != 0).findAny();

        return any.isEmpty();

    }


    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
