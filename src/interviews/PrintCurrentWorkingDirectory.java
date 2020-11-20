package interviews;

import java.util.ArrayList;

/**
 * 
 * @author Vinod Akkepalli
 *
 *	Problem Description: Given two strings 
 *	str1 - current working directory (eg. /foo/bar)
 *	str2 - string which is like an input windows cd command or linux cddir command (eg. ../abc/xyz/../abd)
 *	Assuming that all the folder names in the path exist, print the final current working directory
 */


public class PrintCurrentWorkingDirectory {

	public static void main(String[] args) {
		String initialPath = "/foo/bar";
		String pathToNavigate = "../abc/xyz/.././abd/";	// Output = /foo/abc/abd
		final String SEPARATOR = "/";
		printFinalCurrentWorkingDirectory(initialPath, pathToNavigate, SEPARATOR);
	}

	/* TC is O((initialPath+pathToNavigate.length()) */
	private static void printFinalCurrentWorkingDirectory(String initialPath, 
			String pathToNavigate, final String SEPARATOR) {
		
		ArrayList<String> finalPath = new ArrayList<>();
		String combinedPath = initialPath + SEPARATOR + pathToNavigate;
		
		/* Split the combinedPath by SEPARATOR
		 ignore tokens "." && ""
		 remove the last token if current token is ".."
		 add/collect the current token if is none of the above */
		for(String token : combinedPath.split(SEPARATOR)) {
			if(token.equals(".") || token.equals("")) {
				continue;
			} else if(token.equals("..")) {
				finalPath.remove(finalPath.size()-1);
			} else {
				finalPath.add(token);
			}
//			System.out.println("token: " + token);
//			System.out.println(finalPath.toString());
		}		
//		System.out.println(finalPath.toString());
		
		System.out.print("Final current working directory is: ");
		for(String token : finalPath) {
			System.out.print(SEPARATOR+token);
		}
	}

}
