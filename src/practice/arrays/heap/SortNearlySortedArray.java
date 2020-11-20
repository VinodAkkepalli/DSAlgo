package practice.arrays.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <b>Description</b> : Sort a nearly sorted array, also called as sort a K sorted array
 * https://www.geeksforgeeks.org/nearly-sorted-algorithm/
 * https://www.youtube.com/watch?v=dYfM6J1y0mU&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4
 *
 *  Complexity: O(n logk)
 * @author Vinod Akkepalli
 */
public class SortNearlySortedArray {

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 4, 70, 60, 50};
        int k = 4;

        int[] res = sortNearlySortedArray(arr, k);
        System.out.println("Sorted array is: " + Arrays.toString(res));
    }

    private static int[] sortNearlySortedArray(int[] arr, int k) {
        //Min heap to maintain smallest element at the top
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] res = new int[arr.length];
        int j = 0;
        for (int value : arr) {
            minHeap.add(value);
            if (minHeap.size() > k) {
                res[j++] = minHeap.remove();
            }
        }

        while(minHeap.size() > 0) {
            res[j++] = minHeap.remove();
        }
        return res;
    }
}
