package p4.recursion.and.backtracking;

import java.util.*;

public class Task9_FibonacciNumbers {

    public static int fibonacci(int n) {

        // Complete the function.
        return recMethod(1, 1, n, 2);
    }

    public static int recMethod (int f1, int f2, int n1, int n2) {
        n2++;
        if (n1 == n2) {
            return f1 + f2;
        } else {
            return recMethod(f2, f1+f2, n1, n2);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}