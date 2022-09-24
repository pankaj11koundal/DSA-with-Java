// You are given an array of N integers including 0.
// The task is to find the smallest positive number missing from the array.

import java.util.Scanner;

public class PositiveMissingNumber {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt(), max = Integer.MIN_VALUE;
        int [] arr = new int[size];

        System.out.print("Enter the elements in the array: ");
        for (int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
            if (max < arr[i])
                max = arr[i];
        }

        int []count = new int[max + 1];
    
        for (int i = 0; i < size; i++)
            count[arr[i]] = 1;

        for (int i = 0; i < max; i++)
            if (count[i] != 1){
                System.out.println(i);
                break;
            }
    }
}
