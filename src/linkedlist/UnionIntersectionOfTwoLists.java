package linkedlist;

import java.util.HashSet;

/**
 * Given two singly Linked Lists, create union and intersection lists that contain the union and intersection of the elements present in the given lists. Each of the two linked lists contains distinct node values.
 * Note: The order of elements in output lists doesn’t matter.
 * Examples:
 * Input:
 * head1 : 10 -> 15 -> 4 -> 20
 * head2 : 8 -> 4 -> 2 -> 10
 * Output:
 * Intersection List: 4 -> 10
 * Union List: 2 -> 8 -> 20 -> 4 -> 15 -> 10
 * Explanation: In these two lists 4 and 10 nodes are common. The union lists contain all the nodes of both lists.
 */


public class UnionIntersectionOfTwoLists {

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void printUnion(Node head1, Node head2) {

        Node result = null;
        HashSet<Integer> unionSet = new HashSet<>();

        Node temp = head1;
        while(temp != null) {
            unionSet.add(temp.data);
            temp = temp.next;
        }

        temp = head2;
        while(temp != null) {
            unionSet.add(temp.data);
            temp = temp.next;
        }

        for (int i : unionSet) {
            Node newNode = new Node(i);
            newNode.next = result;
            result = newNode;

        }
        printList(result);
    }

    public static void main(String[] args) {

        // List 1: 1 -> 2 -> 3 -> 3 -> 4 -> 5
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = new Node(5);

        // List 2: 1 -> 5 -> 6
        Node head2 = new Node(1);
        head2.next = new Node(5);
        head2.next.next = new Node(6);

        System.out.println("Union of given lists: " );
        printUnion(head1, head2);

        System.out.println("Intersection of given lists: " );
        printIntersection(head1, head2);
    }

    private static void printIntersection(Node head1, Node head2) {
        Node result = null;
        HashSet<Integer> commonSet = new HashSet<>();

        Node temp = head1;
        while(temp != null) {
            commonSet.add(temp.data);
            temp = temp.next;
        }

        temp = head2;
        while(temp != null) {
            if(commonSet.contains(temp.data)) {
                Node newNode = new Node(temp.data);
                newNode.next = result;
                result = newNode;
            }
            temp = temp.next;
        }

        printList(result);
    }


}
