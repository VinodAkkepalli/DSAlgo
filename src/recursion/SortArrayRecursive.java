package recursion;

import java.util.Arrays;

/**
 * <b>Description</b> :
 * Sort an array using recursion
 * https://www.youtube.com/watch?v=AZ4jEY_JAVc&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=6
 *
 * @author Vinod Akkepalli
 */
public class SortArrayRecursive {

    static int[] arr = {6, 32, 1, 2, 6, 9, 4, 23, 5};

    public static void main(String[] args) {

        System.out.println(Arrays.toString(arr));
        sortRec(arr, 0, arr.length-1);

        System.out.println("Sorted array is: ");
        System.out.println(Arrays.toString(arr));
    }

    private static void sortRec(int[] arr, int li, int ri) {
//        base case
        if(li == ri)
            return;

        sortRec(arr, li+1, ri);

//        insert current element at correct place
        int temp = arr[li];
        int i = li;
        while(i < ri && temp > arr[i+1] ) {
            arr[i] = arr[i+1];
            i++;
        }
        arr[i] = temp;
    }
}
