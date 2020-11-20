package recursion;

import java.util.Stack;

import static recursion.SortStackRecursive.printStack;

/**
 * <b>Description</b> :
 * Reverse a stack using recursion
 * https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 * https://www.youtube.com/watch?v=8YXQ68oHjAs&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=9
 *
 * @author Vinod Akkepalli
 */
public class ReverseStackRecursion {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        printStack(s);
        System.out.println();

        System.out.println("Stack elements after reversing: ");

        reverseStack(s);
        printStack(s);
    }

    public static void reverseStack(Stack<Integer> s) {

        if(s.size() == 1)
            return;

        int top = s.pop();
        reverseStack(s);
        insertAtBottom(s, top);
    }

    /* recursively pop all elements and push top element to bottom */
    private static void insertAtBottom(Stack<Integer> s, int ele) {
        if(s.size() == 0) {
            s.push(ele);
            return;
        }

        int top = s.pop();
        insertAtBottom(s, ele);
        s.push(top);
    }
}
