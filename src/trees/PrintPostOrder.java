package trees;

import java.util.HashMap;

/**
 * <b>Description</b> :
 * Given Inorder and Preorder traversals of a binary tree, print Postorder traversal.
 * https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/
 *
 * @author Vinod Akkepalli
 */
public class PrintPostOrder {

    static int preIndex = 0;
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
        HashMap<Integer, Integer> inorderLocMap = buildInorderLocationsMap(in);
        printPostOrder(in, pre, 0, pre.length-1, inorderLocMap);
    }

    private static HashMap<Integer, Integer> buildInorderLocationsMap(int[] in) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return map;
    }

    static void printPostOrder(int[] in, int[] pre, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd) {
            return;
        }

        // Find index of next item in preorder traversal in inorder.
        int root = map.get(pre[preIndex++]);

        // traverse left tree
        printPostOrder(in, pre, inStart, root - 1, map);

        // traverse right tree
        printPostOrder(in, pre, root + 1, inEnd, map);

        // print root node at the end of traversal
        System.out.print(in[root] + " ");
    }
}
