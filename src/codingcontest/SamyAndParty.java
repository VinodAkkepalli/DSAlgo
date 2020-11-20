package codingcontest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author VinodAkkepalli
 *	This is a programming contest problem; and the code is incomplete
 *
 *	Samu's Birthday is near so she had started planning a party for all of her friends. Being a kind and caring girl she calls each of her friend and asks for his/her favorite dish.Now each friend has own liking/disliking for different dishes.

	A friend can only like or dislike a dish it means if we are having three dishes 1,2,3 then if a friend says that he likes Dishes 1 and 2 then its obvious that he dislikes Dish 3. So for each friend we are given a string of 1 and 0 where 1 shows that this person like this particular dish.
	
	Now we are given that Samu has N friends and total of K dishes available to make her menu. Now Samu doesn't want to make any of her friend unhappy , After all its her birthday.
	
	So she got confused on what dishes to count in menu and calls you for help. You need to find count of minimum dishes to order so that all of her N friends are happy which means everyone has at least one dish to eat in party.
	
	Note : Its for sure that everyone has at least liking for one dish.
	
	Input : Input will contain T test cases and each of the test case has following description :
	
	First line of test case has N denoting the total number of friends and K denoting the total number of dishes available.Both separated by a space (Dishes are numbered from 1 to K) .
	
	Then it is followed by N lines each of length K . Each of the N lines contains a string of 0 and 1 where if jth (1<=j<=K) value in ith line (1<=i<=N) is set 1 then it shows that dish number j is liked by that ith Samu's friend.
	
	Output : You need to tell the minimum number of dishes to be taken in menu so that all friends are happy.
	
	Constraints :
	
	1<=T<=10
	
	1<=N<= 500.
	
	1<=K<=10
	
	Each string will only contain 0 or 1 and it is sure that their is at least one 1 in each string depicting like/dislike of Samu's friend
	
	Sample Input(Plaintext Link)
	 1
	2 2
	10 
	01
	Sample Output(Plaintext Link)
	 2
 *
 *
 */


public class SamyAndParty{

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        int[] set = new int[T];
        String[] str = new String[2];
        int[] countArr;
        String[] matrix;
        for (int i = 0; i < T; i++) {
        	str = br.readLine().split("");
        	
        	set[0] = Integer.parseInt(str[0]);
        	set[1] = Integer.parseInt(str[1]);
        	
        	matrix = new String[set[0]];
        	
        	//all rows are entered in the matrix
        	for(int j = 0; j < set[0]; j++ ){
        		matrix[j] = br.readLine();
        	}
        	
        	countArr = new int[set[1]];
        	for(int j = 0; j < set[1]; j++){
        		for(int k = 0; k < set[0]; k++){
        			if(matrix[k].charAt(j) == '1'){
        				
        			}
        		}
        	}
        	
        }
        
        System.out.println("Hello World!");
    }
}
