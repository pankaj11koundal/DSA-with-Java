// Program to print the numbers in increasing starting from the 1 to the given number n.

import java.util.Scanner;

public class PrintIncreasing {
    static Scanner sc = new Scanner(System.in);

    static void printInc(int n)
    {
        if (n == 1){
            System.out.print(1 + " ");
            return;
        }

        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args)
    {
        int n;
        System.out.print("Enter the number upto where you want increasing order: ");
        n = sc.nextInt();

        printInc(n);
    }
}
