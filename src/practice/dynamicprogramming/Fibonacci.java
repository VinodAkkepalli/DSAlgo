package practice.dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * @author VinodAkkepalli
 *
 *	Using Dynamic Programming technique to efficiently find Nth number in fibonacci sequence
 *	In Dynamic programming we trade space for time.
 *	
 *	Method: fibMem(int) uses extra memory for storage and is fast
 *	Demonstrates Memorization technique
 *
 *	Method: int fibRec(int) uses simple recursion
 *	This method takes long time to print answer on console
 */

public class Fibonacci {

	long[] fibArr;
	private static int[] fibArr1;
	
	public static void main(String[] args) {
		
		int n = 45;
		Fibonacci ob = new Fibonacci();
		ob.fibArr = new long[n];
		
		// using Dynamic programming approach
		ob.fibMem(n);
		System.out.println("Fibonacci sequence using DP is = " + Arrays.toString(ob.fibArr));
		System.out.println("Fibonacci value using DP is = " + ob.fibArr[n-1]);
		
		// using Dynamic programming approach with backtracking
		fibArr1 = new int[n];
		Arrays.fill(fibArr1,-1);
		fibArr1[0] = 0;
		fibArr1[1] = 1;
		
		fibMemBack(n-1);
		System.out.println("Fibonacci sequence using DP backtrack is = " + Arrays.toString(fibArr1));
		System.out.println("Fibonacci value using DP backtrack is = " + fibArr1[n-1]);
		
		// using simple recursion; significantly slower
		System.out.println("Fibonacci value using simple recursion is = " + ob.fibRec(n-1));
	}

	// Uses Dynamic programming memorization technique
	private void fibMem(int n) {
	
		fibArr[0] = 0;
		fibArr[1] = 1;
		for (int i = 2; i<n; i++){
			fibArr[i] = fibArr[i-1]+fibArr[i-2];
		}
		 
	}
	
	// Uses Dynamic programming memorization technique with backtracking
	private static int fibMemBack(int n) {
	
		if(fibArr1[n] != -1)
			return fibArr1[n];
		
		return fibArr1[n] = ( fibMemBack(n-1) + fibMemBack(n-2) );
		 
	}
	
	// Uses recursion technique
	private int fibRec(int n){
		if(n==0){
			return 0;	//Base case
		}else if(n==1){
			return 1;	//Base case
		}else{
			return fibRec(n-1) + fibRec(n-2);	//Recursion
		}
	}
	
}
