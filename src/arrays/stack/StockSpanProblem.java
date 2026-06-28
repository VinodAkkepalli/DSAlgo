package arrays.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <b>Description</b> :
 * https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 * 
 * The span of the stock price on a given day is defined as the maximum number of consecutive days just before the given day,
 * for which the price of the stock on the current day is less than or equal to its price on the given day.
 *
 * Solution: This is a classic problem which can be solved using stack. 
 * The idea is to use stack to store the index of the elements in the array. 
 * We can use the stack to find the greater element to the left of for each element in the array.
 * 
 * Pattern: Next Greater Element to the left
 * 
 * 
 * @author Vinod Akkepalli
 */
public class StockSpanProblem {

    public static void main(String[] args) {

        // int[] arr = {100, 80, 60, 70, 60, 75, 85};  // output: [1, 1, 1, 2, 1, 4, 6]
       int[] arr = { 10, 4, 5, 90, 120, 80 };  // output: [1, 1, 2, 4, 5, 1]


        System.out.println("Original Array is: " + Arrays.toString(arr));
        int[] res = getStockSpan(arr);
        System.out.println("stock span array is:" + Arrays.toString(res));

    }

    // Pattern: Next Greater Element to the left
    private static int[] getStockSpan(int[] arr) {
        
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        //LEFT => i = 0  to i = arr.length-1
        for (int i = 0; i < arr.length; i++) {

            // pop elements from stack while stack is not empty and top of stack is less than or equal to current element
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            // if stack is empty, then all elements to the left are smaller than current element, so span is i+1
            // else span is the difference between current index and index of last greater element to the left
            res[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i);
        }

        return res;
    }


}
