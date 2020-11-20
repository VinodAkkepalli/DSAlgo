package interviews;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * @author VinodAkkepalli
 *
 *	Problem Description:
 *	Please have a look at the screenshot SizeOfLargestSet.png
 *	
 */

public class SizeOfLargestSet {

	public static void main(String[] args) {
		
		int[] a = { 5, 4, 0, 3, 1, 6, 2 };
		System.out.println(solution(a));
	}

	public static int solution(int[] A) {
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		int len = A.length;
		int maxcount = 0;
		int count = 0;
		int num = 0;
		
		for (int i = 0; i < len; i++) {
			
			num = A[i];
			while( !set.contains(num) ) {
				set.add(num);
				num = A[num];
			}

			count = set.size();
			if ( count > maxcount ) {
				maxcount = count;
			}
			
			set.clear();
		}
		return maxcount;
	}
}
