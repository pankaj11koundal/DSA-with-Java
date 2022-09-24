// Program to print the string in reverse order using recursion.

import java.util.Scanner;

public class PrintReverseString {
    static Scanner sc = new Scanner(System.in);

    static void printReverseString(String str,int n)
    {
        if (n == -1)
            return;

        System.out.print(str.charAt(n));
        printReverseString(str, n - 1);
    }


    public static void main(String[] args)
    {
        String str;
        System.out.print("Enter the string: ");
        str = sc.next();

        printReverseString(str, str.length() - 1);
    }
}
