package arrays;

import java.util.Arrays;
import java.util.List;

/**
 * <b>Description</b> :
 * You are given an array of n integers from 1 to n.
 * Each integer appears exactly once except A which appears twice and B which is missing.
 * Return A and B.
 * Note: Your algorithm should have a linear runtime complexity.
 *      Could you implement it without using extra memory?
 *
 * https://www.geeksforgeeks.org/dsa/find-a-repeating-and-a-missing-number/#making-two-math-equations-on-time-and-o1-space
 *
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 * https://www.youtube.com/playlist?list=PL_z_8CaSLPWdJfdZHiNYYM46tYQUjbBJx
 *
 * @author Vinod Akkepalli
 */
public class FindSingleMissingAndDuplicateNumbers {

    static void main() {
//        int[] arr = {3, 1, 3, 6, 2, 5};
        int[] arr = {4, 3, 6, 2, 1, 1};

        missingAndDuplicateNumbers_swapSort(arr);

        List<Integer> result = findSingleMissingAndDuplicate_UsingMath(arr);
        System.out.println("Missing# " + result.get(0)
                + " Repeated# " + result.get(1));

        result = findSingleMissingAndDuplicate_UsingFrequencyArray(arr);
        System.out.println("Missing# " + result.get(0)
                + " Repeated# " + result.get(1));

        result = findSingleMissingAndDuplicate_UsingArrayMarking(arr);
        System.out.println("Missing# " + result.get(0)
                + " Repeated# " + result.get(1));

    }

    /* Uses swap sort procedure TC=O(n) SC=constant*/
    private static void missingAndDuplicateNumbers_swapSort(int[] arr) {
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


    /*************************************
     *  This approach works for cases where input has a single missing number and a single repeated number
     *  Uses mathematical formulas added in code comments
     *  Does not alter input array
     *
     *  TC=O(n) SC=constant
     * @return
     */


    static List<Integer> findSingleMissingAndDuplicate_UsingMath(int[] arr) {
        int n = arr.length;

        // Expected sum and sum of squares for numbers from 1 to n
        int s = (n * (n + 1)) / 2;
        int ssq = (n * (n + 1) * (2 * n + 1)) / 6;

        int missing = 0, repeating = 0;

        // Subtract actual values from expected sums
        for (int i = 0; i < n; i++) {
            s -= arr[i];
            ssq -= arr[i] * arr[i];
        }

        // Let x = missing, y = repeating
        // s = x - y
        // ssq = x^2 - y^2 = (x - y)(x + y) = s * (x + y)
        // => x + y = ssq / s
        // => x = (s + ssq / s) / 2
        // => y = x - s
        missing = (s + ssq / s) / 2;
        repeating = missing - s;

        return List.of(missing, repeating);
    }


    /**
     *
     * The idea is to use a frequency array to keep track of how many times each number appears in the original array.
     * Since we know the numbers should range from 1 to n with each appearing exactly once, any number appearing twice
     * is our repeating number, and any number with zero frequency is our missing number.
     *
     * Using Visited Array - O(n) Time and O(n) Space
     *
     */

    static List<Integer> findSingleMissingAndDuplicate_UsingFrequencyArray(int[] arr) {
        int n = arr.length;

        // frequency array to count occurrences
        int[] freq = new int[n + 1];
        int repeating = -1;
        int missing = -1;

        // count frequency of each element
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        // identify missing and repeating numbers
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) missing = i;
            else if (freq[i] == 2) repeating = i;
        }

        return List.of(missing, repeating);
    }


    /**
     * The main idea is to use the input array itself for tracking: it negates the value at the index corresponding to
     * each element to mark it as visited. If it encounters a value that has already been negated, it identifies that
     * number as the repeating one. In a second pass, it finds the index that remains positive, which corresponds to the missing number.
     *
     * Using Array Marking - O(n) Time and O(1) Space
     *
     */

    static List<Integer> findSingleMissingAndDuplicate_UsingArrayMarking (int[] arr) {

        int n = arr.length;
        int repeating = -1;

        // traverse the array and mark visited indices
        // by negating the value at index arr[i] - 1
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);

            // if the value at index val - 1 is already negative
            // it means we've seen this value before
            if (arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            } else {
                // if it's already negative, this value is
                // the repeating one
                repeating = val;
            }
        }

        int missing = -1;

        // after marking, the index with a positive value
        // corresponds to the missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return List.of(missing, repeating);
    }

}
