package arrays.stack;

import java.util.Stack;

/**
 * <b>Description</b> :
 * Find maximum difference between nearest left smaller and nearest right smaller elements
 * If there is no smaller element on right side or left side of any element then we take
 * zero as the smaller element. For example for the leftmost element, the nearest
 * smaller element on the left side is considered as 0. Similarly, for rightmost elements,
 * the smaller element on the right side is considered as 0.
 * https://www.geeksforgeeks.org/find-maximum-difference-between-nearest-left-and-right-smaller-elements/
 *
 * @author Vinod Akkepalli
 */
public class MaxDifferenceBetweenLeftRightSmallerElements {

    public static void main(String[] args) {
        int[] arr = {2, 4, 8, 7, 7, 9, 3};  //output: 4
//        int[] arr = {2, 1, 8};  //output: 1
//        int[] arr = {5, 1, 9, 2, 5, 1, 7}; //output: 1

        int maxDiff = findMaxDifference(arr);
        System.out.println("Max difference is: " + maxDiff);
    }

    public static int findMaxDifference(int[] arr) {
        int n = arr.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        Stack<Integer> stack = new Stack<>();

        // ==========================================
        // STEP 1: Nearest Smaller Left (NSL)
        // ==========================================
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            // Record result (default to 0 if stack is empty)
            nsl[i] = stack.isEmpty() ? 0 : stack.peek();
            
            stack.push(arr[i]);
        }

        // CLEAR THE STACK BEFORE STEP 2!
        stack.clear();

        // ==========================================
        // STEP 2: Nearest Smaller Right (NSR)
        // ==========================================
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            // Record result (default to 0 if stack is empty)
            nsr[i] = stack.isEmpty() ? 0 : stack.peek();
            
            stack.push(arr[i]);
        }

        // ==========================================
        // STEP 3: Calculate Max Absolute Difference
        // ==========================================
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nsl[i] - nsr[i]);
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }
}
