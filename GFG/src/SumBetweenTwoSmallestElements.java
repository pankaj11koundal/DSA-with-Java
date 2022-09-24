//Given an array A[] of N positive integers and two positive integers K1 and K2.
// Find the sum of all elements between K1th and K2th smallest elements of the array.
// It may be assumed that (1 <= k1  k2 <= n).

import java.util.Collections;
import java.util.PriorityQueue;

public class SumBetweenTwoSmallestElements {
    private static int findKSmallestElement(int[] arr, int k) {
        if (arr.length < k) {
            return -1;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);

            if (heap.size() > k)
                heap.poll();
        }
        if (!heap.isEmpty())
            return heap.peek();

        return -1;
    }

    private static int findSumOfElementsBetween(int[] arr, int k1, int k2) {
        int k1Small = findKSmallestElement(arr, k1);
        int k2Small = findKSmallestElement(arr, k2);
        int sum = 0;
        for (int value : arr)
            if (k1Small <= value && value <= k2Small)
                sum += value;

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 5, 15, 11};
        int k1 = 3, k2 = 6;
        int length = findSumOfElementsBetween(arr, k1, k2);
        System.out.println(length);
    }
}

