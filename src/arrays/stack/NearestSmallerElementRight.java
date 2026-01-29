package arrays.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <b>Description</b> : Given an array, print the Index of Next Smaller Element (NSE) on right for every element.
 * The Next smaller Element for an element x is the first smaller element
 * on the right side of x in array. Elements for which no smaller element exist,
 * consider next smaller element as length of input array
 * https://www.youtube.com/watch?v=P1bAPZg5uaE&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=1
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
 * https://www.youtube.com/watch?v=T5s96ynzArg&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=3
 * https://www.youtube.com/watch?v=85LWui3FlVk&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=4
 *
 *
 * @author Vinod Akkepalli
 */

public class NearestSmallerElementRight {

    public static void main(String[] args) {
                int[] arr = {60, 20, 50, 40, 10, 50, 60}; // ans = [1, 4, 3, 4, 7, 7, 7]
//        int[] arr = {6, 2, 5, 4, 5, 1, 6};    // ans = [1, 5, 3, 5, 5, 7, 7]
//        int[] arr = {10, 9, 2, 4, 8, 12, 13};   // ans = [1, 2, 7, 7, 7, 7, 7]
        int[] res = getIndexOfNearestSmallerElementOnRight(arr);
        System.out.println("Max Area: " + Arrays.toString(res));
    }

    private static int[] getIndexOfNearestSmallerElementOnRight(int[] arr) {
        Stack<Integer> bottomBigStack = new Stack<>();
        int arrLen = arr.length;
        int[] res = new int[arrLen];

        bottomBigStack.push(arrLen);
        bottomBigStack.push(arrLen-1);
        res[arrLen-1] = 7;

        for (int i = arrLen-2; i >= 0; i--) {
            if(bottomBigStack.peek() < arrLen && arr[bottomBigStack.peek()] < arr[i]) {
                res[i] = bottomBigStack.peek();
                bottomBigStack.push(i);
            } else if(bottomBigStack.peek() < arrLen && arr[bottomBigStack.peek()] >= arr[i]) {
                while (bottomBigStack.peek() < arrLen && arr[bottomBigStack.peek()] >= arr[i]) {
                    bottomBigStack.pop();
                }
                res[i] = bottomBigStack.peek();
                bottomBigStack.push(i);
            }
        }
        return res;

    }
}
