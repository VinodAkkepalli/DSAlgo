package codingcontest;

/**
 * @author Vinod Akkepalli
 *         problem statement: https://www.hackerrank.com/challenges/prime-checker
 */
import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class Prime {

    static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }

        int sqrt = (int) Math.sqrt(n);
        int i = 2;

        while (i <= sqrt && (n % i != 0)) {
            i++;
        }

        return (i <= sqrt) ? false : true;
    }

    public void checkPrime(int... n) {
        int count = 0;
        for (int i : n) {
            if (Prime.isPrime(i)) {
                count++;
                System.out.print(i + " ");
            }
        }
        if (count == 0) {
            System.out.println(" ");
        } else {
            System.out.println();
        }
    }

}

public class PrimeChecker {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
