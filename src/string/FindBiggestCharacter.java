package string;

/**
 * <b>Description</b> :
 * Given a string of only capital and small letters, find the biggest character lexicographical order
 * which is present both in capital and small letters.
 *
 * @author Vinod Akkepalli
 */
public class FindBiggestCharacter {

    public static void main(String[] args) {
        String str = "WeTestCoders";
        System.out.println(findLBiggestCharacter(str));
    }

    private static String findLBiggestCharacter(String str) {
        int len = str.length();
        String ans = null;

        boolean[] bUpper = new boolean[26];
        boolean[] bLower = new boolean[26];

        for (int i = 0; i < len; i++) {
            final char c = str.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                bUpper[c - 'A'] = true;
            } else if (c >= 'a' && c <= 'z') {
                bLower[c - 'a'] = true;
            }
        }

        int j;
        for (j = 25; j >= 0; j--) {
            if (bUpper[j] && bLower[j]) {
                ans = String.valueOf((char) (j + 65));
                break;
            }
        }
        if (j == -1) {
            return  "NO";
        }
        return ans;
    }
}
