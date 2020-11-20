package practice.string;

/**
 * 
 * @author VinodAkkepalli
 *
 *	input: The quick brown fox jumps over the lazy dog named Charlie.
 *	output: Eht kciuq nworb xof spmuj revo eht yzal god deman Eilrahc.
 *
 */


public class ReverseWordsInString {

	public static void main(String[] args) {

		String input = "The quick brown fox jumps over the lazy dog named Charlie."; 
		System.out.println(reverseWords(input));
		System.out.println(reverseWords1(input));

	}
	
	//output: Eht kciuq nworb xof spmuj revo eht yzal god deman Eilrahc.
	public static String reverseWords1(String str){
		String ans = "";
		int strLen = str.length();
		StringBuilder temp;
		
		for(int i=0;i<strLen;i++){
			temp = new StringBuilder(0);
			while((i<strLen) && (str.charAt(i) != ' ') && (str.charAt(i) != '.')){
				temp = temp.append(str.charAt(i));
				i++;
			}
			temp = myReverse(temp.toString());
			ans = ans + temp + str.charAt(i);
		}
		return ans;
	}
	
	//This method does not automatically take care of any punctuation like full stop
	// output : Eht kciuq nworb xof spmuj revo eht yzal god deman Eilrahc
	public static String reverseWords(String input){
		StringBuilder ans = new StringBuilder(0);
		String[] strArr = input.split("[ .]+");
	
		for(int i = 0; i < strArr.length; i++){
			 
			ans = ans.append(myReverse(strArr[i]) + " ");
		}
		return ans.toString();
	}
	
	
	//This method returns a reverse of a string passed and
	//if first char is capital letter, it makes sure that first character is capital even after reversing
	public static StringBuilder myReverse(String str){
		
		StringBuilder ans = new StringBuilder(0);
		boolean flag = false;
		int wordLen = str.length();
		
		if(str.charAt(0) >= 65 && str.charAt(0) <= 90)
			flag = true;
		
		for(int j = wordLen-1; j >=0 ; j--){
			if(flag && j == (wordLen-1)){
				ans = ans.append((char)(str.charAt(j) - 32));
			}else if(flag && j == 0){
				ans = ans.append((char)(str.charAt(j) + 32));
			}else{
				ans = ans.append(str.charAt(j));
			}
		}
		return ans;
	}
}
