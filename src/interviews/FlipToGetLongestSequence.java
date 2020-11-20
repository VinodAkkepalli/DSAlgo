package interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Description</b> :
 * Given an array of 0s & 1s
 * Find an index when flipped should given largest continuous sequence of 0s or 1s
 *
 * eg: [1, 0, 0, 0, 1, 0, 0, 1, 1] => [1, 0, 0, 0, 0, 0, 0, 1, 1] => 4th index
 * [1, 1, 1, 1, 0, 0, 1, 1, 0] => [1, 1, 1, 1, 1, 0, 1, 1, 0] => 4th index
 * [1, 0, 0, 1, 0, 1, 1] => [1, 0, 0, 0, 0, 1, 1] => 3rd index
 *                       => [1, 0, 0, 1, 1, 1, 1] => 4th index
 *
 * Pre-Condition: Array containing only 1s or 0s.
 * Only one replacement is allowed.
 * Goal: Max sequence of digits after that replacement.
 * O/P: Index at which the digit needs replacement.
 *
 * @author Vinod Akkepalli
 */

public class FlipToGetLongestSequence {

    public static void main(String[] args) {

//        int[] arr = {1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0};   //output: 9
//        int[] arr = {1};  // output: -1
//        int[] arr = {1, 1};   // output: -1
//        int[] arr = {1,1,1,1,0};  // output: 4
//        int[] arr = {1,1,1,0,0,0,0,0,1,1,1,1,1,1};  // output: 7
//        int[] arr = {1,1,1,0,0};  // output: 3
        int[] arr = {0,0,1,1,1};  // output: 1

        int maxSequenceIndex = getMaxSeqIndex(arr);
        System.out.println(maxSequenceIndex);
    }

    public static int getMaxSeqIndex(int[] arr) {
        //construct size array
        Integer[] sizeArray = getSizeArray(arr);

        if(sizeArray.length == 1) {
            return -1;
        }

        int sum = sizeArray[0];
        int index = sizeArray[0];
        int maxLen = sizeArray[0];
        int tempMaxLen;

        for (int i = 1; i < sizeArray.length; i++) {

            if(sizeArray[i] == 1 && i+1 < sizeArray.length) {

                tempMaxLen = sizeArray[i-1] + 1 + sizeArray[i+1];
                if(tempMaxLen > maxLen) {
                    maxLen = tempMaxLen;
                    index = sum;
                }
                sum += sizeArray[i] + sizeArray[i+1];
                i++;

            } else if (sizeArray[i] == 1 && i+1 >= sizeArray.length) {

                tempMaxLen = sizeArray[i-1] + 1;
                if(tempMaxLen > maxLen) {
                    maxLen = tempMaxLen;
                    index = sum;
                }
                sum += sizeArray[i];

            } else {

                tempMaxLen = sizeArray[i];
                if(tempMaxLen > maxLen) {
                    maxLen = tempMaxLen;
                    index = sum-1;
                }
                sum += sizeArray[i];
            }
        }
        return index;
    }


//  returns size array of input array
//    input: {1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0}
//    output:  {1, 2, 2, 4, 1, 2}
    public static Integer[] getSizeArray(int[] arr) {
        int len = arr.length;
        int tempSize = 1;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < len; i++) {
            if (arr[i - 1] == arr[i]) {
                tempSize++;
            } else {
                list.add(tempSize);
                tempSize = 1;
            }
        }
        list.add(tempSize);
        System.out.println(list);

        return list.toArray(new Integer[0]);
    }
}
