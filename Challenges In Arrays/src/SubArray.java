// A subarray is a slice from a contiguous array(i.e., occupy consecutive positions)
// and inherently maintains the order of elements.

import java.util.Scanner;

public class SubArray {

    static Scanner sc = new Scanner(System.in);

    static void printSubarray(int[] arr){
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++)
                    System.out.print(arr[k] + " ");
                System.out.println();
            }
    }

    public static void main(String[] args){
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the element in the array: ");
        for (int i = 0; i < size; i++  ){
            arr[i] = sc.nextInt();
        }

        printSubarray(arr);
    }
}
