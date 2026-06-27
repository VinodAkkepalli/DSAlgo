package arrays.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <b>Description</b> : Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element
 * on the left side of x in array. Elements for which no greater element exist,
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
        
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        //ADJUST DIRECTION (RIGHT: n-1→0 or LEFT: 0→n-1)
        //If 'LEFT' mentioned, loop should be from 0 to n-1, if 'RIGHT' mentioned, loop should be from n-1 to 0
        for (int i = 0; i < n; i++) {
            
            //ADJUST CONDITION (GREATER: < or SMALLER: >)
            //If 'GREATER' mentioned, we pop all element which are smaller than current element,
            //if 'SMALLER' mentioned, we pop all element which are greater than current element
            while (!stack.empty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            
            //The top of the stack is your answer (or -1 if empty)
            result[i] = stack.empty() ? -1 : arr[stack.peek()];
            
            //Push current element onto the stack for the next ones to use
            stack.push(i);
        }
        return result;
    }
}
