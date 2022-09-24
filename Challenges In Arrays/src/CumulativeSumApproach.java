// Find the maximum sum among all the sub-array that can be generated from given array using cumulative sum approach.

import java.util.Scanner;

public class CumulativeSumApproach {
    static Scanner sc = new Scanner(System.in);

    static int cumulativeSum(int[] arr){
        int []cumulative = new int[arr.length];
        int sum , maxSum = Integer.MIN_VALUE;

        cumulative[0] = arr[0];

        for (int i = 1; i < arr.length; i ++)
            cumulative[i] += arr[i] + cumulative[i - 1];

        for (int i = 0; i < cumulative.length; i++)
            for (int j = 0; j <= i; j++){
                sum = cumulative[i] - cumulative[j];
                maxSum = Integer.max(sum, maxSum);
            }
        return maxSum;
    }

    public static void main(String[] args){
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int []arr = new int[size];
        System.out.print("Enter the elements in the array: ");
        for (int i=0; i < size; i++)
            arr[i] = sc.nextInt();

        System.out.println("The maximum sum in subarray is " + cumulativeSum(arr));
    }

}
