// Program to check whether a given array is sorted or not recursively

import java.util.Scanner;

public class CheckSortedArray {
    static Scanner sc = new Scanner(System.in);

    static boolean checkSorted(int []arr, int i)
    {
        if (i == arr.length - 1)
            return true;

        return (arr[i] < arr[i + 1] && checkSorted(arr, i + 1));
    }


    public static void main(String[] args)
    {
        int n;
        System.out.print("Enter the size of the array: ");
        n = sc.nextInt();

        int []arr = new int[n];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();


        System.out.println(checkSorted(arr, 0));
    }
}
