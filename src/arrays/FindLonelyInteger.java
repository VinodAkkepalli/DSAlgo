package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Vinod Akkepalli
 *
 * Problem Description: Given an array of integers, and all the integers except one occur twice.
 * That one is unique in the array. Find and print the unique element.
 *
 */
public class FindLonelyInteger {

    //O(nlogn)
	static int lonelyInteger_SortArray(int[] a) {
		int a_size = a.length;
		Arrays.sort(a);
		int i=0;
		while(i+1 < a_size && a[i] == a[i+1]) {
			i+=2;
		}
		return a[i];

    }
	
	static void main() {
		int[] arr = {1,2,3,4,5,5,3,2,1};
		//int[] arr = {1};
		//int[] arr = {1,99,1};

        System.out.println(lonelyInteger_SortArray(arr));
        System.out.println(lonelyInteger_Set(arr));
        System.out.println(lonelyInteger_XOR(arr));
    }

    //O(n) time, O(1) Space complexity
    private static int lonelyInteger_XOR(int[] arr) {
        int ans = 0;
        for (int i : arr) {
            ans ^= i;  // bitwise XOR operation
        }
        return ans;
    }

    //O(n) time, O(n/2) space complexity
    private static int lonelyInteger_Set(int[] arr) {
        Set<Integer> intSet = new HashSet<>();
        for (int i : arr) {
            boolean b = intSet.contains(i) ? intSet.remove(i) : intSet.add(i);
        }
        return intSet.iterator().next();
    }
}
