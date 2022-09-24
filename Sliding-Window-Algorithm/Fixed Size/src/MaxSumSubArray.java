// Java program to find the largest sum of the sub arrays of size k
// IP: arr = [2, 3, 5, 2, 9, 7, 1], k = 3
// OP: 18

import java.util.Scanner;

public class MaxSumSubArray {
    static Scanner sc = new Scanner(System.in);

    static int findMaximumSumSubArray(int[] arr, int n, int k) {
        int i = 0, j = 0, sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (j < n) {
            sum += arr[j];
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i];
                i++;
            }
            j++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int n;
        System.out.print("Enter the size of the array: ");
        n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k;
        System.out.print("Enter the size of sub array: ");
        k = sc.nextInt();

        System.out.println("The maximum sum in the sub arrays of size k is " + findMaximumSumSubArray(arr, n, k));
    }
}
