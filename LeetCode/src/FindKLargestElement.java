import java.util.Collections;
import java.util.PriorityQueue;

public class FindKLargestElement {
    private static int findKLargestElement(int[] arr, int k) {
        if (arr.length < k) {
            return -1;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
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
        int k = 2;

        System.out.println(findKLargestElement(arr, k));

    }
}
