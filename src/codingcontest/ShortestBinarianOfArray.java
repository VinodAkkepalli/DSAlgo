package codingcontest;

/**
 * @author Vinod Akkepalli
 *         Problem statement: please find the problem ShortestBinarianOfArray.PNG
 */

import java.util.Arrays;

public class ShortestBinarianOfArray {

    private ShortestBinarianOfArray() {
    }

    public static void main(String[] args) throws InterruptedException {

        // solution(new int[] {0}); // ans 1
        // solution(new int[] {1}); // ans 1
        // solution(new int[] {1, 0, 2, 0, 0, 2}); // ans 3
        // solution(new int[] {1, 5, 4}); // ans 3
        solution(new int[] {1, 1, 1, 1, 1, 1}); // ans 2
    }

    public static void solution(int[] array) throws InterruptedException {

        int len = array.length;
        int count = 0;
        int index;
        int temp = -999;
        int j = 0;

        // raising to the power of 2 of all the values in the array
        for (int i = 0; i < len; i++) {
            array[i] = (int) Math.pow(2, array[i]);
        }

        while (j < len) {

            Arrays.sort(array);
            index = Arrays.binarySearch(array, 0, len - 1, array[j]);

            // to find if there is a duplicate of the first non-zero value in array
            if (index == j) {
                if (j - 1 > -1) {
                    temp = Arrays.binarySearch(array, 0, j - 1, array[j]);
                }

                if (temp > -1) {
                    index = temp;
                }

                if (temp < 0) {
                    temp = Arrays.binarySearch(array, j, len - 1, array[j]);
                    if (temp > -1) {
                        index = temp;
                    }
                }
            }

            // case when the first non-zero int of the array is non-duplicate
            // then proceed to next non-zero int
            if (index == j) {
                j = findFirstNonZeroIndex(array, j + 1, len);
                continue;
            }

            // case when there is a duplicate of the first occurring int in the array
            // we double the value at the first index and make value = 0 at duplicate location
            if (index > -1 && index != j) {
                array[index] = 2 * array[index];
                array[j] = 0;
            }

            j = findFirstNonZeroIndex(array, j, len);
            // break when final no-zero element is also non-duplicate
            if (index < 0) {
                break;
            }
        }

        for (int i = 0; i < len; i++) {
            if (array[i] > 0) {
                count++;
            }
        }

        System.out.println("Final Array is: " + Arrays.toString(array));
        System.out.println("Ans = " + count);
    }

    // method to return the index of the first non-zero value in a given array
    public static int findFirstNonZeroIndex(int[] arr, int fromIndex, int toIndex) {
        int index = fromIndex;
        while (arr[index] < 1 && index < toIndex) {
            index++;
        }
        return index;
    }

}
