// Java program to perform the count sort

import java.util.Scanner;

public class CountSort {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int size, maxEle = Integer.MIN_VALUE;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int []arr = new int[size];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
            maxEle = Integer.max(arr[i], maxEle);
        }

        int []count = new int[maxEle + 1];
        for (int i = 0; i < size; i++)
            count[arr[i]]++;

        for (int i = 1; i < maxEle + 1; i++)
            count[i] = count[i] + count[i - 1];

        int []order = new int[size];
        for (int i = 0; i < size; i++)
            order[--count[arr[i]]] = arr[i];

        System.out.println("Array after sorting is: ");
        for (int i = 0; i < size; i++)
            System.out.print(order[i] + " ");
    }
}
