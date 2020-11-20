package codingcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author VinodAkkepalli
 */


public class SquareRectangle {

	public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        String[] S = new String[N];
        String[] sideStr = new String[4];
        int[] sides = new int[4];
        int k;
        int[] count = new int[3];
        
        for (int i = 0; i < N; i++) {
            S[i] = br.readLine();
        }
        
        for(String str : S){
        	sideStr = str.split(" ");
        	
        	k=0;
            for(String i : sideStr){
            	if(i.charAt(0) == '-'){
            		sides[k] = Integer.parseInt(i.substring(1));
            		sides[k] = -sides[k];
            		k++;
            	}else{
            		sides[k++] = Integer.parseInt(i);
            	}	
            }
        	
            System.out.println(Arrays.toString(sides));
            if((sides[0] == sides[2]) && (sides[1] == sides[3]) && (sides[0] == sides[1])){
            	count[0]++;
            }else if((sides[0] == sides[2]) && (sides[1] == sides[3]) && (sides[0] != sides[1])){
            	count[1]++;
            }else{
            	count[2]++;
            }
        }
        
        for(int i : count){
        	System.out.print(i + " ");
        }
   }

}
