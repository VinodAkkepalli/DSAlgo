package codingcontest;

/**
 * Monk has magical powers, by which he can compare any part of the strings and figure out if they're equal. 
 * His magical powers are faster than a super computer even. So, to prove his worth, he's given a string and 
 * he has to answer multiple queries based on the string.

Every query will have four integers - L1, R1, L2, R2. The first two integers denoting String [ L1, R1 ] (including both L1 and R1) 
denoting the first substring, the next two integers denoting the second substring String [ L2, R2 ] (including both L2 and R2).

For every query, you've to answer in Yes or No whether the two substrings are equal or not. Easy enough?

Input:
The first line contains a string, S.
Then, an integer Q denoting the number of queries in the next line.
Then, for every query, there will be 4 integers L1 R1 L2 R2, denoting the substring S[L1 R1] and S[L2 R2].

Output:
For each query output "Yes" if the two substrings are same , else output "No".

Sample Input
monkandhismonkiness
4
1 1 3 3
1 4 11 14
3 3 6 6
4 5 14 17

Sample Output
 No
Yes
Yes
No

Explanation
For Query 1 , it denotes the substrings "m" and "n" which do not match
For Query 2 , it denotes the substrings "monk" and "monk" which do match
For Query 3 , it denotes the substrings "n" and "n" which do match
For Query 4 , it denotes the substrings "ka" and "ki" which do not match


 * 
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

class MonkAndMatchMaking {
    public static void main(String args[] ) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String supString = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[] subInd = new int[4];
        for (int i = 0; i < N; i++) {
            String[] subString = br.readLine().split(" ");
            
            for(int j=0;j<4;j++){
            	subInd[j] = Integer.parseInt(subString[j]);
            }
    	if((supString.substring(subInd[0]-1, subInd[1])).equals(supString.substring(subInd[2]-1, subInd[3]))){
			System.out.println("Yes");
        }else{
    	  	System.out.println("No");
    	}
            
        }
    }
}