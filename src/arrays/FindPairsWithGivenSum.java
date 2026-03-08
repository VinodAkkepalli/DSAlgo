package arrays;

import java.util.HashMap;

/**
 * Given an array arr[] of distinct integers. The task is to determine if there exist two pairs (a, b) and (c, d)
 * such that a + b = c + d, where a, b, c, and d are distinct elements.
 * Note: If multiple solutions exist, return any one valid pair.
 *
 * Examples:
 *
 * Input: arr[] = [3, 4, 7, 1, 2, 9, 8]
 * Output: (3, 7) and (4, 6)
 * Explanation: 3 + 7 = 10 and 4 + 6 = 10, satisfying the condition.
 *
 * Input: arr[] = [1, 2, 3, 4, 5]
 * Output: (1, 4) and (2, 3)
 * Explanation: 1 + 4 = 5 and 2 + 3 = 5, meeting the required condition.
 *
 * Input: arr[] = [2, 5, 1, 6]
 * Output: (2, 5) and (1, 6)
 * Explanation: 2 + 5 = 7 and 1 + 6 = 7, satisfying the condition.
 *
 * https://www.geeksforgeeks.org/dsa/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/
 *
 */

public class FindPairsWithGivenSum {



    static void main() {

        int[] arr = {3, 4, 7, 1, 2, 9, 8};

        int[] result = findPairsNaive(arr);
        int[] resultOpt = findPairsOptimized(arr);

        printOutput(result);
        printOutput(resultOpt);
    }

    private static void printOutput(int[] result) {
        if (result.length == 0) {
            System.out.println("No valid pairs found");
        } else {
            System.out.println("(" + result[0] + ", " + result[1] + ") and ("
                    + result[2] + ", " + result[3] + ")");
        }
    }

    private static int[] findPairsOptimized(int[] arr) {

        // HashMap to store sum of pairs
        HashMap<Integer, int[]> sumMap = new HashMap<>();

        // Checking all possible pairs (a, b)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];

                // If sum already exists, return both pairs
                if(sumMap.containsKey(sum)) {

                    int[] existing = sumMap.get(sum);

                    // Ensuring all elements are distinct
                    if(existing[0] != arr[i] && existing[0] != arr[j]
                            && existing[1] != arr[i] && existing[1] != arr[j]) {
                        return new int[]{existing[0], existing[1], arr[i], arr[j]};
                    };
                } else {
                    // Store the pair for this sum
                    sumMap.put(sum, new int[]{arr[i], arr[j]});
                }
            }
        }
        // Returning empty array if no valid pairs found
        return new int[]{};
    }

    // Function to find two pairs with the same sum
    static int[] findPairsNaive(int[] arr) {

        int n = arr.length;

        // Checking all possible pairs
        // (a, b) and (c, d)
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = 0; k < n; k++) {

                    for (int l = k + 1; l < n; l++) {

                        // Ensuring all elements are distinct
                        if (i != k && i != l && j != k && j != l) {

                            // Checking if the sum of both pairs is equal
                            if (arr[i] + arr[j] == arr[k] + arr[l]) {

                                // Returning the first valid pair found
                                return new int[]{arr[i], arr[j], arr[k], arr[l]};
                            }
                        }
                    }
                }
            }
        }

        // Returning empty array if no
        // valid pairs found
        return new int[0];
    }
}
