// Program to find the sub of the number starting from 1 to given number n.

import java.util.Scanner;

public class SumTillN {
    static Scanner sc = new Scanner(System.in);

    static int sumTillN(int n)
    {
        if (n == 0)
        {
            return 0;
        }

        return n + sumTillN(n - 1);
    }

    public static void main(String[] args)
    {
        int n;
        System.out.print("Enter the number up to where you want to find the sum: ");
        n = sc.nextInt();

        System.out.println("The sum up to given number is " + sumTillN(n));
    }

}
