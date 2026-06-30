package arrays.heap;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <b>Description</b> :
 * Given an unsorted array and two numbers x and k, find k closest values to x.
 *
 * https://www.youtube.com/watch?v=J8yLD-x7fBI&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=5
 *
 * @author Vinod Akkepalli
 */
public class KClosestNumbers {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        int k = 3;
        int x = 7;

        kClosestNumbers(arr, x, k);
    }

    private static void kClosestNumbers(int[] arr, int x, int k) {

        int[] diffArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            diffArr[i] = Math.abs(arr[i] - x);
        }

        // Using Max Heap to store the closest numbers to x
        // The heap will store the difference and the index of the element in the original array
        // Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                // (o1, o2) -> o2.getKey().compareTo(o1.getKey()));
        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(Map.Entry.comparingByKey((a, b) -> b - a));

        for (int i = 0; i < diffArr.length; i++) {
            maxHeap.add(Map.entry(diffArr[i], i));
            if(maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = maxHeap.remove();
            System.out.println(arr[entry.getValue()] + " of index " + entry.getValue() );
        }
    }
}
