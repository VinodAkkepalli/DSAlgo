package practice.arrays;

import java.util.Arrays;

/**
 * <b>Description</b> :
 * You are given a read only array of n integers from 1 to n.
 * Each integer appears exactly once except A which appears twice and B which is missing.
 * Return A and B.
 * Note: Your algorithm should have a linear runtime complexity.
 *      Could you implement it without using extra memory?
 *
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 * https://www.youtube.com/playlist?list=PL_z_8CaSLPWdJfdZHiNYYM46tYQUjbBJx
 *
 * @author Vinod Akkepalli
 */
public class FindMissingAndDuplicateNumbers {

    public static void main(String[] args) {
//        int[] arr = {3, 1, 2, 6, 6, 3, 6};
        int[] arr = {3, 1, 3, 6, 6, 2, 5};

        missingAndDuplicateNumbers(arr);
    }

    /* Uses swap sort procedure TC=O(n) SC=constant*/
    private static void missingAndDuplicateNumbers(int[] arr) {
        int len =  arr.length;

        int i = 0;
        int temp;
        while(i < len) {
            if(arr[i] == i+1 || arr[arr[i]-1] == arr[i]) {
                i++;
            } else {
                temp = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[temp-1] = temp;
            }
        }

        System.out.println("Sorted array is: " + Arrays.toString(arr));

        for (int j = 0; j < len; j++) {
            if(arr[j] != j+1) {
                System.out.println("Missing# " + (j + 1) + " Repeated# " + arr[j]);
            }
        }
    }
}
