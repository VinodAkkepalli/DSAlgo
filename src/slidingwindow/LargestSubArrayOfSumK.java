package slidingwindow;

/**
 * <b>Description</b> :
 * Given an array containing N positive integers and an integer K.
 * Your task is to find the length of the longest Sub-Array with sum of the elements
 * equal to the given value K.
 *
 * Input:
 * K = 5
 * arr = {4, 1, 1, 1, 2, 3, 5}
 * Output:
 * 4
 *
 * https://www.youtube.com/watch?v=cyu_nuW5utA&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=7
 * https://www.youtube.com/watch?v=TfQPoaRDeMQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=8 *
 *
 * @author Vinod Akkepalli
 */
public class LargestSubArrayOfSumK {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 1, 1, 5, 3, 5};
        int k = 8;

        System.out.println("Largest sub arrays is of size: " + findLargestSubArrayOfSumK(arr, k));
    }

    private static int findLargestSubArrayOfSumK(int[] arr, int k) {
        int length = Integer.MIN_VALUE;

        int i = 0;
        int j = 0;
        int l = arr.length;
        int sum = 0;

        while (j < l) {

            sum += arr[j];

            if(sum > k) {
                while (sum > k) {
                    sum -= arr[i];
                    i++;
                }
            }
            if(sum == k) {
                length = Math.max(length, j-i+1);
            }
            j++;
        }

        return length;
    }
}
