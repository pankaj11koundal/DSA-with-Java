// Program to print the numbers starting from an given number to 1.

import java.util.Scanner;

public class PrintDecreasing {
    static Scanner sc = new Scanner(System.in);

    static void printDec(int n)
    {
        if (n == 0)
            return;

        System.out.print(n + " ");
        printDec(n - 1);
    }


    public static void main(String[] args)
    {
        int n;
        System.out.print("Enter the number the number up to where you want to print the decreasing order: ");
        n = sc.nextInt();

        printDec(n);
    }
}
