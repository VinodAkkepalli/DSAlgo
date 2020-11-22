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

    public static void main(String[] args) {

        String str = "sw cloud dell search sw work blue";
        String word1 = "sw";
        String word2 = "blue";

        String ans = findStringBetweenWords(str, word1, word2);
        System.out.println(ans);
    }

    private static String findStringBetweenWords(String str, String word1, String word2) {
        int len = str.length();
        int start;
        int end;

        for (int i = 0; i < len; i++) {
            start = str.indexOf(word1);
        }
        return null;
    }


}


