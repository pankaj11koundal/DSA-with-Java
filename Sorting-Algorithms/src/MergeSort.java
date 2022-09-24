// Program to perform the merge sort.

import java.util.Scanner;

public class MergeSort {
    static Scanner sc = new Scanner(System.in);

    static void merging(int []arr, int low, int mid, int high)
    {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] l = new int[n1];
        int [] r = new int[n2];

        if (n1 > 0)
            for (int i = 0; i < n1; i++)
                l[i] = arr[low + i];

        if (n2 > 0)
            for (int i = 0; i < n2; i++)
                r[i] = arr[mid + 1 + i];

        int i = 0;
        int j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if(l[i] < r[j]) {
                arr[k] = l[i];
                i++;
            } else {
                arr[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = l[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = r[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int []arr, int low, int high)
    {
        if (low < high)
        {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merging(arr, low, mid, high);
        }
    }

    public static void main(String[] args)
    {
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int []arr = new int[size];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        mergeSort(arr, 0, size - 1);

        System.out.println("Array after sorting: ");
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
}
