package practice.dynamicprogramming.matrixchainmultiplication;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Description</b> :
 *  https://www.geeksforgeeks.org/check-if-a-string-is-a-scrambled-form-of-another-string/
 *  Given two strings A and B of the same length, determine if B is a scrambled string of A.
 *  https://www.youtube.com/watch?v=SqA0o-DGmEw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=41
 * @author Vinod Akkepalli
 */
public class ScrambledString {

    public static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "caebd";

        System.out.println(isScrambledRec(s1, s2));
        System.out.println(isScrambledTD(s1, s2));
    }

    private static boolean isScrambledRec(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }

        if(s1.length() <=1) {
            return false;
        }

        int l = s1.length();

        for (int i = 1; i < l; i++) {

            // If S2[0...i] is a scrambled string of S1[n-i...n] and
            // if S2[i+1...n] is a scramble string of S1[0...n-i-1]
            boolean cond1 = isScrambledRec(s1.substring(0,i), s2.substring(l-i, l))
                    && isScrambledRec(s1.substring(i, l), s2.substring(0, l-i));

            // If S2[0...i] is a scrambled string of S1[0...i] and
            // if S2[i+1...n] is a scrambled string of S1[i+1...n]
            boolean cond2 = isScrambledRec(s1.substring(0,i), s2.substring(0,i))
                    && isScrambledRec(s1.substring(i, l), s2.substring(i,l));

            if(cond1 || cond2) {
                return true;
            }
        }
        return false;
    }

    private static boolean isScrambledTD(String s1, String s2) {
        String mapKey = s1 + "_" + s2;
        if(s1.equals(s2)) {
            map.put(mapKey, true);
            return true;
        }

        if(s1.length() <=1) {
            map.put(mapKey, false);
            return false;
        }

        int l = s1.length();

        if(map.containsKey(mapKey)) {
            return map.get(mapKey);
        }

        for (int i = 1; i < l; i++) {

            // If S2[0...i] is a scrambled string of S1[n-i...n] and
            // if S2[i+1...n] is a scramble string of S1[0...n-i-1]
            boolean cond1 = isScrambledTD(s1.substring(0,i), s2.substring(l-i, l))
                    && isScrambledTD(s1.substring(i, l), s2.substring(0, l-i));

            // If S2[0...i] is a scrambled string of S1[0...i] and
            // if S2[i+1...n] is a scrambled string of S1[i+1...n]
            boolean cond2 = isScrambledTD(s1.substring(0,i), s2.substring(0,i))
                    && isScrambledTD(s1.substring(i, l), s2.substring(i,l));

            if(cond1 || cond2) {
                map.put(mapKey, true);
                return true;
            }
        }
        map.put(mapKey, false);
        return false;
    }

}
