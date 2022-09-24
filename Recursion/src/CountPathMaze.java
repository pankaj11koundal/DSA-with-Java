// Given a 2-D grid, find the number of ways to reach (n-1, n-1).
// You can go to (i, j) from (i+1, j) and (i, j + 1).

import java.util.Scanner;

public class CountPathMaze {
    static Scanner sc = new Scanner(System.in);

    static int countPaths(int r, int c, int n)
    {
        if (r == n - 1 && c == n - 1)
            return 1;

        if (r >= n || c >= n) {
            return 0;
        }

        return countPaths(r + 1, c, n) + countPaths(r, c + 1, n);
    }

    public static void main(String[] args)
    {
        int n;
        System.out.print("Enter the grid dimension: ");
        n = sc.nextInt();

        System.out.println(countPaths(0, 0, n));
    }

}
