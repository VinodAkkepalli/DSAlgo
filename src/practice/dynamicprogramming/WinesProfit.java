package practice.dynamicprogramming;

import java.util.Arrays;

/**
 * @author VinodAkkepalli
 *
 * Problem statement:
 * 
 * Imagine you have a collection of N wines placed next to each other on a shelf. 
 * For simplicity, let's number the wines from left to right as they are standing on the shelf with integers from 1 to N, respectively. 
 * The price of the ith wine is pi. (prices of different wines can be different).
 * Because the wines get better every year, supposing today is the year 1, 
 * on year y the price of the ith wine will be y*pi, i.e. y-times the value that current year.
 * You want to sell all the wines you have, but you want to sell exactly one wine per year, starting on this year. 
 * One more constraint - on each year you are allowed to sell only either the leftmost or the rightmost wine on the shelf and 
 * you are not allowed to reorder the wines on the shelf (i.e. they must stay in the same order as they are in the beginning).
 * You want to find out, what is the maximum profit you can get, if you sell the wines in optimal order?
 *
 */

public class WinesProfit {

	
	private static int[] p = {3,2,2,1,2,3,4,5,6,7,8,9,9,3,4,5,6,2,3,4,5,6,7,3,2,4,5,6,7,0,3,5,1,4,20};
	private static int length = p.length;
	private static int mem[][];
	
	public static void main(String[] args) {
		
		//using Dynamic programming approach to find solution
		mem = new int[length][length];
		
		//filling a multi-dimensional array
		for(int[] temp : mem ){
			Arrays.fill(temp, -1);
		}

		profitDP(0, length-1);
		System.out.println("DP Answer is = " + mem[0][length-1]);
		
		//using recursion to find solution
		int ansRec = profitRec(0, length-1);
		System.out.println("Recursive Answer is = " + ansRec);
				
		
	}

	//Recursive method to find answer; significantly slow compared to DP solution
	private static int profitRec(int beg, int end) {
		
		if(beg > end){
			return 0;
		}
		
		int year = length - (end - beg);
		
		return Math.max( profitRec(beg, end-1) + year * p[end],
				profitRec(beg+1, end) + year * p[beg] );
	}
	
	//DP solution method to find answer
	//we are using a global 2d array to memorize the already calculated values
	private static int profitDP(int beg, int end) {
		
		if(beg > end){
			return 0;
		}
		
		int year = length - (end - beg);
		
		if(mem[beg][end] != -1)
			return mem[beg][end]; 
		
		return mem[beg][end] = Math.max( profitDP(beg, end-1) + year * p[end],
				profitDP(beg+1, end) + year * p[beg] );
	}
}
