// To calculate the power of a given number n up to an given number p.

import java.util.Scanner;

public class CalculatePower {
    static Scanner sc = new Scanner(System.in);

    static int calcPower(int n, int p)
    {
        if (p == 0)
            return 1;

        return n * calcPower(n, p - 1);
    }

    public static void main(String[] args)
    {
        int n, p;

        System.out.print("Enter the number: ");
        n = sc.nextInt();

        System.out.print("Enter the power");
        p = sc.nextInt();

        System.out.println(calcPower(n, p));
    }

}
