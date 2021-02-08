package arrays;

/**
 * <b>Description</b> :
 * Given an array of integers, find the sign of product of all the numbers in array
 *
 * @author Vinod Akkepalli
 */
public class FindSign {

    public static void main(String[] args) {
        int[] arr = {1,-2,3,-5};
        int ans = findSignOfProduct(arr);
        if(ans > 0) {
            System.out.println("Positive");
        } else if(ans < 0){
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }

    }

    private static int findSignOfProduct(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if(i == 0) {
                return 0;
            } else if (i < 0) {
                count++;
            }
        }
        return count % 2 == 0 ? 1 : -1;
    }
}
