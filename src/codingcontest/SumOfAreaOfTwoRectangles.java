package codingcontest;

/**
 * 
 * @author VinodAkkepalli
 *
 *	For problem statement Look for file SumOfAreaOfTwoRectangles.png in the same folder
 */

public class SumOfAreaOfTwoRectangles {

	public static void main(String[] args) {

		Solution ob = new Solution();
		//System.out.println(ob.solution(-4, 1, 2, 6, 0, -1, 4, 3));
		System.out.println(ob.solution(0, -1, 4, 3,-4, 1, 2, 6));
	}

}

class Solution {
    public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
    	
    	int intersectionArea = 0;
    	int left = Math.max(K, P);
        int right = Math.min(M, R);
        int bottom = Math.max(L, Q);
        int top = Math.min(N, S);

        if (left < right && bottom < top) {
        	intersectionArea = areaRectangle(left,  bottom, right, top);
        }
        
        return areaRectangle(K,L,M,N) + areaRectangle(P, Q, R, S) - intersectionArea;
    }
    
    public int areaRectangle(int a, int b, int c, int d){
    	
    	return (c-a)*(d-b);
    }

}