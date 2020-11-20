package practice.arrays;
import java.util.Arrays;


/**
 * @author Vinod Akkepalli
 *
 * Problem Description: Given an array of integers, and all of the integers except one occur twice.
 * That one is unique in the array. Find and print the unique element.
 *
 */
public class FindLonelyInteger {
	
	static int lonelyInteger(int[] a) {
		int a_size = a.length;
		Arrays.sort(a);
		int i=0;
		while(i+1 < a_size && a[i] == a[i+1]) {
			i+=2;
		}
		return a[i];

    }
	
	public static void main(String[] args) {
		int[] _a = {1,2,3,4,5,5,3,2,1};
		//int[] _a = {1};
		//int[] _a = {1,99,1};

        System.out.println(lonelyInteger(_a));
    }
}
