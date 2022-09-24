// Java program to perform the Insertion Sort.

import java.util.Scanner;

public class InsertionSort {
    static Scanner sc = new Scanner(System.in);

    static void insertionSort(int []arr)
    {
        int j;
        for (int i = 1; i < arr.length; i++)
        {
            j = i - 1;
            int key = arr[i];
            while(j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        System.out.println("Elements before sorting: ");
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        insertionSort(arr);

        System.out.println();
        System.out.println("Elements after sorting: ");
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
}
