import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestElement {
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

    public static void main(String[] args) {
        int [] arr = {7, 10, 4, 20, 15};
        int k = 3;

        System.out.println(findKSmallestElement(arr, 4));

    }
}
