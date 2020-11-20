package codingcontest;

import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author VinodAkkepalli
 *
 *	Problem Statement:
 *	Have a look at below files in the same folder
 *	MaxDistanceAdjacentValues1.PNG
 *	MaxDistanceAdjacentValues2.PNG
 *
 *	The below code scored 77% on correctness and 50% on performance.
 *	This needs to be improved with the same approach or an improved approach should be followed. 
 */


public class MaxDistanceAdjacentValues{

	public static void main(String[] args) {

		//int[] a = {3,3,3,3};
		//int[] a = {2,3,3,4,3,3,3,3};
		//int[] a = {0, 3, 3, 7, 5, 3, 11, 1};
		int[] a = {1, 4, 7, 3, 3, 5};
		System.out.println(solution(a));		
	}

	
	public static int solution(int[] A) {
        
		//create a set with all distinct integers of the array
		//TreeSet for ordered accessing
		Set<Integer> sortedSet = new TreeSet<Integer>();
		for(int i : A){
			sortedSet.add(i);
		}
		
		//Two arrays to store max & min index of each 
		//distinct integer of the given array A
		int size =  sortedSet.size();
		int[] maxIndex =  new int[size];
		int[] minIndex =  new int[size];
		
		//store min & max index of each distinct integer
		int i = 0;
		for(Integer n : sortedSet){
			minIndex[i] = findMinIndex(A, n);
			maxIndex[i] = findMaxIndex(A, n);
			i++;
		}

		//to return -1 when no adjacent indices exist
		int max = -1;
		int length = minIndex.length;
		
		//calculate max distance between adjacent integers
		for(int j=1; j<length ;j++ ){
			max = Math.max(max, 
					Math.max( Math.abs(maxIndex[j]-minIndex[j-1]), Math.abs(minIndex[j]-maxIndex[j-1])) );
		}
		
		return max;
    }


	private static int findMaxIndex(int[] a, int n) {
		int length = a.length;
		
		for(int i = length-1 ; i >= 0; i--){
			if(a[i] == n){
				return i;
			}
		}
		return 0;
	}


	private static int findMinIndex(int[] a, int n) {
		int length = a.length;
		
		for(int i = 0 ; i < length; i++){
			if(a[i] == n){
				return i;
			}
		}
		return 0;
	}
}