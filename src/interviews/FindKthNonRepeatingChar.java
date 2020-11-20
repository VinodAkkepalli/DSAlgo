package interviews;

import java.util.Arrays;

/**
 * <b>Description</b> : Given a string and a number k, find the k’th non-repeating character in the string.
 * Consider a large input string with lacs of characters and a small character set.
 * How to find the character by only doing only one traversal of input string?
 *  https://www.geeksforgeeks.org/kth-non-repeating-character/
 * @author Vinod Akkepalli
 */

public class FindKthNonRepeatingChar {

    public static void main(String[] args) {
        final String inputStr = "geeksforgeeks";
//        final String inputStr = "scrum of scrums";
//        final String inputStr = "abcdmmnnoopp";
//        final String inputStr = "mmnnooppqqabcdef";

        int k = 2;
        int index = findIndexOfKthNonRepeatingChar(inputStr, k);
        if(index > -1){
            System.out.println("Kth non-repeating character is: " + inputStr.charAt(index) );
        } else {
            System.out.println("no kth non repeating character");
        }
    }

    private static int findIndexOfKthNonRepeatingChar(String inputStr, int k) {
        int[] countArray = new int[256];
        int[] indexArray = new int[256];
        int strLen = inputStr.length();

        Arrays.fill(indexArray, Integer.MAX_VALUE);
        for(int i = 0; i < strLen; i++) {
            char c = inputStr.charAt(i);
            countArray[c]++;
            if(countArray[c] == 1) {
                indexArray[c] = i;
            } else if(countArray[c] > 1) {
                indexArray[c] = Integer.MAX_VALUE;
            }
        }

        Arrays.sort(indexArray);
//        System.out.println(Arrays.toString(indexArray));
        return indexArray[k-1] != Integer.MAX_VALUE ? indexArray[k-1]: -1;
    }


}
