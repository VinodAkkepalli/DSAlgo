package codingcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author VinodAkkepalli
 * This is a programming contest problem
 *
 * Panda has a thing for palindromes. Hence he was a given a problem by his master. The master will give Panda an array of strings S having N strings. Now Panda has to select the Palin Pairs from the given strings .

	A Palin Pair is defined as :
	
	(i,j) is a Palin Pair if Si = reverse(Sj) and i < j
	
	Panda wants to know how many such Palin Pairs are there in S. 
	Please help him in calculating this.
	
	Input:
	
	The first line contains N, the number of strings present in S.
	Then N strings follow.
	
	Output:
	
	Output the query of Panda in single line.
	
	Constraints:
	
	1 <= N <= 100000
	1 <= |Si| <= 10 (length of string)
	
	The string consists of Upper and Lower case alphabets only.
	
	Sample Input(Plaintext Link)
	3
	bba
	abb
	abb
	
	Sample Output(Plaintext Link)
	 2
 
 *	Solution Approach:
 *	store the (reverse, number of times occurred) of strings in a HashMap and in one pass find the answer
 *
 */

public class PalindromeStringPairs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> hashMap =  new HashMap<String, Integer>();
        String str, revStr;
        long palinCount = 0;
        int count = 0;
        Integer revCount = 0;
        
        String line = br.readLine();
        int N = Integer.parseInt(line);
        str = br.readLine();
        hashMap.put((new StringBuilder(str).reverse().toString()),1);
        
        for(int i = 0; i < N-1; i++){
        	
        	str = br.readLine();
        	revStr = new StringBuilder(str).reverse().toString();
        	
        	if(hashMap.containsKey(str)){
        		
        		count = hashMap.get(str);
        		revCount = hashMap.get(revStr);
        		palinCount = palinCount + count;
        		
        		if(revCount == null){
        			hashMap.put(revStr, 1);
        		}else{
        			hashMap.put(revStr, revCount+1);
        		}
        		
        	}else{
        		hashMap.put(revStr, 1);
        	}
        }
        
        System.out.println(palinCount);
	}
}