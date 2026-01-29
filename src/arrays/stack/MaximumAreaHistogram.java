package arrays.stack;

import java.util.Arrays;
import java.util.Stack;

import static java.lang.Math.max;

/**
 * <b>Description</b> : Given an array arr[] representing a histogram, where each element denotes the height of a bar
 * and every bar has a uniform width of 1 unit, find the largest rectangular area that can be formed within the histogram.
 * The rectangle must be formed using contiguous bars.
 * <p>
 * <a href="https://www.geeksforgeeks.org/dsa/largest-rectangular-area-in-a-histogram-using-stack/">...</a>
 * <a href="https://www.youtube.com/watch?v=J2X70jj_I1o&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=9">...</a>
 *
 * @author Vinod Akkepalli
 */
public class MaximumAreaHistogram {

    public static void main(String[] args) {
//        int[] arr = {60, 20, 50, 40, 10, 50, 60}; //// ans = 100
//        int[] arr = {6, 2, 5, 4, 5, 1, 6};    // ans = 12
        int[] arr = {10, 9, 2, 4, 8, 12, 13};   // ans = 24
        System.out.println("Max Area: " + getMaxArea(arr));
    }

    // Find index of Nearest Smaller Element to Left
    // Find index of Nearest Smaller Element to Right
    // find max of arr[i] * NSER[i] - nsel[i] - 1 for each index
    private static int getMaxArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int arrLen = arr.length;

        if (arrLen == 1) {
            return arr[0];
        } else if (arrLen == 2) {
            return (arr[0] <= arr[1] ? arr[0] * arrLen : arr[1] * arrLen);
        }

        int[] nsel = new int[arrLen];
        int[] nser = new int[arrLen];

        getNSEL(arr, nsel);
        getNSER(arr, nser);

        System.out.println("NSEL array is: " + Arrays.toString(nsel));
        System.out.println("NSER array is: " + Arrays.toString(nser));

        int max = -1;
        for (int i = 0; i < arrLen; i++) {
            max = max(max, (nser[i] - nsel[i] - 1) * arr[i]);
        }

        return max;
    }


    private static void getNSEL(int[] arr, int[] nsel) {
        Stack<Integer> bottomSmallStack = new Stack<>();
        int arrLen = arr.length;

        bottomSmallStack.push(-1);
        bottomSmallStack.push(0);
        nsel[0] = -1;

        for (int i = 1; i < arrLen; i++) {
            if(bottomSmallStack.peek() > -1 && arr[bottomSmallStack.peek()] < arr[i]) {
                nsel[i] = bottomSmallStack.peek();
                bottomSmallStack.push(i);
            } else if(bottomSmallStack.peek() > -1 && arr[bottomSmallStack.peek()] >= arr[i]) {
                while (bottomSmallStack.peek() > -1 && arr[bottomSmallStack.peek()] >= arr[i]) {
                    bottomSmallStack.pop();
                }
                nsel[i] = bottomSmallStack.peek();
                bottomSmallStack.push(i);
            }
        }
    }


    private static void getNSER(int[] arr, int[] nser) {
        Stack<Integer> bottomBigStack = new Stack<>();
        int arrLen = arr.length;

        bottomBigStack.push(arrLen);
        bottomBigStack.push(arrLen-1);
        nser[arrLen-1] = 7;

        for (int i = arrLen-2; i >= 0; i--) {
            if(bottomBigStack.peek() < arrLen && arr[bottomBigStack.peek()] < arr[i]) {
                nser[i] = bottomBigStack.peek();
                bottomBigStack.push(i);
            } else if(bottomBigStack.peek() < arrLen && arr[bottomBigStack.peek()] >= arr[i]) {
                while (bottomBigStack.peek() < arrLen && arr[bottomBigStack.peek()] >= arr[i]) {
                    bottomBigStack.pop();
                }
                nser[i] = bottomBigStack.peek();
                bottomBigStack.push(i);
            }
        }

    }
}
