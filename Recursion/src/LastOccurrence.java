// To find the last occurrence of an given number or element in the array.

import java.util.Scanner;

public class LastOccurrence {
    static Scanner sc = new Scanner(System.in);

    static int lastOccurrence(int []arr, int n, int num)
    {
        if (n == -1)
            return -1;
        else if (arr[n] == num)
            return n + 1;
        else
            return lastOccurrence(arr, n - 1, num);
    }


    public static void main(String[] args)
    {
        int n, num;
        System.out.print("Enter the size of the array: ");
        n = sc.nextInt();

        int []arr = new int[n];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter the number whose last occurrence you want to find: ");
        num = sc.nextInt();
        System.out.println(lastOccurrence(arr, n - 1, num));
    }

}
