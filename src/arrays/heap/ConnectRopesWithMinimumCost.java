package arrays.heap;

import java.util.PriorityQueue;

/**
 * Given an array arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost.
 * The cost to connect two ropes is the sum of their lengths.
 *
 * https://www.geeksforgeeks.org/dsa/connect-n-ropes-minimum-cost/
 * https://www.youtube.com/watch?v=_k_c9nqzKN0&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=9
 */
public class ConnectRopesWithMinimumCost {
    static void main() {
        int[] arr = {4, 3, 2, 6};   //ans = 29
//        int[] arr = {1, 2, 3, 4, 5};    //ans = 33
//        int[] arr = {5, 2, 5, 2};    //ans = 27

        System.out.println("Minimum Cost to Connect Ropes: " + getMinimumCostToConnectRopes(arr));
    }

    private static int getMinimumCostToConnectRopes(int[] arr) {
        int result = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int j : arr) {
            minHeap.add(j);
        }

        int num1;
        int num2;
        int currentSum = 0;

        while(minHeap.size() > 1) {
            num1 = minHeap.remove();
            num2 = minHeap.remove();
            currentSum = num1 + num2;
            result += currentSum;

            if(minHeap.isEmpty()){
                break;
            } else {
                minHeap.add(currentSum);
            }
        }

        return result;
    }

}
