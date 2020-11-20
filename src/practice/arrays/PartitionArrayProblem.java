package practice.arrays;

import java.util.Arrays;

/**
 * <b>Description</b> :
 * Partition given array in two sub arrays such that all the elements
 * in the first sub array are less that all the elements in the second sub array.
 * Return the partition with partition happening at left most such possible index
 *
 * @author Vinod Akkepalli
 */
public class PartitionArrayProblem {

    public static void main(String[] args) {
//        int[] arr = {10, 1, 3, 4, 11, 14};
//        int[] arr = {5, -1, 3, 8, 6};
//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {5, 4, 3, 2, 1};

        System.out.println("Input Array: " + Arrays.toString(arr));
        int i = returnIndex(arr);
//        System.out.println(i);

        i = (i == arr.length) ? 0 : i;
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, i)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, i, arr.length)));

    }

    public static int returnIndex(int[] arr) {
        int length = arr.length;

        int[] arr2 = new int[length];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            max = Math.max(max, arr[i]);
            arr2[i] = max;
        }

//        System.out.println("Max array up to index is: " + Arrays.toString(arr2));

        int index = 0;
        while (index < length-1 && arr2[index] == arr2[index+1]) {
            index++;
        }

        return index+1;
    }
}
