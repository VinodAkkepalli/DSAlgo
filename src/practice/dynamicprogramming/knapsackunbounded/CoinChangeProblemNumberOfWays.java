package practice.dynamicprogramming.knapsackunbounded;

import java.util.Arrays;

/**
 * 
 * @author Vinod Akkepalli
 *
 *	Problem Description: Given a set/array of coin "denominationsArray", find the
 *	number of ways coins can be arranged to make the sum "requiredSum"
 *	constraint: Unlimited supply of given denominations available
 *
 *	https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 */

public class CoinChangeProblemNumberOfWays {

	public static void main(String[] args) {
		
		int minCount = 9999;
		int requiredSum = 21;
		int[] denominationsArray = {9, 2, 5, 1};
		//Array to store minimum number of coins required for a sum
		//minCountArray[i] stores for sum i 
		int[] minCountArray =  new int[requiredSum+1];
		Arrays.fill(minCountArray, 9999);
		minCountArray[0] = 0;   // base case
		
		minCount = findNumberOfWaysCoinChange(requiredSum, minCount, denominationsArray);
		int minCountDPTD = findNumberOfWaysCoinChangeDPTD(requiredSum, denominationsArray,
				minCountArray);
		int minCountDPBU = findNumberOfWaysCoinChangeDPBU(requiredSum, denominationsArray);
		
		System.out.println("Minimum number of coins required is: " + minCount);
		System.out.println("DP Top-Down solution:  " + Arrays.toString(minCountArray));
		System.out.println("Minimum number of coins required is: " + minCountDPTD);
		System.out.println("Minimum number of coins required is: " + minCountDPBU);
	}

	// This is a recursive solution with exponential time complexity
	private static int findNumberOfWaysCoinChange(int sumReq, int minCount, int[] denominationsArray) {
		int arraySize = denominationsArray.length;
		
		if(sumReq == 0) {
			return 1;
		}
		
		for(int i = 0; i < arraySize; i++) {
			if(denominationsArray[i] <= sumReq) {
				minCount = Math.min( 
						 findNumberOfWaysCoinChange(sumReq - denominationsArray[i], minCount + 1, denominationsArray) + 1
						 , minCount );	
			}
		}
		return minCount;
	}
	
	// This is Dynamic Programming approach using memoization; Top-Down
	private static int findNumberOfWaysCoinChangeDPTD(int sumReq, int[] denominationsArray, int[] minCountArray) {
		int arraySize = denominationsArray.length;
		
		if(minCountArray[sumReq] != 9999) {
			return minCountArray[sumReq];
		}
		
		for(int i = 0; i < arraySize; i++) {
			if(denominationsArray[i] <= sumReq) {
				minCountArray[sumReq] = Math.min( 
						 findNumberOfWaysCoinChangeDPTD(sumReq - denominationsArray[i], denominationsArray, minCountArray) + 1
						 , minCountArray[sumReq] );	
			}
		}
		
		//System.out.println("DP Top-Down solution:  " + Arrays.toString(minCountArray));
		return minCountArray[sumReq];
	}
	
	// This is Dynamic Programming approach using memoization; Bottom-Up
	private static int findNumberOfWaysCoinChangeDPBU(int sumReq, int[] denominationsArray) {

		int[] minCountArray =  new int[sumReq+1];
		Arrays.fill(minCountArray, 9999);
		minCountArray[0] = 0;
		
		//find out all the minimum counts for value i
		for(int i = 1; i <= sumReq; i++) {
			
			//try out all the coins smaller than i
			for(int j = 0; j < denominationsArray.length; j++)
				if(denominationsArray[j] <= i) {
					int temp = minCountArray[i - denominationsArray[j]];
			
					//Check and update min count for value i
					if(temp != 9999 && (temp + 1) < minCountArray[i]){
						minCountArray[i] = temp + 1;
					}	
				}
		}
		
		System.out.println("DP Bottom-Up solution:  " + Arrays.toString(minCountArray));
		return minCountArray[sumReq];
	}
}