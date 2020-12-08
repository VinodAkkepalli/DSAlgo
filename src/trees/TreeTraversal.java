package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <b>Description</b> :
 *
 * Breadth first traversal - aka Level Order Traversal
 * https://www.youtube.com/watch?v=kQ-aoKbGKSo
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 *
 * Depth first traversal - aka Pre Order Traversal
 * https://www.youtube.com/watch?v=0u78hx-66Xk
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 *
 * dependent problems : https://www.geeksforgeeks.org/connect-nodes-at-same-level/
 *
 * Further learning: https://www.youtube.com/watch?v=pcKY4hjDrxk
 *
 * @author Vinod Akkepalli
 */

public class TreeTraversal {

    public static void main(String[] args)
    {
        //creating a binary tree and entering the nodes
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.right.right = new Node(7);
        root.right.right.left = new Node(14);

        System.out.println("Level order traversal of binary tree is - ");
        printLevelOrder(root);

        System.out.println();
        System.out.println("Pre order traversal of binary tree is - ");
        printPreOrder(root);
    }

    //Breadth first traversal
    private static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.data + " ");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }

        }
    }

    //Depth first traversal
    private static void printPreOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            Node node = stack.pop();

            System.out.print(node.data + " ");
            if(node.right != null) {
                stack.add(node.right);
            }
            if(node.left != null) {
                stack.add(node.left);
            }

        }
    }
}
