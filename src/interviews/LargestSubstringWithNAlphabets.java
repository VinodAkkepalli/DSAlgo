package interviews;

/**
 * 
 * @author Vinod Akkepalli
 *
 */

/**
ToDo: return the longest string containing maximum N number of alphabets
Input String: abbabbccbccdaab
Input N = 2
Answer:     bbccbcc
Reason: abbaBBCCBCCdaab

N = 3
Answer: abbabbccbcc
Reason: ABBABBCCBCCdaab
 */


public class LargestSubstringWithNAlphabets {

	public static void main(String[] args) {

		String str = "abbabbccbccdaab";
		int N = 3;
		System.out.println("Largest substring of N alphabets is: " + subStringN(str, N));
	}

	private static String subStringN(String str, int N){
        
		// variable to store starting location of the substring
		int baseIndex =0;
		
		//variable to store max length of the substring
		int maxSSLen =0;
		
		//to store current loop length
		int curLen = 0;	
		
		//String to store unique characters while searching for substring
		//intention is to restrict the uniqueChars string to maximum length input N
        StringBuilder uniqueChars = new StringBuilder("");
        int strLen = str.length();
        
        //an empty Character variable 
        Character c ='\0';
        
        for(int i=0; i<strLen ;i++){
        	curLen = 1;
        	uniqueChars = new StringBuilder("");
        	//appending the first character as it will be unique inside the uniqueChars string
        	uniqueChars.append(str.charAt(i));	
	        for(int j = i+1; j<strLen;j++){
	        	
	        	c = str.charAt(j);
                if(uniqueChars.indexOf(c.toString()) != -1){
                	//case when the character is already present in the uniqueChars string
                	//we increment curLen, update maxSSLen if necessary and move to next character 
                	++curLen;
                	if(maxSSLen < curLen){
                    	maxSSLen = curLen;
    			    	baseIndex = i;
                    }
   			    }else if((uniqueChars.indexOf(c.toString()) == -1)){
   			    	//case when the character is NOT already present in the uniqueChars string 
   			    	
   			    	if((uniqueChars.length() < N)){
			    		//number of unique characters encountered are less than N 
	                	//we increment curLen, and move to next character
	                	uniqueChars.append(c);
	                	++curLen;
	                	continue;
   			    	}else if(uniqueChars.length() == N){
			    		//number of unique characters already encountered = N 
	                	//we update maxSSLen if necessary and exit inner loop
	                	if(maxSSLen < curLen){
   		                	maxSSLen = curLen;
   				        	baseIndex = i;
   		                }
   			    		break;
   			    	}
	            }
			}
	        
        }
        return str.substring(baseIndex, baseIndex+maxSSLen);
	}
}
