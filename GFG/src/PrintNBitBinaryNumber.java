// Java program to implement the print n digit binary number with number of 1s greater than number of 0s in all prefixes

import java.util.Scanner;
import java.util.ArrayList;

public class PrintNBitBinaryNumber {

    static Scanner sc = new Scanner(System.in);

    static void printNDigitBinary(int n, int ones, int zeros, String op, ArrayList<String> ar) {
        if (n == 0)
            ar.add(op);
        else {
            printNDigitBinary(n - 1, ones + 1, zeros, op + '1', ar);

            if (zeros < ones)
                printNDigitBinary(n - 1, ones, zeros + 1, op + '0', ar);
        }
    }

    static ArrayList<String> NBitBinary(int n) {
        ArrayList<String> ar = new ArrayList<>();
        if (n != 0) {
            printNDigitBinary(n, 0, 0, "", ar);
        }
        return ar;
    }

    public static void main(String[] args) {
        int n;
        System.out.println("Enter the number of digits: ");
        n = sc.nextInt();
        ArrayList<String> ar =  NBitBinary(n);
        System.out.println(ar);
    }
}
