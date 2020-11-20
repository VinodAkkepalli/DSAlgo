package myThreadsRunnable;

/**
 * 
 * @author VinodAkkepalli
 *
 * Program to print even numbers from one thread and odd numbers from another thread but, 
 * together producing one natural sequence output
 *
 */


public class OddEvenPrintTester {

    public static void main(String ... args){
        Printer print = new Printer();

        //Two threads are created here, One to print all odd numbers
        //and another to print all even numbers 
        //using same Runnable class TaskEvenOdd
        Thread t1 = new Thread(new TaskEvenOdd(print, 20, "Odd"));
        Thread t2 = new Thread(new TaskEvenOdd(print, 20, "Even"));
        t1.start();
        t2.start();
    }

}

class TaskEvenOdd implements Runnable {

    private int max;
    private Printer print;
    private boolean isEvenNumber;

    TaskEvenOdd(Printer print, int max, String str){
        this.print = print;
        this.max = max;
        this.isEvenNumber = (str.equals("Odd") ? false:true) ;
    }

    @Override
    public void run() {

        int number = isEvenNumber == true ? 2 : 1;
        while(number<= max){

            if(isEvenNumber){
                //System.out.println("Even : "+ Thread.currentThread().getName());
                print.printEven(number);
            }   
            else {
                //System.out.println("Odd : "+ Thread.currentThread().getName());
                print.printOdd(number);
            }
            number+=2;
        }

      }

    }

class Printer {

    boolean isOdd= false;


    synchronized void printEven(int number) {

        while(isOdd == false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(number);
        isOdd = false;
        notifyAll();
    }

    synchronized void printOdd(int number) {
        while(isOdd == true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(number);
        isOdd = true;
        notifyAll();
    }

}