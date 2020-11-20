package codingcontest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EscapeToken {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strArr = line.split(" ");
        int[] intArr = new int[strArr.length];
        int i =0;
        int delta = 0;
        
        for(String str : strArr){
        	intArr[i++] = Integer.parseInt(str);
        }

        System.out.print(intArr[0] + " ");
        
        for(int k = 1; k < intArr.length; k++){
        	delta = intArr[k] - intArr[k-1];
        	if( (delta > 127) || (delta < -127))
        		System.out.print("-128 ");
        	System.out.print(delta + " ");
        }
	}

}
