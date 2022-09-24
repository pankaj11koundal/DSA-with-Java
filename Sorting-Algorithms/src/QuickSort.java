// Java program to perform the Quick sort

import java.util.Scanner;

public class QuickSort {
    static Scanner sc = new Scanner(System.in);

    static void swap(int i, int j, int []arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int []arr, int low, int high)
    {
        int i = low, j = high, pivot = arr[low];

        while (i < j){
            while (i < high + 1 && arr[i] <= pivot)
                i++;

            while (j > low && arr[j] >= pivot)
                j--;

            if (i < j)
                swap(i, j, arr);
        }

        if (j >= low)
        {
            swap(j, low, arr);
        }

        return j;
    }

    static void quickSort(int []arr, int low, int high)
    {
        if (low < high) {
            int mid = partition(arr, low, high);
            quickSort(arr, low, mid);
            quickSort(arr, mid + 1, high);
        }
    }

    public static void main(String[] args)
    {
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int [] arr = new int[size];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        quickSort(arr, 0, size - 1);

        System.out.println("Array after sorting:");
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
}
