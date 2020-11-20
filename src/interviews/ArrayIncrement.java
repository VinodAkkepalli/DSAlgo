package interviews;

import java.util.Arrays;

/**
 * @author Vinod Akkepalli
 * <b>Description</b> :  Given an array representing a +ve integer as below, return array with values integer+1
 * 
 *   Eg. 123 can be represented as {1,2,3}
 *   if {1,2,3} is given as input return {1,2,4}
 * 
 *
 */

public class ArrayIncrement {

    public static void main(String[] args) {
        int[] arr = {9, 9, 9, 9};
        // int[] arr = {1, 9, 9};
        // int[] arr = {1, 8, 9};
        // int[] arr = {1};
        boolean flag;

        int n = arr.length;
        if (arr[n - 1] < 9) {
            arr[n - 1]++;
        } else {
            flag = true;
            int i = n - 1;
            while (flag && i > -1) {

                // when all the digits are 9s
                if (i == 0 && arr[0] == 9) {
                    int[] arr1 = new int[n + 1];
                    arr1[0] = 1;
                    Arrays.fill(arr, 1, n, 0);
                    arr = arr1;
                    break;
                }
                // when a digit value equals 9 then make it zero
                // and proceed to increment previous digit
                if (arr[i] == 9) {
                    arr[i] = 0;
                    i--;
                } else {
                    // when a digit is not 9 simply increment it and move out of the loop
                    arr[i]++;
                    flag = false;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
