package dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * @author Vinod Akkepalli
 *	Problem Description: Given an array of random numbers. Find longest increasing subsequence in the array
 *	https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 *	https://www.geeksforgeeks.org/?p=12832
 *
 *	Try to implement below algorithm which gives O(n log n) time complexity
 *	https://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
 */


public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		
		int sequence[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 70 };
        int n = sequence.length;
        System.out.println("Length of longest Increasing Subsequence is " + longestIncreasingSubsequenceDP( sequence, n ));
	}

	//Dynamic Programming approach with O(n^2) time complexity
	private static int longestIncreasingSubsequenceDP(int[] sequence, int n) {

		//Array to store longest sub sequence upto ith character at ith location
		int[] longestSubSequence = new int[n];
		Arrays.fill(longestSubSequence, 1);
		
		for( int i = 1; i < n; i++) {
			for(int j=0; j<i; j++) {
				if(sequence[j] < sequence[i] && longestSubSequence[i] <= longestSubSequence[j]) {
					longestSubSequence[i] = longestSubSequence[j] + 1;
				}
			}
		}
//		System.out.println("longestSubSequence: " + Arrays.toString(longestSubSequence));
		return longestSubSequence[n-1];
	}
}
