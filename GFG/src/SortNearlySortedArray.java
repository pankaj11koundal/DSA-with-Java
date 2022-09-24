import java.util.ArrayList;
import java.util.PriorityQueue;
public class SortNearlySortedArray {
    private static ArrayList<Integer> sortingKSortedArray(int[] arr, int k) {
        ArrayList<Integer> sortingArray = new ArrayList<>();
        if (arr.length >= k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int value : arr) {
                heap.add(value);

                if (!heap.isEmpty() && heap.size() > k) {
                    sortingArray.add(heap.poll());
                }
            }

            while (!heap.isEmpty())
                sortingArray.add(heap.poll());
        }
        return sortingArray;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        ArrayList<Integer> sortedArray = sortingKSortedArray(arr, k);
        for (int ele: sortedArray)
            System.out.print(ele + " ");
    }
}
