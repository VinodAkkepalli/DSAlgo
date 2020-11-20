package practice.string;

/**
 * <b>Description</b> : Reverse a string without affecting special characters
 * Given a string, that contains special character together with alphabets,
 * reverse the string in a way that special characters & their positions not affected.
 * https://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/
 *
 * @author Vinod Akkepalli
 */
public class StringReverseWOSpecialChars {
    public static void main(String[] args) {
        String str = "a!!!b.c.d,e'f,ghi";   // output i!!!h.g.f,e'd,cba
        char[] charArray = str.toCharArray();

        System.out.println("Input string: " + str);
        reverse(charArray);
        String revStr = new String(charArray);
        System.out.println("Output string: " + revStr);
    }

    //parse the string from both ends and swap when both are alphabetic chars
    public static void reverse(char[] str)
    {
        int r = str.length - 1;
        int l = 0;

        while (l < r) {
            if (!Character.isAlphabetic(str[l])) {
                l++;
            } else if (!Character.isAlphabetic(str[r])) {
                r--;
            } else {
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;
                l++;
                r--;
            }
        }
    }
}
