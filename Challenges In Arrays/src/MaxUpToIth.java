// In this problem we take an arary and try to find out the maximum element upto the ith index number in the array

import java.util.Scanner;

public class MaxUpToIth {
    static Scanner sc = new Scanner(System.in);

    static int findGreatestTillI(int[] arr, int pos){
        int greatest = arr[0];

        for (int i = 1; i < pos; i++){
            if (arr[i] > greatest){
                greatest = arr[i];
            }
        }

        return greatest;
    }

    public static void main(String[] args) {
        int size, pos;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int[] arr = new int[size];
        System.out.print("Enter the elements in the array: ");
        for (int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the position up to which you want to find the greatest element: ");
        pos = sc.nextInt();

        System.out.println(findGreatestTillI(arr, pos));
    }
}
