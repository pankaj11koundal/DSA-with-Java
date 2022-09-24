// Given an array arr[] of size N. The task is to find the first repeating element in the array of integers i.e., an
// element that occurs more than once and whose index of first occurrence is smallest.

import java.util.Scanner;

public class FirstRepeatingNumber {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt(), max = Integer.MIN_VALUE;
        int[] arr = new int[size];
        int[] idx;

        System.out.print("Enter the elements in the array");
        for (int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
            if (arr[i] > max)
                max = arr[i];
        }

        idx = new int[max + 1];
        for (int i = 0; i < max + 1; i++){
            idx[i] = -1;
        }

        for (int i = 0; i < size; i++){
            if (idx[arr[i]] != -1){
                System.out.println("The first repeating element is " + arr[i]);
                break;
            }
            else
                idx[arr[i]] = 1;
        }
    }
}
