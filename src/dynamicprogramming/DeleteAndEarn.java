package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

    static Map<Integer, Integer> earningMap = new HashMap<>();
    static int[] earningsTD;

    public static void main(String[] args) {
        
        // int[] nums = {3, 4, 2};
        int[] nums = {2, 2, 3, 3, 3, 4, 2};
        // int[] nums = {2, 4, 6};
                
        for (int i : nums) {
            earningMap.put(i, earningMap.getOrDefault(i, 0)+i);
        }

        nums = Arrays.stream(nums).distinct().toArray();
        Arrays.sort(nums);
        System.out.println("Count of distinct numbers: " + nums.length);

        earningsTD = new int[nums.length];
        Arrays.fill(earningsTD, -1);

        System.out.println(deleteAndEarnRec(nums, nums.length-1));
        System.out.println(deleteAndEarnTD(nums, nums.length-1));
        System.out.println(deleteAndEarnBU(nums));

    }

    //Using Recursion
    public static int deleteAndEarnRec(int[] nums, int index) {

        // Base case: Only one element left to consider
        if(index == 0) {
            return earningMap.getOrDefault(nums[index], 0);
        }

        if(index < 0) {
            return 0;
        }
        
        // Check if the previous element in our sorted array is a direct neighbor
        if(nums[index-1] == nums[index]-1){
            // Conflict exists: We must choose between taking current (and skipping index-1) OR skipping current
            return Math.max((earningMap.get(nums[index]) + deleteAndEarnRec(nums, index-2)), 
                            deleteAndEarnRec(nums, index-1));
        } else {
            // No conflict: We can safely take the current number AND the previous distinct number
            return earningMap.get(nums[index]) + deleteAndEarnRec(nums, index-1);
        }        
    }

    //Top-down solution
    public static int deleteAndEarnTD(int[] nums, int index) {

        if(index == 0) {
            earningsTD[index] = earningMap.getOrDefault(nums[index], 0);
            return earningsTD[index];
        }

        if(index < 0) {
            return 0;
        }

        if(earningsTD[index] != -1) {
            return earningsTD[index];
        }
        

        if(nums[index-1] == nums[index]-1){
            earningsTD[index] = Math.max((earningMap.get(nums[index]) + deleteAndEarnTD(nums, index-2)), deleteAndEarnTD(nums, index-1));
        } else {
            earningsTD[index] = earningMap.get(nums[index]) + deleteAndEarnTD(nums, index-1);
        }

        
        return earningsTD[index];
    }

    //Bottom-Up solution
    public static int deleteAndEarnBU(int[] nums) {
    if(nums == null || nums.length == 0) return 0;

    int[] earningsBU = new int[nums.length];
    earningsBU[0] = earningMap.get(nums[0]);
    
    for (int i = 1; i < nums.length; i++) {
        
        int currentEarn = earningMap.get(nums[i]);
        
        // Safely get the value from two steps back. If we are at index 1, it's just 0.
        int earnTwoStepsBack = (i >= 2) ? earningsBU[i-2] : 0;
        
        if (nums[i-1] == nums[i]-1) {
            earningsBU[i] = Math.max(currentEarn + earnTwoStepsBack, earningsBU[i-1]);
        } else {
            earningsBU[i] = currentEarn + earningsBU[i-1];
        }
    }
   
    return earningsBU[nums.length-1];
}
}
