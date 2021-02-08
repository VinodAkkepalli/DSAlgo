package string;

/**
 * <b>Description</b> :
 * Given a string and an integer k. This string needs to be sent as SMS of length k or less characters each.
 * Find the number of SMS required.
 * We should not break the string by breaking any word, string should be broken at space characters.
 *
 * @author Vinod Akkepalli
 */
public class FindNumberOfSMS {

    public static void main(String[] args) {
//        String str = "SMS messages are really short";   //ans 3
//        String str = "";    //ans 0
//        String str = "abcdefghijkl abcdefghijkl";    //ans 2
        String str = "abcdefghijklxyz";    //ans -1
        int k = 12;
        System.out.println(findNumOfSMS(str, k));

    }

    private static int findNumOfSMS(String str, int k) {
        int ans = 0;

        if(str.isEmpty()) {
            return 0;
        }
        if(str.indexOf(' ') < 0) {
            return -1;
        }

        while (!str.isEmpty() & str.length() > k) {
            if(str.charAt(k) == ' ') {
                str = str.substring(k+1);
            } else {
                if(str.substring(0, k).lastIndexOf(' ') < 0) {
                    return -1;
                }
                str = str.substring(str.substring(0, k).lastIndexOf(' ')+1);
            }
//            System.out.println(str);
            ans++;
        }

        if(!str.isEmpty()) {
            ans++;
        }

        return ans;
    }
}
