package codingcontest;

import java.util.*;

public class PowerOfTwo {

	public static void main(String[] args) {
		
		//int[] a = {35, 34, 33, 32, 31, 30, 29};
		//int[] a = {33, 34};
		//int[] a = {24, 23, 22};
		int[] a = {5, 4, 7};
		//int[] a = {24, 22, 23};
		System.out.println(solution(a));
	}

	public static long solution(int[] A) {
		int N = A.length;
		int min = A[0], max = A[0];
		long result = 0;

		// finding min element of the given array
		/*for (int i = 1; i < N; i++) {
			if (min > A[i]) min = A[i];
			if (max < A[i]) max = A[i];
		}*/
		
		// if min element of the input array is 24, the absolute value exceeds
		// 10,000,000
		//if (min > 23) return -1;
		//if (max > 35) return -1;
		
		for (int i = 0; i < N; i++) {
			result += Math.pow(-2, A[i]);
		}
		
		if (Math.abs(result) > 10000000)
			return -1;
		return result;
	}
}
