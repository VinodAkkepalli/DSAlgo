package practice.arrays.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>Description</b> : Given an array of size n and a number k.
 *  We must modify array K number of times.
 *  Here modify array means in each operation we can replace any array element arr[i] by arr[i]/2.
 *  We need to perform this operation in such a way that after K operations, sum of array must be maximum?
 *
 *  Array contains only +ve numbers
 *  When division by 2 does not result in integer take ceiling of the result
 *  Problem is similar to https://www.geeksforgeeks.org/maximize-array-sum-k-negations-set-2/
 *
 *
 * @author Vinod Akkepalli
 */
public class MaxArraySumAfterKOperations {

    public static void main(String[] args) {
        int[] arr = {11, 20, 5};
        int numOpsAllowed = 2;

        findMaxSum(arr, numOpsAllowed);
    }

    private static void findMaxSum(int[] arr, int numOpsAllowed) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(arr).forEach(maxHeap::add);

        System.out.println(maxHeap.toString());

        while (numOpsAllowed-- > 0) {
            maxHeap.add((int) Math.ceil(maxHeap.poll()/2d));
        }

        AtomicInteger sum = new AtomicInteger();
        maxHeap.forEach(sum::addAndGet);
        System.out.println(sum);
    }
}
