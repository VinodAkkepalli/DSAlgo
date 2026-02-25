package string;

/**
 * <b>Problem Statement</b>
 * Given a sentence s, determine whether it is a palindrome sentence or not. A palindrome sentence is a sequence of characters that reads the same forward and backward after:
 *
 * Converting all uppercase letters to lowercase.
 * Removing all non-alphanumeric characters (i.e., ignore spaces, punctuation, and symbols).
 *
 * https://www.geeksforgeeks.org/dsa/sentence-palindrome-palindrome-removing-spaces-dots-etc/
 */

public class PalindromeSentence {
    static void main() {
        String str = "T#oo h$$ot to &&hoot."; //true
//        String str = "Abc 012..##  10cbA"; // true
//        String str = "ABC $. def01ASDF.."; // false
        System.out.println(isPalindromeSentence(str));

    }

    private static boolean isPalindromeSentence(String str) {

        int i = 0;
        int j = str.length()-1;

        while(i <j) {
            while(!Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            }
            while(!Character.isLetterOrDigit(str.charAt(j))) {
                j--;
            }

            if(Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(j))) {
                i++;j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
