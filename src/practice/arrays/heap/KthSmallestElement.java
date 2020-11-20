package practice.arrays.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <b>Description</b> : Find Kth smallest number in a given array
 * https://www.youtube.com/watch?v=4BfL2Hjvh8g&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=2
 *
 * Complexity: O(n logk)
 * @author Vinod Akkepalli
 */
public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 5;

        System.out.println(k + "th smallest element in "
                + Arrays.toString(arr) + " is: "
                + kthSmallestElement(arr, k));
    }

    private static int kthSmallestElement(int[] arr, int k) {
        //Max heap to maintain largest number at top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : arr) {
            maxHeap.add(i);
            //maintains size of heap
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        return maxHeap.remove();
    }
}
