package practice.arrays.stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * <b>Description</b> :
 * https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 *
 * @author Vinod Akkepalli
 */
public class StockSpanProblem {

    public static void main(String[] args) {

        int[] arr = {100, 80, 60, 70, 60, 75, 85};  // output: [1, 1, 1, 2, 1, 4, 6]
//        int[] arr = { 10, 4, 5, 90, 120, 80 };  // output: [1, 1, 2, 4, 5, 1]


        System.out.println("Original Array is: " + Arrays.toString(arr));
        int[] res = getStockSpan(arr);
        System.out.println("stock span array is:" + Arrays.toString(res));
    }

    private static int[] getStockSpan(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
//        to store pair of array element and element index
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            if(stack.isEmpty()) {
                res[i] = 1;
            } else if(stack.peek().getKey() > arr[i]) {
                res[i] = i - stack.peek().getValue();
            } else if(!stack.isEmpty() && stack.peek().getKey() <= arr[i]) {
                while(!stack.isEmpty() && stack.peek().getKey() <= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    res[i] = i+1;
                } else {
                    res[i] = i - stack.peek().getValue();
                }
            }
            stack.push(Map.entry(arr[i], i));
        }

        return res;
    }


}
