package practice.arrays.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <b>Description</b> : Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element
 * on the right side of x in array. Elements for which no greater element exist,
 * consider next greater element as -1
 * https://www.youtube.com/watch?v=P1bAPZg5uaE&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=1
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
 * https://www.youtube.com/watch?v=T5s96ynzArg&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=3
 * https://www.youtube.com/watch?v=85LWui3FlVk&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=4
 * https://www.geeksforgeeks.org/next-greater-element/
 *
 *
 * @author Vinod Akkepalli
 */
public class NearestGreaterElementLeft {

    public static void main(String[] args) {

        int[] arr = {10, 9, 2, 4, 8, 12, 13};
//        int[] arr = {10};
//        int[] arr = {10, 9, 8};
//        int[] arr = {2, 4, 8, 12, 13};
//        int[] arr = {2, 2, 2, 2, 2};

        int[] res = nearestGreaterElementLeft(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] nearestGreaterElementLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int len = arr.length;
        int[] res = new int[len];
        if(len < 1) return res;

        for (int i = 0; i < len; i++) {
            if(stack.isEmpty()) {
                res[i] = -1;
            } else if (stack.peek() > arr[i]) {
                res[i] = stack.peek();
            } else if (!stack.isEmpty() && stack.peek() <= arr[i]) {
                while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return res;
    }
}
