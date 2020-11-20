package practice.arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * @author VinodAkkepalli
 *
 *	Problem statement:
 *	Remove duplicate elements in a given array of int
 *	
 *	Note: Observe the JDK 8 streams used to convert an Set<Integer> to int[] 
 *
 */

public class RemoveDuplicatesInArray {

	public static void main(String[] args) {
		
		int[] arr = {1, 2 , 4, 1, 3, 3, 2};
		arr = RemoveDuplicates(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] RemoveDuplicates(int[] arr) {

		Set<Integer> iSet =  new LinkedHashSet<>();
		for(int i : arr){
			iSet.add(i);
		}

		int[] ret = iSet.stream().mapToInt(i->i).toArray();
		return ret;
	}
}
