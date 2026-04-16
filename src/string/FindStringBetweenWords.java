package string;


/**
 * <b>Description</b> :
 *
 * sw cloud dell search sw work blue
 *
 * sw blue
 *
 * sw cloud dell search sw work blue
 *
 * sw work blue
 *
 * @author Vinod Akkepalli
 */

public class FindStringBetweenWords {

    static void main() {

        String str = "sw cloud dell search sw work blue";
        String word1 = "sw";
        String word2 = "blue";

        String ans = findStringBetweenWords(str, word1, word2);
        System.out.println(ans);
    }

    private static String findStringBetweenWords(String str, String word1, String word2) {
        String ans = null;
        int startIndex = str.indexOf(word1) + word1.length();
        int endIndex = str.indexOf(word2, startIndex);

        if (startIndex != -1 && endIndex != -1) {
            ans = str.substring(startIndex, endIndex).trim();
        }

        return ans;
    }


}


