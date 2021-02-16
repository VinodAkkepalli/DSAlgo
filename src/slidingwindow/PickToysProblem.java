package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Description</b> :
 * John is at a toy store help him pick maximum number of toys.
 * He can only select in a continuous manner and he can select only two types of toys.
 *
 * Example:
 * Input:
 * abaccab
 * Output: 4
 * Reason: "acca" is the longest
 *
 *
 * https://www.youtube.com/watch?v=seOKHXB_w74&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12
 * @author Vinod Akkepalli
 */
public class PickToysProblem {
    public static void main(String[] args) {
//        String str = "abaccab"; //ans = 4
//        String str = ""; //ans = 0
//        String str = "aaaaa";   //ans = 5
//        String str = "aaaaabbbbb";   //ans = 10
//        String str = "ababababababab";   //ans = 14
//        String str = "abbac";   //ans = 4
        String str = "abacacc";   //ans = 5

        System.out.println("Maximum length is: " + maxLengthToPickToys(str));
    }

    private static int maxLengthToPickToys(String str) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> hm = new HashMap<>();
        int len = str.length();
        int count = 0;
        int tCount;

        while(right < len) {
            char c = str.charAt(right);
            if(hm.containsKey(c))
                hm.put(c, hm.get(c)+1);
            else
                hm.put(c, 1);

            if (hm.size() > 2) {

                while(hm.size() > 2) {
                    c = str.charAt(left);
                    if(hm.get(c) > 1) {
                        hm.put(c, hm.get(c)-1);
                    } else {
                        hm.remove(c);
                    }
                    left++;
                }
            }
            tCount = right - left + 1;
            count = Math.max(count, tCount);
            right++;
        }

        return count;
    }
}
