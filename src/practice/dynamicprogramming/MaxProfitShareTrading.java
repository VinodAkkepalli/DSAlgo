package practice.dynamicprogramming;

/**
 * <b>Description</b> : Given the stock price of n days, the trader is allowed
 * to make at most k transactions, where a new transaction can only start after
 * the previous transaction is complete, find out the maximum profit that a share
 * trader could have made.
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
 *
 * @author Vinod Akkepalli
 */
public class MaxProfitShareTrading {

    public static void main(String[] args) {
        int[] arr = {5, 11, 3, 50,  60, 90};
        int k = 2;
        int len = arr.length;
        int answer = findMaxProfit(arr, k, 0, len-1);
    }


    public static int findMaxProfit(int[] arr, int k, int left, int right) {
        //base if length = 1 => 0
        //k=0 => 0
        if(k == 0 || right-left < 2) {
            return 0;
        }

        int ans = 0;
        int temp;
        for (int i = 0; i < right-left; i++) {
            for (int j = 0; j < k; j++) {
                temp = findMaxProfit(arr, j, left, i) + findMaxProfit(arr, k-j, i, right);
                if (temp > ans) {
                    ans = temp;
                }
            }
        }

        return ans;
    }

}
