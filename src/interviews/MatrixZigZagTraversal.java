package interviews;

/**
 * <b>Description</b> :
 * https://www.geeksforgeeks.org/print-given-matrix-zigzag-form/
 *
 * @author Vinod Akkepalli
 */
public class MatrixZigZagTraversal {

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 },
                { 21, 22, 23, 24 }};

        // Function Call
        print(arr,6, 4);
    }

    private static void print(int[][] arr, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(arr[i][j]);
            }
            i++;
            for (int j = n-1; j >=0 ; j--) {
                System.out.println(arr[i][j]);
            }
        }
        if(m % 2 == 1) {
            for (int i = 0; i < n; i++) {
                System.out.println(arr[m][i]);
            }
        }
    }


}
