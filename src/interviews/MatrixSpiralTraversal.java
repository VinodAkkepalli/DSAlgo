package interviews;

/**
 * <b>Description</b> :
 * Given a 2D array, print it in spiral form.
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * https://www.youtube.com/watch?v=qEZoUVOqOs8
 *
 * @author Vinod Akkepalli
 */
public class MatrixSpiralTraversal {

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 },
                { 21, 22, 23, 24 }};

        // Function Call
        print(arr, 0, 0, 5, 3);
    }

    //MxN matrix
    private static void print(int[][] arr, int i, int j, int m, int n) {
        //top row
        for (int k = j; k <= n; k++) {
            System.out.println(arr[i][k] + " ");
        }
        i++;

        //right column
        for (int k = i; k <= m; k++) {
            System.out.println(arr[k][n] + " ");
        }
        n--;

        //bottom row
        for (int k = n; k >= j ; k--) {
            System.out.println(arr[m][k] + " ");
        }
        m--;

        //left column
        for (int k = m; k >= i ; k--) {
            System.out.println(arr[k][j] + " ");
        }
        j++;

        if(i < m && j < n) {
            print(arr, i, j, m, n);
        }
    }
}
