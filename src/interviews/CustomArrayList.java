package interviews;

/**
 * <b>Description</b> : Custom Array list implementation
 *  Use an Array to store the objects
 *
 * @author Vinod Akkepalli
 */

public class CustomArrayList {
    private static Object[] myObject;
    private static int lastIndex = 0;

    //creates default size Array
    public CustomArrayList() {
        int initialCapacity = 5;
        myObject = new Object[initialCapacity];
    }

    //creates custom sized Array
    public CustomArrayList(int size) {
        myObject = new Object[size];
    }

    void add(Object string) {
        //add element directly
        myObject[lastIndex] = string;
        int currentSize = myObject.length;
        lastIndex++;
        if (lastIndex == currentSize) {
            createDoubleSizedObjectArray(currentSize);
        }

    }

    private void createDoubleSizedObjectArray(int currentSize) {
        Object[] temp = myObject.clone();
        myObject = new Object[2 * currentSize];

        /* every time capacity is reached, create another Object Array of double size
        copy all the elements from past myObject */
        System.arraycopy(temp, 0, myObject, 0, currentSize);
    }

    void delete(String string) {
        //if already empty
        if (lastIndex == 0) {
            System.out.println("Already empty!");
        } else {
            int i = 0;
            for (; i < lastIndex && !myObject[i].equals(string); i++) {}

            if(i == lastIndex) {
                System.out.println("no such object exists");
                return;
            }

            if (lastIndex - 1 - i >= 0) System.arraycopy(myObject, i + 1, myObject, i, lastIndex - 1 - i);
            myObject[lastIndex-1] = null;
            lastIndex--;
        }
    }

    void print() {
        for(Object obj : myObject) {
           if(obj != null)  System.out.println(obj);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomArrayList mArrayList = new CustomArrayList();
        mArrayList.add("123");
        mArrayList.add("Test");
        mArrayList.add("Raju");
        mArrayList.print();

        mArrayList.delete("123");
        mArrayList.print();

        mArrayList.add("Vinod");
        mArrayList.delete("Raju");
        mArrayList.print();

        mArrayList.delete("Vinod1");

    }



}
