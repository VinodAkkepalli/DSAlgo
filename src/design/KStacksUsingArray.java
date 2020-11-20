package design;

import java.util.Arrays;

/**
 * <b>Description</b> :
 * Design and implement 3 stacks using array
 *
 * Use another array of same size to maintain indexes
 *
 * Further Improvement: Use another stack/queue to maintain emptied locations for further usage
 * @author Vinod Akkepalli
 */
public class KStacksUsingArray {

    static int[] arr;
    static int[] indexArr;
    static int top;
    private static int[] stackArr;

    public static void main(String[] args) {
        int arrLen = 10;
        arr = new int[arrLen];
        indexArr = new int[arrLen];
        int k = 3;

        top = 0;

        //represent K different stacks
        stackArr = new int[k];
        Arrays.fill(stackArr, -1);

        push(0, 10);
        push(1, 8);
        push(0, 3);
        push(2, 4);
        push(1, 11);
        push(0, 9);
        push(1, 8);

        printArray();
        printStackArray();
        printIndexArray();

        int pop = pop(0);
        System.out.println(pop);
        pop = pop(0);
        System.out.println(pop);
        pop = pop(1);
        System.out.println(pop);

        printArray();
        printStackArray();
        printIndexArray();

    }

    private static void printIndexArray() {
        System.out.println(Arrays.toString(indexArr));
    }

    private static void printStackArray() {
        System.out.println(Arrays.toString(stackArr));
    }

    private static void printArray() {
        System.out.println("Elements in the array are: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void push(int stackId, int element) {
        arr[top] = element;
        indexArr[top] = stackArr[stackId];
        stackArr[stackId] = top;
        top++;
    }

    public static int pop(int stackId) {
        int popIndex = stackArr[stackId];
        int element = arr[popIndex];
        arr[popIndex] = -999;
        stackArr[stackId] = indexArr[popIndex];
        indexArr[popIndex] = -999;

        return element;
    }
}
