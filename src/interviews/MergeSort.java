package interviews;

/**
 * <b>Description</b> : Implement merge sort
 *
 * @author Vinod Akkepalli
 */
public class MergeSort {
    // Merges two sub arrays of arr[].
    // First sub array is arr[l..m]
    // Second sub array is arr[m+1..r]
    static void merge(int[] arr, int l, int m, int r)
    {
        // Find sizes of two sub arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] tempLeft = new int[n1];
        int[] tempRight = new int[n2];

        /*Copy data to temp arrays*/
        System.arraycopy(arr, l, tempLeft, 0, n1);
        System.arraycopy(arr, m + 1, tempRight, 0, n2);

        /* Merge the temp arrays */

        // Initial indexes of first and second sub arrays
        int i = 0, j = 0;

        // Initial index of merged sub array array
        int k = l;
        while (i < n1 && j < n2) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of tempLeft[] if any */
        while (i < n1) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }

        /* Copy remaining elements of tempRight[] if any */
        while (j < n2) {
            arr[k] = tempRight[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using merge()
    static void sort(int[] arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    static void printArray(int[] arr)
    {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
