// Java program to print the number from 1 to N using recursion

import java.util.Scanner;

public class Print1toN {
    static Scanner sc = new Scanner(System.in);

    static void print1toN(int n) {
        if (n != 0) {
            print1toN(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        int n;
        System.out.print("Enter the number up to where you want to print the numbers: ");
        n = sc.nextInt();

        print1toN(n);
    }
}
