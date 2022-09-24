// Java program to perform the wave sort.

import java.util.Scanner;

public class WaveSort {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int []arr = new int[size];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();


    }
}
