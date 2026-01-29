package arrays.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <b>Description</b> : Given an array, print the Index of Next Smaller Element (NSE) for every element.
 * The Next smaller Element for an element x is the first smaller element
 * on the left side of x in array. Elements for which no smaller element exist,
 * consider next smaller element as -1
 * https://www.youtube.com/watch?v=P1bAPZg5uaE&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=1
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
 * https://www.youtube.com/watch?v=T5s96ynzArg&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=3
 * https://www.youtube.com/watch?v=85LWui3FlVk&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=4
 *
 *
 * @author Vinod Akkepalli
 */

public class NearestSmallerElementLeft {

    public static void main(String[] args) {
        int[] arr = {60, 20, 50, 40, 10, 50, 60}; // ans = [-1, -1, 1, 1, -1, 4, 5]
//        int[] arr = {6, 2, 5, 4, 5, 1, 6};    // ans = [-1, -1, 1, 1, 3, -1, 5]
//        int[] arr = {10, 9, 2, 4, 8, 12, 13};   // ans = [-1, -1, -1, 2, 3, 4, 5]
        int[] res = getIndexOfNearestSmallerElementToLeft(arr);
        System.out.println("Index Array of Nearest Smaller Element on Left: " + Arrays.toString(res));
    }

    private static int[] getIndexOfNearestSmallerElementToLeft(int[] arr) {
        Stack<Integer> bottomSmallStack = new Stack<>();
        int arrLen = arr.length;
        int[] res = new int[arrLen];


        bottomSmallStack.push(-1);
        bottomSmallStack.push(0);
        res[0] = -1;

        for (int i = 1; i < arrLen; i++) {
            if(bottomSmallStack.peek() > -1 && arr[bottomSmallStack.peek()] < arr[i]) {
                res[i] = bottomSmallStack.peek();
                bottomSmallStack.push(i);
            } else if(bottomSmallStack.peek() > -1 && arr[bottomSmallStack.peek()] >= arr[i]) {
                while (bottomSmallStack.peek() > -1 && arr[bottomSmallStack.peek()] >= arr[i]) {
                    bottomSmallStack.pop();
                }
                res[i] = bottomSmallStack.peek();
                bottomSmallStack.push(i);
            }
        }
        return res;
    }
}
