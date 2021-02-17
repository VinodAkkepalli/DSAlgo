package arrays;

/**
 * <b>Description</b> : Given a sorted array and a number x, find the pair in array
 * whose sum is closest to x
 *
 *  http://geeksquiz.com/given-sorted-array-number-x-find-pair-array-whose-sum-closest-x/
 * @author Vinod Akkepalli
 */
public class PairWithClosestSum {

    public static void main(String[] args) {
//        int[] arr = {10, 22, 28, 29, 30, 40};
//        int x = 54; // ans 22, 30
        int[] arr = {1, 3, 4, 7, 10};
        int x = 15; // ans 4, 10
        findPairWithClosestSum(arr, x);
    }

    static void findPairWithClosestSum(int[] arr, int x)
    {
        int left = 0, right = 0;
        int l = 0, r = arr.length-1, diff = Integer.MAX_VALUE;
        int sum;
        int absDiff;

        while (l < r) {
            sum = arr[l] + arr[r];
            absDiff = Math.abs(x - sum);
            if (absDiff < diff) {
                left = l;
                right = r;
                diff = absDiff;
            }

            if (sum <= x) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println("Closest pair is: " + arr[left] + ", "+ arr[right]);
    }

}