package recursion;

import java.util.ListIterator;
import java.util.Stack;

/**
 * <b>Description</b> :
 * sort elements of a stack using recursion
 * https://www.youtube.com/watch?v=MOGBRkkOhkY&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=7
 * https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 *
 * @author Vinod Akkepalli
 */
public class SortStackRecursive {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        printStack(s);

        sortStack(s);
        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);

        ReverseStackRecursion.reverseStack(s);
    }

    // Recursive Method to insert an item x in sorted way
    static void sortedInsert(Stack<Integer> s, int x) {
        // Base case
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }

        // If top is greater, remove the top item and recur
        int temp = s.pop();
        sortedInsert(s, x);

        // Put back the top item removed earlier
        s.push(temp);
    }

    // Method to sort stack
    static void sortStack(Stack<Integer> s) {
        // If stack is not empty
        if (!s.isEmpty()) {
            // Remove the top item
            int x = s.pop();

            // Sort remaining stack
            sortStack(s);

            // Push the top item back in sorted stack
            sortedInsert(s, x);
        }
    }

    // Utility Method to print contents of stack
    static void printStack(Stack<Integer> s) {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext()) {
            lt.next();
        }

        // printing from top to bottom
        while (lt.hasPrevious()) {
            System.out.print(lt.previous() + " ");
        }
    }
}