package practice.slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Description</b> :
 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 * https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4
 *
 * @author Vinod Akkepalli
 */
public class FirstNegativeIntegerInEveryWindow {
    public static void main(String[] args) {
//        int[] arr = {-8, 2, 3, -6, 10}; //output: [-8, 0, -6, -6]
//        int k = 2;

        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28}; //output: [-1, -1, -7, -15, -15, 0]
        int k = 3;

        int[] firstNegativeArray = getFirstNegativeArray(arr, k);
        System.out.println("Input array is: " + Arrays.toString(arr));
        System.out.println("Output array is: " + Arrays.toString(firstNegativeArray));

    }

    public static int[] getFirstNegativeArray(int[] arr, int k) {
        int arrLen = arr.length;
        int[] res = new int[arrLen-k+1];
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if(arr[i]<0) {
                list.add(i);
            }
        }
        int a = 0;
        res[a++] = !list.isEmpty() ? arr[list.get(0)]: 0;

        for (int i = k; i < arrLen; i++) {
            if(arr[i]<0) {
                list.add(i);
            }

            if(i-k == list.get(0)) {
                list.remove(0);
            }
            res[a++] = !list.isEmpty() ? arr[list.get(0)]: 0;
        }

        return res;
    }
}
