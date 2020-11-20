package practice.slidingwindow;

/**
 * <b>Description</b> : Given a word and a text, return the count of the
 * occurrences of anagrams of the word in the text
 * https://www.geeksforgeeks.org/count-occurrences-of-anagrams/
 *
 * @author Vinod Akkepalli
 */
public class CountOccurrancesOfAnagram {

    public static final int CHAR_SIZE = 256;

    public static void main(String[] args) {
        String str = "forxxorfxdofr";
        String word = "for";
        System.out.print(countAnagrams(str, word));
    }

    private static int countAnagrams(String str, String word) {
        int sLen = str.length();
        int wLen = word.length();
        int res = 0;
        char[] cStr = str.toCharArray();
        char[] cWord = word.toCharArray();
        int[] count = new int[CHAR_SIZE];

        for (int i = 0; i < wLen; i++) {
            count[cWord[i]]++;
            count[cStr[i]]--;
        }
        // Check if whole array has zeros only
        if(isZeroArray(count)) {
            res++;
        }

        for (int i = wLen; i < sLen ; i++) {
            // Add last character of current window
            count[cStr[i]]++;
            // Remove first character of previous window
            count[cStr[i-wLen]]--;
            if(isZeroArray(count)){
                res++;
            }
        }
        return res;
    }

    private static boolean isZeroArray(int[] count) {
        for (int i = 0; i < CHAR_SIZE; i++) {
            if(count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
