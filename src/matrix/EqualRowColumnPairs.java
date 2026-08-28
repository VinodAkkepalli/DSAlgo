package matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * LeetCode#2352. Equal Row and Column Pairs
 * https://leetcode.com/problems/equal-row-and-column-pairs
 */

public class EqualRowColumnPairs {

    public static void main(String[] args) {

        // int[][] grid = {{3,2,1},{1,7,6},{2,7,7}}; //ans = 1
        // int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}; // ans = 3
        int[][] grid = {{2,30,400},{40,7,6},{300,7,7}}; //ans = 0
        
        System.out.println(equalPairs(grid));
        
    }

    public static int equalPairs(int[][] grid) {

        // Count how many times each row pattern appears.
        // Using a string representation makes row/column comparison easy and fast.
        int ans = 0;

        Map<String, Integer> rowMap = new HashMap<>();
        String tempString;
        int rowLen = grid[0].length;

        for(int[] row: grid) {
            tempString = Arrays.toString(row);
            rowMap.put(tempString, rowMap.getOrDefault(tempString, 0)+1);
        }

        // For each column, build its array and check how many rows match this exact pattern.
        // If a column pattern matches a row pattern, it contributes to the answer.
        for(int i=0; i <rowLen; i++ ) {
            tempString = "";
            int[] colArr = new int[rowLen];

            for (int j = 0; j < rowLen; j++) {
                colArr[j] = grid[j][i];                
            }
            tempString = Arrays.toString(colArr);                

            ans += rowMap.getOrDefault(tempString,0);
        }

        return ans;
    }
}
