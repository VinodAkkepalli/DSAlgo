package practice.arrays.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <b>Description</b> :
 * Sort elements of array in the order of their frequency
 * https://www.youtube.com/watch?v=hLR5aMzYGGk&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=7
 *
 * @author Vinod Akkepalli
 */
public class FrequencySort {
    public static void main(String[] args) {
//        int[] arr = {1, 1, 3, 1, 3, 4, 2};  // output: {1, 1, 1, 3, 3, 4, 2}
        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};  // output: {8, 8, 8, 2, 2, 5, 5, 6}

        System.out.println("Original array : " + Arrays.toString(arr));
        int[] res = frequencySort(arr);
        System.out.println("Sorted according to frequency: " + Arrays.toString(res));
    }

    private static int[] frequencySort(int[] arr) {
        Map<Integer, Integer> fMap = new HashMap<>();
        int[]  res = new int[arr.length];

        Arrays.stream(arr).forEach(i -> fMap.merge(i, 1, Integer::sum));
//        System.out.println(fMap);

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        fMap.forEach((key, value) -> maxHeap.add(Map.entry(key, value)));
//        System.out.println("Min heap is: " + maxHeap);

        int k = 0;
        int heapSize = maxHeap.size();
        for (int i = 0; i < heapSize; i++) {
            Map.Entry<Integer, Integer> entry = maxHeap.remove();
            for (int j = 0; j < entry.getValue(); j++) {
                res[k++] = entry.getKey();
            }
        }

        return res;
    }
}
