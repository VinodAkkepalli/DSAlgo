package matrix;

import java.util.HashSet;

/**
 * <b>Description</b> :
 * Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix (mat[][]) the task to check if the configuration has a solution or not.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents empty block.
 *
 * Output:
 * For each test case in a new line print 1 if the sudoku configuration is valid else print 0.
 *
 * Constraints:
 * 1<=T<=10
 * 0<=mat[]<=9
 *
 * Example:
 * Input:
 * 2
 * 3 0 6 5 0 8 4 0 0 5 2 0 0 0 0 0 0 0 0 8 7 0 0 0 0 3 1 0 0 3 0 1 0 0 8 0 9 0 0 8 6 3 0 0 5 0 5 0 0 9 0 6 0 0 1 3 0 0 0 0 2 5 0 0 0 0 0 0 0 0 7 4 0 0 5 2 0 6 3 0 0
 * 3 6 7 5 3 5 6 2 9 1 2 7 0 9 3 6 0 6 2 6 1 8 7 9 2 0 2 3 7 5 9 2 2 8 9 7 3 6 1 2 9 3 1 9 4 7 8 4 5 0 3 6 1 0 6 3 2 0 6 1 5 5 4 7 6 5 6 9 3 7 4 5 2 5 4 7 4 4 3 0 7
 *
 * Output:
 * 1
 * 0
 *
 * Ref:
 * https://www.youtube.com/watch?v=Pl7mMcBm2b8
 *
 * @author Vinod Akkepalli
 */
public class IsSudokuValid {
    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        if(isValid(board)) {
            System.out.println("Board is valid");
        } else {
            System.out.println("Board is NOT valid");
        }
    }

    private static boolean isValid(char[][] board) {
        HashSet<String> rowSet = new HashSet<>();
        HashSet<String> columnSet = new HashSet<>();
        HashSet<String> blockSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String currentVal = String.valueOf(board[i][j]);
                if(!currentVal.equals(".")) {
                    if (!rowSet.add(currentVal + i) || !columnSet.add(currentVal + j)
                            || !blockSet.add(currentVal + i / 3 + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
