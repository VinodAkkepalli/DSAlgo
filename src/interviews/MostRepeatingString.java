package interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author VinodAkkepalli
 *
 *	Problem Statement:
 *	Output the most repeating string among the given input strings
 *	
 *	Input:
 *	6
	Barcelona
	Edinburgh
	Barcelona
	Miami
	Miami
	Barcelona
	
	Output:
	Barcelona
 *
 *	Procedure: Store the strings & their count in a hashmap
 *	TC: O(n)
 */


public class MostRepeatingString {

	static void OutputMostRepeatingString(int count, Scanner in) {
        
		Map<String, Integer> hm = new HashMap<String, Integer>();
        
		String str;
		int max = 0;
		Integer temp = null;
		String maxStr = "";
		
		str = in.nextLine();
		hm.put(str, 1);
		max = 1;
		maxStr = str;
		
		for(int i = 0 ; i < count-1 ; i++){
			str = in.nextLine();

			temp = hm.get(str);
			if(temp == null){
				hm.put(str,1);
			}else{
				hm.put(str, temp+1);
				if(temp >= max){ 
					max = temp+1;
					maxStr = str;
				}
			}
		}
		System.out.println("Most repeating string is: " + maxStr);
		System.out.println("Number of repeatations: " + max);
    }

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int _count = Integer.parseInt(in.nextLine());
		
		OutputMostRepeatingString(_count, in);
	}
}
