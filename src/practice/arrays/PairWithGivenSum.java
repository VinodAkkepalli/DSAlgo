package practice.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author VinodAkkepalli
 *
 *	Problem Statement:
 *	Given an array A[] and a number x, check for pair in A[] with sum as x
 *
 *	Solution:
 *	http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 *	
 */


public class PairWithGivenSum {

	public static void main(String[] args) {
		
		int[] arr = {1, 4, 45, 6, 10, -8, 11};
		int sum = 16;
		
		//uses 1) sorting 2) search ; time complexity is O(n logn)
		findPairSorting(arr.clone(),sum);
		
		//uses Hashmap ; time complexity O(n)
		findPairHashMap(arr.clone(),sum);
		
		//System.out.println(Arrays.toString(arr));
	}

	//uses Hashmap ; time complexity O(n)
	private static void findPairHashMap(int[] array, int sum) {
		
		int diff;
		int length = array.length-1;
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int i;
		
		for(i = 0; i < length; i++){
			diff = sum - array[i];
			if(hm.get(array[i]) == null){
				hm.put(diff, 1);
			}else{
				System.out.println(array[i] + " & " + diff);
				break;
			}
		}
		
		if(i >= length){
			System.out.println("Hash Procedure: No such pair exists");
		}
		
	}

	//uses 1) sorting 2) search ; time complexity is O(n logn)
	private static void findPairSorting(int[] array, int sum) {
		
		Arrays.sort(array);
		//System.out.println(Arrays.toString(array));
		
		int left = 0;
		int right = array.length-1;
		int currentSum;
		
		while(left < right){
			currentSum = array[left] + array[right];
			if(currentSum == sum){
				System.out.println(array[left] + " & " + array[right]);
				break;
			}else if(currentSum < sum){
				left++;
			}else{
				right--;
			}
		}
		
		if(left >= right){
			System.out.println("Sorting Procedure: No such pair exists");
		}
	}
	
}
