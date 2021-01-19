package slidingwindow;

/**
 * <b>Description</b> :
 * Given an array of integers and a number k, find maximum sum of a sub-array of size k.
 * https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/
 * https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3
 *
 * @author Vinod Akkepalli
 */
public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {40, 4, 2, 10, 23, 3, 1, 0, -20};
        int k = 4;

        int[] result = findMaxMinSum(arr, k);
        System.out.println("Max= " + result[0]);
        System.out.println("Min= " + result[1]);

        result = findMaxMinSum1(arr, k);
        System.out.println("Max= " + result[0]);
        System.out.println("Min= " + result[1]);
    }

    private static int[] findMaxMinSum(int[] arr, int k) {
        int sum = 0;
        int len = arr.length;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int max = sum;
        int min = sum;

//        System.out.println(sum);

        for (int i = k ; i < len ; i++) {
            sum = sum + (arr[i] - arr[i-k]);
            max = Math.max(sum, max);
            min = Math.min(sum, min);
        }

        return new int[]{max, min};
    }

    private static int[] findMaxMinSum1(int[] arr, int k) {
        int sum = 0;
        int len = arr.length;

        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (j < len) {
            sum = sum + arr[j];

            if (j-i+1 == k) {
                max = Math.max(sum, max);
                min = Math.min(sum, min);
                sum = sum - arr[i];
                i++;
            }
            j++;
        }

        return new int[]{max, min};
    }
}