package practice.arrays.stack;

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

        findMaxDifference(arr);
    }

    private static void findMaxDifference(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int len = arr.length;
        int[] ls = new int[len];
        int[] rs = new int[len];

        if(len < 1) return;

        //find right-small array
        for (int i = len - 1; i > -1; i--) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.println(arr[i] + " -> " + 0);
                rs[i] = 0;
            } else {
                while (arr[i] < stack.peek()) {
                    stack.pop();
                }
                System.out.println(arr[i] + " -> " + stack.peek());
                rs[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        //find left-small array
        stack.clear();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.println(arr[i] + " -> " + 0);
                ls[i] = 0;
            } else {
                while (arr[i] < stack.peek()) {
                    stack.pop();
                }
                System.out.println(arr[i] + " -> " + stack.peek());
                ls[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, Math.abs(ls[i] - rs[i]));
        }

        System.out.println("Max difference is: " + max);
    }
}
