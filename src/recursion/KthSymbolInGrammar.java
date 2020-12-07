package recursion;

/**
 * <b>Description</b> : Kth Symbol in Grammar
 * On the first row, we write a 0.
 * Now in every subsequent row, we look at the previous row
 * and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 *
 * Given row N and index K, return the K-th indexed symbol in row N.
 * (The values of K are 1-indexed.) (1 indexed).
 *
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 * https://www.youtube.com/watch?v=5P84A0YCo_Y&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=10
 *
 * @author Vinod Akkepalli
 */
public class KthSymbolInGrammar {
    public static void main(String[] args) {

        //0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0;
        int n = 5; int k = 7; //ans = 0
//        int n = 6; int k = 12;  //ans = 1

        boolean ans = solve(n, k);
        System.out.println(ans ? 1 : 0);
    }

    private static boolean solve(int n, int k) {
        //base condition given in problem statement
        if(n == 1 && k == 1) return false;

        int mid = (int) (Math.pow(2, n-1) / 2);

        if(k <= mid) {
            return solve(n-1, k);
        } else {
            return !solve(n-1, k-mid);
        }

    }
}
