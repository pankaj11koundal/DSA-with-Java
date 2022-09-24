// Find whether exist 2 numbers that sum to an given number n
// NOTE: Array should be sorted for two pointer approach.

import java.util.Scanner;

public class PairTargetSumProblem {
    static Scanner sc = new Scanner(System.in);

    static int[] twoPointerApproach(int[] arr, int sum) {
        int []twoPointer = new int[2];
        int low = 0, high = arr.length - 1;

        while (low < high)
        {
            if (arr[low] + arr[high] == sum){
                twoPointer[0] = low;
                twoPointer[1] = high;
                return twoPointer;
            }
            else if (arr[low] + arr[high] > sum)
                high--;
            else
                low++;

        }
        return twoPointer;
    }

    public static void main(String[] args) {
        int size,sum;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the element in the array in sorted order");
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter the sum you want to find: ");
        sum = sc.nextInt();

        int[] pair = twoPointerApproach(arr, sum);
        for (int val : pair) {
            System.out.println(val);
        }
    }
}
