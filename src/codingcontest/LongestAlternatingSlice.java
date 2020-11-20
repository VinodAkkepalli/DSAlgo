package codingcontest;

/**
 * 
 * @author VinodAkkepalli
 *
 *	Problem statement:
 *	Given an array of integers
 *	Find the length of a sub array with alternating +ve and -ve numbers
 *	you can consider zero as either positive or negative
 */

public class LongestAlternatingSlice {

	public static void main(String[] args) {
		
		int[] N = {5, 4, -3, 2, 0, 1, -1, -1, -2, 2, -3, 4, -5};
		
		System.out.println(solution(N));
	}
	
	public static int solution(int[] A) {

		int max = 1, start = 0, end = 0;
		int arrLen = A.length;
		
		for(int i = 0; i < arrLen-1 ; ++i){
			start = i;
			end = start;
			while( end+1 < arrLen ){
				if( A[end] * A[end+1] < 0 ){
					end++;
				}else if((end == 0) && (A[end] * A[end+1]) == 0){
					end++;
				}else if((A[end] == 0) && (A[end-1] * A[end+1] >= 0)){
					end++;
				}else if(A[end+1] == 0){
					end++;
				}else if((end+1 == arrLen-1) && (A[end] * A[end+1] == 0)){
					end++;
				}else{
					break;
				}
			}
			if(max < end-start+1){
				max = end-start+1;
			}	
		}	
		return max;
    }
}
