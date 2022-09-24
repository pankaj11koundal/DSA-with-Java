// Java program to print the number from n to 1

import java.util.Scanner;

public class PrintNto1 {
    static Scanner sc = new Scanner(System.in);

    static void printNto1(int n) {
        if (n != 0) {
            System.out.print(n + " ");
            printNto1(n - 1);
        }
    }

    public static void main(String[] args) {
        int n;
        System.out.print("Enter the number from where up to 1 you want to print the sequence: ");
        n = sc.nextInt();

        printNto1(n);
    }
}
