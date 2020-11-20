package practice.string;

/**
 * 
 * @author Vinod Akkepalli
 *
 */
/**
	 input: I Love You My Friend!!
	 output: Friend!! My You Love I
 */


public class ReverseWordsOfString {

	public static String ReverseWords(String str){
		StringBuilder ans = new StringBuilder();
		int strLen = str.length();
		StringBuilder temp;
		
		for(int i=0;i<strLen;i++){
			temp = new StringBuilder();
			while((i<strLen) && (str.charAt(i) != ' ')){
				temp = temp.append(str.charAt(i));
				i++;
			}
			ans = temp.append(" " + ans);
		}
		
		return ans.toString();
	}
	
	
	public static void main(String[] args) {

		String inputStr = new String("I Love You My Friend!!");
		System.out.println("String is = " + inputStr);
		System.out.println("Reversed words is =  "+ ReverseWords(inputStr));
	}

	
}
