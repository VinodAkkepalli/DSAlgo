package binarysearch;

/**
 * <b>Description</b> :
 * Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise)
 * k number of times. Given such an array, find the value of k.
 * https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 *
 * @author Vinod Akkepalli
 */
public class RotationCountInSortedRotatedArray {
    static void main() {
//        int[] arr = {15, 18, 2, 3, 6, 12};  //output: 2
//        int[] arr = {7, 9, 11, 12, 15};  //output: 0
        int[] arr = {7, 9, 11, 12, 5};  //output: 4

        System.out.println("Required Number of Rotations = " + rotationCountInSortedRotatedArray(arr));

    }

    private static int rotationCountInSortedRotatedArray(int[] arr) {

        int first = 0;
        int last = arr.length-1;
        int mid;

        while (first <= last) {

            // If subarray is already sorted, smallest is at first index
            // index of smallest number is the number of rotations required
            if(arr[first] <= arr[last]) {
                return first;
            }

            mid = (first + last)/2;

            if(arr[mid] > arr[last]) {
                // Minimum is in the right half
                first = mid + 1;
            } else {
                // Minimum is in the left half (could be mid)
                last = mid;
            }
        }

        return -1;
    }
}
