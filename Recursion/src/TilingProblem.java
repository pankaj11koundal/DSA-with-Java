// Find the number of ways to tile the floor with 1x2 and 1x1 tiles.

import java.util.Scanner;

public class TilingProblem {
    static Scanner sc = new Scanner(System.in);

    static int tileTheTile(int n)
    {
        if (n == 0 || n == 1)
            return n;

        return tileTheTile(n - 1) + tileTheTile(n - 2);
    }

    public static void main(String[] args)
    {
        int n;
        System.out.print("Enter the number of columns of the floor: ");
        n = sc.nextInt();

        System.out.println(tileTheTile(n));
    }

}
