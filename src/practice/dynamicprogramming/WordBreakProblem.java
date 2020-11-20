package practice.dynamicprogramming;

import java.util.HashSet;

/**
 * 
 * @author Vinod Akkepalli
 *
 *
 *         Problem Description: A recursive program to test whether a given
 *         string can be segmented into space separated words in dictionary
 *         https://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
 *         
 *         returns TRUE if a string can be successfully broken into dictionary strings; FALSE otherwise
 */

public class WordBreakProblem {

	public static void main(String[] args) {

		final HashSet<String> dictionary = new HashSet<>();
		dictionary.add("mobile");
		dictionary.add("samsung");
		dictionary.add("sam");
		dictionary.add("sung");
		dictionary.add("man");
		dictionary.add("mango");
		dictionary.add("icecream");
		dictionary.add("and");
		dictionary.add("go");
		dictionary.add("i");
		dictionary.add("like");
		dictionary.add("ice");
		dictionary.add("cream");

		System.out.println(wordBreakRecursive("ilikesamsung", dictionary));
		System.out.println(wordBreakDynamicProgramming("ilikesamsung", dictionary));
		System.out.println(wordBreakRecursive("iiiiiiii", dictionary));
		System.out.println(wordBreakDynamicProgramming("", dictionary));
		System.out.println(wordBreakDynamicProgramming("ilikelikeimangoiii", dictionary));
		System.out.println(wordBreakDynamicProgramming("samsungandmango", dictionary));
		System.out.println(wordBreakDynamicProgramming("samsungandmangok", dictionary));
	}

	// returns true if string can be segmented into space separated words
	// otherwise returns false
	static boolean wordBreakRecursive(String str, HashSet<String> dictionary) {
		int size = str.length();

		// Base case
		if (size == 0)
			return true;

		// Try all prefixes of lengths from 1 to size
		for (int i = 1; i <= size; i++) {
			// The parameter for dictionary.contains is str.substring(0, i) 
			// which is prefix (of input string) of length 'i'. 
			// We first check whether current prefix is in dictionary. 
			// Then we recursively check for remaining string
			// str.substring(i, size) which is suffix of length size-i
			
			
			if (dictionary.contains(str.substring(0, i)) && wordBreakRecursive(str.substring(i, size), dictionary)) {
				//System.out.println("Comparing: " + str.substring(0, i) + " & " + str.substring(i, size));
				return true;
			}
				
		}

		// If we have tried all prefixes and none of them worked
		return false;
	}
	
	// non-recursive DP solution
	// uses BottomUp approach
	public static boolean wordBreakDynamicProgramming(String s, HashSet<String> dict) {
		
        if( s == null || dict == null )
        	return false;
        
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        
        for(int i=1; i<s.length()+1; i++){
            
            for(int j=0; j<i; j++){
            	//System.out.println("Checking for substring: " + s.substring(j,i));
            	if(dp[j] && dict.contains(s.substring(j,i))) {                	
                	dp[i]=true;
                    continue;
                }
            }
        }
        return dp[s.length()];
    }
	
}
