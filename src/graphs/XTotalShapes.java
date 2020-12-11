package graphs;

/**
 * <b>Description</b> :
 * Given N * M string array arr of O's and X's. The task is to find the number of 'X' total shapes.
 * 'X' shape consists of one or more adjacent X's (diagonals not included).
 *
 * Input:
 * The first line of input takes the number of test cases T. Then T test cases follow. Each of the T test cases takes 2 input lines. The first line of each test case have two integers N and M.The second line of N space separated strings follow which indicate the elements in the array.
 *
 * Output:
 * For each testcase, in a new line print the total X shapes.
 *
 * Your Task:
 * Complete Shape function that takes string array arr, n, m as arguments and returns the count of total X shapes.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N, M <= 50
 *
 * Expected Time Complexity : O(N*M)
 * Expected Auxilliary Space : O(N*M)
 *
 * Example:
 * Input:
 * 2
 * 4 7
 * OOOOXXO OXOXOOX XXXXOXO OXXXOOO
 * 10 3
 * XXO OOX OXO OOO XOX XOX OXO XXO XXX OOO
 *
 * Output:
 * 4
 * 6
 *
 * Explanation:
 * Testcase 1: Given input is like:
 * OOOOXXO
 * OXOXOOX
 * XXXXOXO
 * OXXXOOO
 *
 * So, X with same colour are adjacent to each other vertically for horizontally (diagonals not included). So, there are 4 different groups in the given matrix.
 *
 * Testcase 2: Given input is like:
 * XXO
 * OOX
 * OXO
 * OOO
 * XOX
 * XOX
 * OXO
 * XXO
 * XXX
 * OOO
 * So, this matrix has 6 groups with is having adjacent Xs. Total number of groups is 6.
 *
 *
 * Solution: Just check with adjacent vertex having X and unvisited,
 * and follow DFS/BFS for that vertices.
 *
 * https://practice.geeksforgeeks.org/problems/x-total-shapes3617/1/?company[]=Google&problemStatus=unsolved&page=1&query=company[]GoogleproblemStatusunsolvedpage1
 * @author Vinod Akkepalli
 */
public class XTotalShapes {

    public static void main(String[] args) {
        //Program input modified due to easy understanding of logic
        int[][] graph = new int[][]{
                {0, 0, 0, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 0}};

        int m = 4;
        int n = 7;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    count++;
                    exploreDFS(i, j, m, n, graph, visited);
                }
            }
        }

        System.out.println("Number of X shapes= " + count);
    }

    private static void exploreDFS(int i, int j, int m, int n, int[][] graph, boolean[][] visited) {
        visited[i][j] = true;
        if(i-1 >= 0 && graph[i-1][j] == 1 && !visited[i-1][j]) exploreDFS(i-1, j, m, n, graph, visited);
        if(i+1 < m && graph[i+1][j] == 1 && !visited[i+1][j]) exploreDFS(i+1, j, m, n, graph, visited);
        if(j-1 >= 0 && graph[i][j-1] == 1 && !visited[i][j-1]) exploreDFS(i, j-1, m, n, graph, visited);
        if(j+1 < n && graph[i][j+1] == 1 && !visited[i][j+1]) exploreDFS(i, j+1, m, n, graph, visited);
    }
}
