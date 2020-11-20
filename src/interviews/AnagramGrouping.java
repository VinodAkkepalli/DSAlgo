package interviews;

import java.util.*;

/**
 * <b>Description</b> : Given a list of inputs, print out the list of anagrams
 *  1) convert each string to char array and sort char array
 *  2) create a string with sorted char array
 *  3) create HashMap with sorted string as key, and original string as value
 *  4) Print HashMap contents
 *
 * @author Vinod Akkepalli
 */
public class AnagramGrouping {

    public static void main(String[] args) {

//        List<String> strList = new ArrayList<>(Arrays.asList(
//                "cat", "dog", "loop", "act", "pool", "ogd", "city", "god"));
        List<String> strList = List.of("cat", "dog", "loop", "act", "pool", "ogd", "city", "god");
        groupAnagrams(strList);
    }



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
        for(Map.Entry<String, List<String>> entry: hm.entrySet()) {
            System.out.print(entry.getValue());
        }

    }
}
