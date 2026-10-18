package arrays;

import java.util.Arrays;

/**
 * Problem: Two Sum with Original Indices (Sorted Approach)
 * You are given an array of integers nums and a target integer target.
 * Find two numbers such that they add up to target and return their original indices (before sorting).
 *
 * Constraints:
 * Each input has exactly one solution.
 * You may not use the same element twice.
 * You must solve it by first sorting the array and then using the two-pointer technique.
 * Remember: Sorting changes the order, so you must preserve the original indices.
 *
 * Example 1:
 * Code
 * Input: nums = [10, 2, 7, 15], target = 9
 * Output: [1, 2]
 * Explanation: nums[1] + nums[2] = 2 + 7 = 9
 *
 * Example 2:
 * Code
 * Input: nums = [3, 8, 12, 4], target = 7
 * Output: [0, 3]
 * Explanation: nums[0] + nums[3] = 3 + 4 = 7
 *
 * Implement a method int[] twoSumSorted(int[] nums, int target) that returns the original indices of the two numbers.
 */

public class PairWithGivenSumWithoutExtraSpace {

    static void main() {
        int[] nums = {10, 2, 20, 7, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSumSorted(nums, target)));
    }

    static int[] twoSumSorted(int[] nums, int target){

        //map for storing value and its original index
        int[][] map = new int[nums.length][2];

        for(int i=0; i< nums.length; i++) {
            map[i][0] = nums[i];
            map[i][1] = i;
        }

        //sort the map entries on array values
        Arrays.sort(map, (a, b) -> a[0] - b[0]);

        int left = 0;
        int right = nums.length-1;

        int sum = 0;

        while(left < right) {
            sum = map[left][0] + map[right][0];

            if(sum < target) {
                left++;
            } else if (sum > target){
                right--;
            } else {
                return new int[] {map[left][1], map[right][1]};
            }
        }

        return new int[] {};
    }
}
