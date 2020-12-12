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

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i] - x);
        }

        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (o1, o2) -> o2.getKey().compareTo(o1.getKey()));

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(Map.entry(arr[i], i));
            if(maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = maxHeap.remove();
            System.out.println(x + entry.getKey() + " of index " + entry.getValue() );
        }
    }
}
