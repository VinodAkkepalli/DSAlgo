package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Description</b> :
 * Tree and its operations
 *
 * @author Vinod Akkepalli
 */

class Node {
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeOperations {

    static int treeHeight(Node node) {
        if (node == null){
            return 0;
        }

        return Math.max(treeHeight(node.left), treeHeight(node.right)) + 1;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(100);

        System.out.println("Height of tree is : " + treeHeight(root));

        System.out.println("Common ancestor is: " + findLeastCommonAncestor(root, 4, 100));
    }

    private static final List<Integer> path1 = new ArrayList<>();
    private static final List<Integer> path2 = new ArrayList<>();

    // Finds the path from root node to given root of the tree.
    static int findLeastCommonAncestor(Node root, int n1, int n2) {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }

    private static int findLCAInternal(Node root, int n1, int n2) {

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {

            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i-1);
    }

    // Finds the path from root node to given root of the tree, Stores the
    // path in a vector path[], returns true if path exists otherwise false
    private static boolean findPath(Node root, int n, List<Integer> path)
    {
        // base case
        if (root == null) {
            return false;
        }

        // Store this node . The node will be removed if not in path from root to n.
        path.add(root.data);

        if (root.data == n) {
            return true;
        }

        if (findPath(root.left, n, path)) {
            return true;
        }

        if (findPath(root.right, n, path)) {
            return true;
        }

        // If not present in subtree rooted with root, remove root from path[] and return false
        path.remove(path.size()-1);

        return false;
    }
}
