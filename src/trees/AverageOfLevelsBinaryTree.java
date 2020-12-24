package trees;

import java.util.*;

/**
 * <b>Description</b> :
 * Given a non-empty binary tree, print the average value of the nodes on each level.
 *
 * https://www.geeksforgeeks.org/averages-levels-binary-tree/
 *
 * @author Vinod Akkepalli
 */
public class AverageOfLevelsBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(23);
        root.right = new Node(3);
        root.left.left = new Node(40);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(20);


        List<Float> list = averageOfLevelsBFS(root);
        System.out.println("Averages using BFS: " + list);

        list = averageOfLevelsDFS(root);
        System.out.println("Averages using DFS: " + list);

    }

    //solution using Queues/BFS
    private static List<Float> averageOfLevelsBFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count;
        int sum;
        Node node;
        List<Float> list = new LinkedList<>();

        while(!queue.isEmpty()) {
            count = 0;
            sum = 0;
            Queue<Node> temp = new LinkedList<>();

            while(!queue.isEmpty()) {
                node = queue.remove();
                count++;
                sum += node.data;

                if(node.left != null) {
                    temp.add(node.left);
                }
                if(node.right != null) {
                    temp.add(node.right);
                }
            }

            list.add((float) sum /count);
            queue = temp;
        }
        return list;
    }

    //solution using Stacks/DFS
    private static List<Float> averageOfLevelsDFS(Node root) {
        Map<Integer, Map.Entry<Integer, Integer>> map = new HashMap<>();
        List<Float> list = new LinkedList<>();

        traverseTheTree(root, map, 0);

        for(Map.Entry<Integer, Map.Entry<Integer, Integer>> entry : map.entrySet()) {
//            System.out.println( entry.getKey() + " -> " + (float)entry.getValue().getKey()/entry.getValue().getValue());
            list.add((float)entry.getValue().getKey()/entry.getValue().getValue());
        }
        return list;
    }

    private static void traverseTheTree(Node node,
                                        Map<Integer, Map.Entry<Integer, Integer>> map, int level) {

        if(map.get(level) == null) {
            map.put(level, Map.entry(node.data, 1));
        } else {
            map.put(level,
                    Map.entry(map.get(level).getKey() + node.data,
                            map.get(level).getValue() + 1));
        }
        if(node.left != null) {
            traverseTheTree(node.left, map, level + 1);
        }
        if(node.right != null) {
            traverseTheTree(node.right, map, level + 1);
        }
    }

}
