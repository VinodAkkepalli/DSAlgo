package interviews;

/**
 * <b>Description</b> :
 * Given a matrix of n*n size, the task is to print its elements in a diagonal pattern.
 * https://www.geeksforgeeks.org/print-matrix-diagonal-pattern/
 *
 * @author Vinod Akkepalli
 */
public class MatrixDiagonalTraversal {

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }};

        // Function Call
        print(arr,4);
    }

    private static void print(int[][] arr, int n) {
        int i;
        int j;

        //upper part of matrix
        for (int k = 0; k < n; k++) {
            // up loop
            if (k % 2 == 0) {
                for (i = k; i > -1; i--) {
                    j = k - i;
                    System.out.print(arr[i][j] + " ");
                }
            }

            //down loop
            if (k % 2 == 1) {
                for (j = k; j > -1; j--) {
                    i = k - j;
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }

        //lower part of matrix
        for (int k = n; k < 2 * n - 1; k++) {
            // up loop
            if (k % 2 == 0) {
                for (i = n - 1; i > k - n; i--) {
                    j = k - i;
                    System.out.print(arr[i][j] + " ");
                }
            }

            //down loop
            if (k % 2 == 1) {
                for (j = n - 1; j > k - n; j--) {
                    i = k - j;
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
