package practice.lambdas;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {

    interface FunctionalInterface {
        int add(int x, int y);
    }

    public static void main(String[] args) {
        List<String> stringlList = new ArrayList<>();
        stringlList.add("Vinod");
        stringlList.add("Rakesh");
        stringlList.add("Ramesh");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        stringlList.forEach(str-> System.out.println(str + " Is a good boy"));

        //parallelStream works in multi-threaded environments
        stringlList.parallelStream().forEach(str-> System.out.println(str + " Is a good boy"));

        //Lambda expression implementing a Functional interface
        FunctionalInterface fInt = (int x, int y) -> {return x+y;};
        System.out.println(fInt.add(2,5));
    }

}
