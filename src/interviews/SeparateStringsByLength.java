package interviews;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Input: List of String
 * Output: strings separated out based on length and printed as below
 * Output: Map {
 * 1 -> a, b
 * 2 -> ab
 * 3-> abc, xyz
 * }
 *
 */

public class SeparateStringsByLength {
    static void main() {
        List<String> strList = List.of("a", "b", "ab", "xyz", "abc");

        HashMap<Integer, List<String>> hm = new HashMap<>();

        for(String str: strList) {
            if(hm.get(str.length()) == null) {
                List<String> tempStrList = new LinkedList<>();
                tempStrList.add(str);
                hm.put(str.length(), tempStrList);
            } else  {
                List<String> tempStrList = hm.get(str.length());
                tempStrList.add(str);
                hm.put(str.length(), tempStrList);
            }

        }

        System.out.println(hm);

        for (Map.Entry<Integer, List<String>> map : hm.entrySet()) {
            System.out.println(map);
        }
    }

}
