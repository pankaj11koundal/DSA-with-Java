// Find the maximum sum among all the sub-array that can be generated from given array using Kadane's Algorithm.

import java.util.Scanner;

public class Kadane_sAlgorithm {
    static Scanner sc = new Scanner(System.in);

    static int kadane_sAlgorithm(int[] arr){
        int max = Integer.MIN_VALUE, sum = 0;

        for (int value : arr) {
            sum += value;
            if (sum < 0)
                sum = 0;

            max = Integer.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args){
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int []arr = new int[size];
        System.out.print("Enter the elements in the array: ");
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        System.out.println("The largest sum is " + kadane_sAlgorithm(arr));

    }

}
