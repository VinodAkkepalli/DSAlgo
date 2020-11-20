package practice.arrays.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <b>Description</b> :
 * https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6
 *
 * @author Vinod Akkepalli
 */
public class TopKFrequentNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 1, 3, 1};
        int k = 2;

        System.out.println("Input array: " + Arrays.toString(arr));
        int[] res = findTopKFrequentNumbers(arr, k);
        System.out.println("Top " + k + " frequent numbers are: " + Arrays.toString(res));
    }

    private static int[] findTopKFrequentNumbers(int[] arr, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Map.Entry.comparingByValue());
        Map<Integer, Integer> fMap = new HashMap<>();
        int[] res = new int[k];

        Arrays.stream(arr).forEach(i -> fMap.merge(i, 1, Integer::sum));
//        System.out.println(fMap);

        for(Map.Entry<Integer,Integer> entry : fMap.entrySet()) {
            minHeap.add(entry);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }
//        System.out.println(minHeap);

        for (int i = k-1; i > -1; i--) {
            res[i] = minHeap.remove().getKey();
        }

        return res;
    }

}
