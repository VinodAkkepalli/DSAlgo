package string;


/**
 *  LeetCode#443. String Compression
    Given an array of characters chars, compress it using the following algorithm:

    Begin with an empty string s. For each group of consecutive repeating characters in chars:

    If the group's length is 1, append the character to s.
    Otherwise, append the character followed by the group's length.
    The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

    After you are done modifying the input array, return the new length of the array.

    You must write an algorithm that uses only constant extra space.

    Note: The characters in the array beyond the returned length do not matter and should be ignored.

    Example 1:
    Input: chars = ["a","a","b","b","c","c","c"]
    Output: 6
    Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
    After modifying the input array in-place, the first 6 characters of chars should be ["a","2","b","2","c","3"].
    Example 2:

    Input: chars = ["a"]
    Output: 1
    Explanation: The only group is "a", which remains uncompressed since it is a single character.
    After modifying the input array in-place, the first character of chars should be ["a"].
    Example 3:

    Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
    Output: 4
    Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
    After modifying the input array in-place, the first 4 characters of chars should be ["a","b","1","2"].
 */


public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a','a','a','a','a','a','a','a','a','a','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c' };
        // char[] chars = {'a'};

        int ans = compress(chars);
        
        for(int i = 0; i < ans; i++) {
            System.out.print(chars[i]);
        }
    }

    public static int compress(char[] chars) {
        int p1 = 0; // Starting index of the current run of same characters
        int p2 = 0; // Next index where compressed data should be written
        int i = 0; // Pointer used to scan through the original array
        int cLen = chars.length; // Total length of the original input
        int count = 0; // Size of the current run; used as final compressed output length

        // Keep scanning until we have processed the entire array
        while(i < cLen) {
            p1 = i; // Start of the current repeated-character block

            // Move forward while the current character matches the starting character
            while(i < cLen && chars[i] == chars[p1]) {
                i++;
            }

            // If the run length is 1, keep the character as-is at the compressed position
            if(i-p1 == 1) {
                count++;
                chars[p2] = chars[p1];
                p2++;
            } else {
                // For repeated runs, write the character and then the digit count
                p2 = fillChars(chars, p1, p2, i);

                // Count includes the character itself and each digit in the repeat count
                count += (String.valueOf(i-p1)).length() + 1;
            }
        }

        return count;
    }


    // Writes a compressed block in-place: 'c' followed by its count, e.g. 'a' + '3'
    public static int fillChars(char[] chars, int p1, int p2, int i) {
        int charCount = i-p1; // Number of times the character repeats
        chars[p2] = chars[p1]; // Write the actual character first
        p2++;

        // Then write each digit of the count separately, e.g. 12 -> '1', '2'
        for(char c: String.valueOf(charCount).toCharArray()) {
            chars[p2] = c;
            p2++;
        }

        return p2;
    }
}
