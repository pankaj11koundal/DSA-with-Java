// Java program to find the maximum element in the sub array of size k

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class MaximumInSubArrayK {

    static ArrayList<Integer> findMaxInSubArray(int[] arr, int k) {
        int i = 0, j = 0;
        ArrayList<Integer> ar = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        while (j < arr.length) {
            while (!q.isEmpty() && q.peek() < arr[j])
                q.remove();

            q.add(arr[j]);

            if (j - i + 1 == k) {
                ar.add(q.peek());
                if (!q.isEmpty() && q.peek() == arr[i])
                    q.remove();

                i++;
            }

            j++;
        }

        return ar;
    }


    public static void main(String[] args) {

        int []arr = {};
        System.out.println("The largest element in the sub-array of size k is " + findMaxInSubArray(arr, 3));
    }
}
