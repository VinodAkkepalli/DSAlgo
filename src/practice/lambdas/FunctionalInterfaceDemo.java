package practice.lambdas;

@FunctionalInterface
interface funcInterface {
    void absMethod();
}

public class FunctionalInterfaceDemo implements funcInterface {

    public static void main(String[] args) {

        FunctionalInterfaceDemo obj = new FunctionalInterfaceDemo();
        obj.absMethod();

        //Lambda expression
        funcInterface obj2 = () -> System.out.println("I am from Lambda expression");
        obj2.absMethod();

        //Lambda implementing Runnable which is a Functional Interface
        new Thread(() -> System.out.println("I am from thread")).start();
    }

    @Override
    public void absMethod() {
        System.out.println("I am from absMethod");
    }
}
