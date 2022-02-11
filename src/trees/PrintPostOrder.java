package trees;

import java.util.Arrays;

/**
 * <b>Description</b> :
 * Given Inorder and Preorder traversals of a binary tree, print Postorder traversal.
 * https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/
 *
 * @author Vinod Akkepalli
 */
public class PrintPostOrder {
    static int preInd = 0;
    public static void main(String[] args) {
        int[] in = { 4, 2, 5, 1, 7, 3, 6 };
        int[] pre = { 1, 2, 4, 5, 3, 7, 6 };
//        int[] in = { 4, 2, 5, 1, 3, 6 };
//        int[] pre = { 1, 2, 4, 5, 3, 6 };
//        int[] in = { 1 };
//        int[] pre = { 1 };
//        int[] in = { 2,1,3 };
//        int[] pre = { 1,2,3 };

        System.out.println("Postorder traversal " );
        printPostOrder(in, pre, pre[preInd]);
    }

    private static void printPostOrder(int[] in, int[] pre, int value) {
        int inLen = in.length;

        if(inLen < 1) {
            --preInd;
            return;
        }
        if(inLen == 1) {
            System.out.println(in[0]);
            return;
        }

        int index = findRootIndexInInorder(in, value);
//        System.out.println("root index:" + index + " root element:" + in[index]);
        printPostOrder(Arrays.copyOfRange(in, 0, index), pre, pre[++preInd]);
        printPostOrder(Arrays.copyOfRange(in, index+1, inLen), pre, pre[++preInd]);
        System.out.println(in[index]);
    }

    //Can be converted to map to achieve O(n)
    private static int findRootIndexInInorder(int[] in, int value) {
        int index = 0;
        while (index < in.length && in[index] != value) {
            index++;
        }
        return index;
    }
}
