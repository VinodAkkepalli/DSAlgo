package slidingwindow;

import java.util.*;

/**
 * <b>Description</b> :
 * Given an array arr[] of size N and an integer K. Find the maximum for each and every
 * contiguous sub array of size K.
 *
 * Example:
 *
 * Input 1:
 *     A = [1, 3, -1, -3, 5, 3, 6, 7]
 *     B = 3
 * Output 1:
 *     C = [3, 3, 5, 5, 6, 7]
 *
 * https://www.interviewbit.com/problems/sliding-window-maximum/
 * https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6
 *
 * @author Vinod Akkepalli
 */
public class MaxOfAllSubArraysOfSizeK {
    public static void main(String[] args) {
//        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7}; // output = [3, 3, 5, 5, 6, 7]
//        int k = 3;

        int[] arr = {1, 3, 2, 1, 2, 1}; // output = [3, 3, 2, 2]
        int k = 3;

        int[] maxOfSubArrays = findMaxOfSubArrays(arr, k);
        System.out.println(Arrays.toString(maxOfSubArrays));
    }

    private static int[] findMaxOfSubArrays(int[] arr, int k) {
        int i = 0;
        int j = 1;
        int len = arr.length;
        int[] output = new int[len-k+1];
        Deque<Integer> dq = new LinkedList<>();

        while(j<k) {
            addToQueue(dq, arr[j]);
            j++;
        }
        int l = 1;
        output[0] = dq.peekFirst();

        while(j<len) {

            addToQueue(dq, arr[j]);
            if(dq.peekFirst() == arr[i]) {
                dq.removeFirst();
            }
            output[l] = dq.peekFirst();
            i++;
            j++;
            l++;
        }
        return output;
    }

    private static void addToQueue(Deque<Integer> dq, int i) {
        while(dq.size() > 0 && dq.peekLast() < i) {
            dq.removeLast();
        }
        dq.add(i);
    }
}
