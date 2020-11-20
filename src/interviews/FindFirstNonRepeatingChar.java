package interviews;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author VinodAkkepalli
 *
 * Problem Statement: To find first non repeating character in a give string
 *
 *	Example: input = "scrum of scrums"
 *	output : o
 */


public class FindFirstNonRepeatingChar {

	public static void main(String args[] ) throws Exception {
	    
    	String input = new String("scrum of scrums");
    	
    	Integer count;
    	int len = input.length();
    	Map<Character, Integer> lhm = new LinkedHashMap<Character, Integer>();
    	
    	for(int i = 0; i < len ; i++){
    		count = lhm.get(input.charAt(i));
    		lhm.put(input.charAt(i), (count == null) ? 1 : count+1);
    	}

    	//System.out.println(lhm.toString());
    	
    	for(Map.Entry<Character, Integer> entry : lhm.entrySet()){
    		if(entry.getValue() == 1){
    			System.out.println(entry.getKey());
    			break;
    		}
    	}
    }
}