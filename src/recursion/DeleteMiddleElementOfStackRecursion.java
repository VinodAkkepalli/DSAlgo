package recursion;

import java.util.Stack;

import static recursion.SortStackRecursive.printStack;

/**
 * <b>Description</b> : delete middle element of a stack using recursion
 *
 * https://www.youtube.com/watch?v=oCcUNRMl7dA&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=8 *
 * @author Vinod Akkepalli
 */
public class DeleteMiddleElementOfStackRecursion {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Original Stack elements: ");
        printStack(s);

        if(s.size() == 0) {
            System.out.println("nothing to delete");
        } else {
            deleteElement(s, s.size() / 2);
            System.out.println("\n\nStack elements after deleting middle: ");
            printStack(s);
        }
    }

    private static void deleteElement(Stack<Integer> s, int count) {
        if(count == 0) {
            s.pop();
            return;
        }
        int topElement = s.pop();
        deleteElement(s, count-1);
        s.push(topElement);
    }


}
