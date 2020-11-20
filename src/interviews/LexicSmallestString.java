package interviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Vinod Akkepalli
 *
 * Problem Statement
 * Given a word w, rearrange the letters of w to construct another word s in such a way that s is lexicographically greater than w. 
 * In case of multiple possible answers, find the lexicographically smallest one.
 *
 * The first line of input contains t, the number of test cases. Each of the next t lines contains w
 * 
 * For each testcase, output a string lexicographically bigger than w in a separate line. In case of multiple possible answers, 
 * print the lexicographically smallest one, and if no answer exists, print no answer.
 *
 *	Sample Input

5
ab
bb
hefg
dhck
dkhc
Sample Output

ba
no answer
hegf
dhkc
hcdk
 *
 *
 * Approach:  http://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 * 
 * 1. find the largest k, that str[k] < str[k+1]
 * 2. find last index toSwap, that str[k] < str[toSwap]
 * 3. swap elements with indexes k and toSwap
 * 4. reverse sequence from k+1 to n (inclusive) 
 *
 */


public class LexicSmallestString {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String str;
        
        for(int i=0; i < N; i++){
        	str = br.readLine();
        	char[] ansStr;
        	
        	//ansStr is null if no such string exists else contains answer string 
        	if((ansStr = getLexicSmallestString(str.toCharArray())) == null){
        		System.out.println("no answer");
        	}else{
        		System.out.println(ansStr);
        	}
        			
        }
	}

	private static char[] getLexicSmallestString(char[] arrStr) {
		
		int k, toSwap;
		int n = arrStr.length;
		if(n == 1) return null;
		
		//1. find the largest k, that arrStr[k] < arrStr[k+1]
		k = n-2;
		while(k >= 0 && (arrStr[k] >= arrStr[k+1])){
			k--;
		}
		
		if(k == -1) return null;
		
		//2. find last index toSwap, that arrStr[k] < arrStr[toSwap]
		toSwap = n-1;
		while(arrStr[k] >= arrStr[toSwap]){
			toSwap--;
		}
		
		//3. swap elements with indexes k and toSwap
		char c = arrStr[k];
		arrStr[k] = arrStr[toSwap];
		arrStr[toSwap] = c;
		
		//4. reverse sequence from k+1 to n (inclusive) 
		int first = k+1;
		int last = n-1;
		while( first < last){
			c = arrStr[first];
			arrStr[first] = arrStr[last];
			arrStr[last] = c;
			first++;last--;
		}
		
		return arrStr;
	}

}
