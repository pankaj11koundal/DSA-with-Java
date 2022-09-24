// To find the first occurrence of an given number or element in the array.

import java.util.Scanner;

public class FirstOccurrence {
    static Scanner sc = new Scanner(System.in);

    static int firstOccurrence(int []arr, int i, int n, int num){
        if (i == n)
            return -1;
        else if (arr[i] == num)
            return i + 1;
        else
            return firstOccurrence(arr, i + 1, n, num);
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

        System.out.print("Enter the number whose first occurrence you want: ");
        num = sc.nextInt();

        System.out.println(firstOccurrence(arr, 0, n, num));
    }

}
