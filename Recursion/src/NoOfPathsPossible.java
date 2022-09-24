// Find the number of ways to reach the End 'e' from Sources 's'.

import java.util.Scanner;

public class NoOfPathsPossible {
    static Scanner sc = new Scanner(System.in);

    static int findPossiblePaths(int s, int e)
    {
        if (s == e)
            return 1;

        if (s > e)
            return 0;

        int count = 0;
        for (int i = 1; i <= 6; i++)
            count += findPossiblePaths(s + i, e);

        return count;
    }

    public static void main(String[] args)
    {
        int s, e;
        System.out.print("Enter the source: ");
        s = sc.nextInt();

        System.out.print("Enter the end: ");
        e = sc.nextInt();

        System.out.println(findPossiblePaths(s, e));
    }

}
