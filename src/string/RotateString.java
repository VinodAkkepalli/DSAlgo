package string;

/**
 * Given two strings s and goal, return true if and only if s can become goal
 * after some number of shifts on s.
 * 
 * A shift on s consists of moving the leftmost character of s to the rightmost
 * position.
 * 
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 * 
 * Example 1:
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 * 
 * Example 2:
 * Input: s = "abcde", goal = "abced"
 * Output: false
 * 
 */

public class RotateString {

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";

        System.out.println(isRotatedString1(s, goal));
        System.out.println(isRotatedString2(s, goal));
    }
    
    //Time Complexity O(n^2)
    public static boolean isRotatedString1(String s, String goal) {

        if(s.length() != goal.length()) return false;
        if(s.equals(goal)) return true;

        for(int i = s.length()-1; i > 0; i--) {
            if(s.contains(goal.substring(0, i)) && s.indexOf(goal.substring(i)) == 0) return true;
        }

        return false;        
    }

    //Time complexity O(n)
    public static boolean isRotatedString2(String s, String goal) {

        String ss = s + s;
        
        return ss.contains(goal);        
    }
}
