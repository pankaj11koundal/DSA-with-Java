// Java Program to perform the bubble sort.

import java.util.Scanner;

public class BubbleSort {

    static Scanner sc = new Scanner(System.in);

    static void bubbleSort(Integer []arr)
    {
        int temp;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void main(String[] args)
    {
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        Integer []arr = new Integer[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        System.out.println("Array before performing sorting");
        for (int i = 0; i < size; i ++)
            System.out.print(arr[i] + " ");

        bubbleSort(arr);
        System.out.println();
        System.out.println("Array after performing sorting");
        for (int i = 0; i < size; i ++)
            System.out.print(arr[i] + " ");
    }
}
