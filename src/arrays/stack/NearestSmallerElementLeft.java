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
        
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        //ADJUST DIRECTION (RIGHT: n-1→0 or LEFT: 0→n-1)
        //If 'LEFT' mentioned, loop should be from 0 to n-1, if 'RIGHT' mentioned, loop should be from n-1 to 0
        for (int i = 0; i < n; i++) {
            
            //ADJUST CONDITION (GREATER: < or SMALLER: >)
            //If 'GREATER' mentioned, we pop all element which are smaller than current element,
            //if 'SMALLER' mentioned, we pop all element which are greater than current element
            while (!stack.empty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            
            //The top of the stack is your answer (or -1 if empty)
            result[i] = stack.empty() ? -1 : stack.peek();
            
            //Push current element onto the stack for the next ones to use
            stack.push(i);
        }
        return result;
    }

}
