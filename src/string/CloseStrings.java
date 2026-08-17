package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode#1657. Determine if Two Strings Are Close
 * 
 * Two strings are considered close if you can attain one from the other using the following operations:
 * Operation 1: Swap any two existing characters.
 * 
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 * 
 * 
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 * 
 * Input: word1 = "cabbba", word2 = "abbccc" 
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 *
 */

public class CloseStrings {

    public static void main(String[] args) {

        System.out.println(closeStrings("cabbba", "abbccc"));
        System.out.println(closeStrings("a", "aaa"));
        System.out.println(closeStrings("abc", "bca"));

    }

    public static boolean closeStrings(String word1, String word2) {

        if(word1.length() != word2.length()){
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        
        for(char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }

        
        // 1. Verify they contain the exact same unique characters
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        // 2. Verify they have the exact same frequency distributions
        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());
    
        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }

}
