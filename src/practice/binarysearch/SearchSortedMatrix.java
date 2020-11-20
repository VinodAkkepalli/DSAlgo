package practice.binarysearch;

/**
 * <b>Description</b> :
 * Given an n x n matrix and a number x, find the position of x in the matrix
 * if it is present in it. Otherwise, print “Not Found”. In the given matrix,
 * every row and column is sorted in increasing order. The designed algorithm
 * should have linear time complexity.
 *
 * https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 *
 * @author Vinod Akkepalli
 */
public class SearchSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        findLocation(mat, 4, 29);
    }

    public static void findLocation(int[][] mat, int n, int ele) {

        // Start at top right corner element
        int i = 0, j = n - 1;

        while (i < n && j >= 0) {

            if (mat[i][j] == ele) {
                System.out.print(ele + " found at " + i + ", " + j);
                return;
            }
            if (mat[i][j] > ele){
                j--;
            } else {
                i++;
            }
        }

        System.out.print(ele + " not found");
    }
}
