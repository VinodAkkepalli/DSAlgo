package arrays.stack;

/**
 * LeetCode#2390. Removing Stars From a String
 * You are given a string s, which contains stars *.
 * In one operation, you can:
 * Choose a star in s. Remove the closest non-star character to its left, as well as remove the star itself.
 * 
 * Return the string after all stars have been removed.
 * 
 */



public class RemoveStarsFromString {

    public static void main(String[] args) {

        String s = "leet**cod*e"; //ans = "lecoe"
        // String s = "erase*****"; //ans = ""

        String ans = removeStars(s);

        System.out.println(ans);
    }

    //solution simulating Stack
    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c == '*') {
                // Remove the closest non-star character to the left
                sb = sb.deleteCharAt(sb.length()-1);
            } else {
                // Add regular characters to our "stack"
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
