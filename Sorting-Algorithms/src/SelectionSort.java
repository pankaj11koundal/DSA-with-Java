// Java Program to perform the Selection Sort.

import java.util.Scanner;

public class SelectionSort {
    static Scanner sc = new Scanner(System.in);

    static void selectionSort(int[] arr)
    {
        int smallest, temp, k;
        for (int i = 0; i < arr.length - 1; i++){
            smallest = arr[i];
            k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < smallest) {
                    smallest = arr[j];
                    k = j;
                }
            }

            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    public static void main(String[] args)
    {
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int []arr = new int[size];
        System.out.println("Enter the size of the array: ");
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        System.out.println("Array before sorting: ");
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        selectionSort(arr);

        System.out.println("Array after sorting: ");
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
}
