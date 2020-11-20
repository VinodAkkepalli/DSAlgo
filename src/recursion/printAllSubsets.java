package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Description</b> :
 * Print all sub arrays of an array
 * Print all subsequences of a string
 * https://www.youtube.com/watch?v=Yg5a2FxU4Fo&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=12
 *
 * @author Vinod Akkepalli
 */
public class printAllSubsets {

    public static void main(String[] args) {

        ArrayList<Integer> inputList = new ArrayList<>(List.of(1, 2, 3, 4));
        subsetsRec(inputList, new ArrayList<>());

        String str = "abcd";
        printAllSubsequencesRec(str, "");
    }

    private static void printAllSubsequencesRec(String inputStr, String outputStr) {

        //Base condition
        if(inputStr.length() == 0) {
//            System.out.println(Arrays.toString(outputStr.toCharArray()));
            System.out.println(outputStr);
            return;
        }

        //Recursion
        printAllSubsequencesRec(inputStr.substring(1), outputStr);
        printAllSubsequencesRec(inputStr.substring(1), outputStr + inputStr.charAt(0));
    }

    private static void subsetsRec(ArrayList<Integer> inputList, ArrayList<Integer> outputList) {

        //base condition
        if(inputList.isEmpty()){
            System.out.println(outputList);
            return;
        }


        ArrayList<Integer> outputList1 = new ArrayList<>(outputList);
        ArrayList<Integer> outputList2 = new ArrayList<>(outputList);
        outputList2.add(inputList.get(0));

        //input reduction
        ArrayList<Integer> inputList1 = new ArrayList<>(inputList);
        inputList1.remove(0);

        //Recursive calls
        subsetsRec(inputList1, outputList1);
        subsetsRec(inputList1, outputList2);
    }
}
