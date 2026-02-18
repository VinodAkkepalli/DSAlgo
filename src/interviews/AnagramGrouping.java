package interviews;

import java.util.*;

/**
 * <b>Description</b> : Given a list of inputs, print out the list of anagrams
 *
 * <b>Naive Solution</b>
 *  1) convert each string to char array and sort char array
 *  2) create a string with sorted char array
 *  3) create HashMap with sorted string as key, and original string as value
 *  4) Print HashMap contents
 *
 *  <b>Better Solution</b>
 *
 *  1) Create a hash map where each key is a 26-length tuple representing character frequencies,
 *      and each value is a list of strings belonging to that anagram group.
 *
 *  2) For each string in the input:
 *      Initialize a count array of size 26 with all zeros.
 *      For each character c in the string, increment the count at the corresponding index.
 *      Convert the count array to a tuple and use it as the key.
 *      Append the string to the list associated with this key.
 *      After processing all strings, return all the lists stored in the hash map.
 *
 * @author Vinod Akkepalli
 */
public class AnagramGrouping {

    public static void main(String[] args) {

//        List<String> strList = new ArrayList<>(Arrays.asList(
//                "cat", "dog", "loop", "act", "pool", "ogd", "city", "god"));
        List<String> strList = List.of("cat", "dog", "loop", "act", "pool", "ogd", "city", "god");
        groupAnagrams(strList);
        groupAnagrams2(strList);
    }



    /** Naive Solution*/
    public static void groupAnagrams(List<String> strList) {
        Map<String, List<String>> hm = new HashMap<>();
        String sortedStr;

        for(String str: strList) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            sortedStr = new String(strArr);

            if(hm.containsKey(sortedStr)) {
                //add to the value which is a list
                hm.get(sortedStr).add(str);
            } else {
                //create a new list and add to map
                List<String> newList = new ArrayList<>();
                newList.add(str);
                hm.put(sortedStr, newList);
            }
        }

        System.out.println("Anagram groups are: ");
        System.out.println(hm.values());
    }

    /**Better Solution*/
    public static void groupAnagrams2(List<String> strList) {

        Map<String, List<String>> res = new HashMap<>();

        for(String s: strList) {
            int[] charCount = new int[26];
            for(char ch : s.toCharArray()) {
                charCount[ch - 'a']++;
            }

            String str = Arrays.toString(charCount);
//            System.out.println(str);
            res.putIfAbsent(str, new ArrayList<>());
            res.get(str).add(s);
        }

        System.out.println("Anagram groups are: ");
        System.out.println(res.values());
    }
}
