// Java program to show the implementation of the Dutch National Flag sort.

import java.util.Scanner;

public class DNFSort {
    static Scanner sc = new Scanner(System.in);

    static void swap(int[] arr, int low, int mid)
    {
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
    }

    public static void main(String[] args)
    {
        int size;
        System.out.println("Enter the size of the array: ");
        size = sc.nextInt();

        int []arr = new int[size];
        System.out.println("Enter the elements in the array(0, 1, 2): ");
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        int low = 0, high = size - 1, mid = 0;

        while (mid <= high)
        {
            if (arr[mid] == 1)
                mid++;
            else if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, high, mid);
                high--;
            }
        }

        System.out.println("Array after sorting: ");
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
}
