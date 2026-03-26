package string;


import java.util.Stack;

/**
 *
 * Reverse the string present into parentheses
 * (abc) => cba
 * ((abc)) => abc
 * (ab(cd)ef) => fecdba
 * (skeeg(for)skeeg) => geeksforgeeks
 * ((ng)ipm(ca)) => camping
 *
 * https://www.geeksforgeeks.org/dsa/reverse-substrings-between-each-pair-of-parenthesis/ *
 */


public class ReverseStringBetweenParentheses {

    static void main() {
        String input = "(ab(cd)ef)";

        System.out.println(ReverseParentheses(input));
    }

    static String ReverseSubstring(String str, int start, int end)
    {
        StringBuilder reversed = new StringBuilder();
        for (int i = end; i >= start; i--) {
            reversed.append(str.charAt(i));
        }
        return str.substring(0, start) + reversed + str.substring(end + 1);
    }

    static String ReverseParentheses(String str)
    {
        int start;
        int end;

        while (true) {

            // find the first closing bracket
            end = str.indexOf(')');
            if (end == -1) {
                break; // no more closing brackets, we're done
            }

            // find the corresponding opening bracket
            start = str.lastIndexOf('(', end);

            // reverse the substring between the opening and closing brackets
            str = ReverseSubstring(str, start + 1, end - 1);

            // remove the opening and closing brackets
            str = str.substring(0, start)
                    + str.substring(start + 1, end)
                    + str.substring(end + 1);
        }
        return str;
    }
}
