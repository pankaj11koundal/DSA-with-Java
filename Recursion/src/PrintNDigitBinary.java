// Java program to implement the print n digit binary number with number of 1s greater than number of 0s in all prefixes

import java.util.Scanner;

public class PrintNDigitBinary {

    static Scanner sc = new Scanner(System.in);

    static void printNDigitBinary(int n, int ones, int zeros, String op) {
        if (n == 0)
            System.out.println(op);
        else {
            printNDigitBinary(n - 1, ones + 1, zeros, op + '1');

            if (zeros < ones)
                printNDigitBinary(n - 1, ones, zeros + 1, op + '0');
        }
    }

    public static void main(String[] args) {
        int n;
        System.out.println("Enter the number of digits: ");
        n = sc.nextInt();
        printNDigitBinary(n, 0, 0, "");
    }
}
