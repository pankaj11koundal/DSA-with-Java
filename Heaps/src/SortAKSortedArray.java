import java.util.PriorityQueue;

public class SortAKSortedArray {
    private static int[] sortingKSortedArray(int[] arr, int k) {
        if (arr.length < k) {
            return arr;
        } else {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            int[] sortingArray = new int[arr.length];
            int index = 0;
            for (int value : arr) {
                heap.add(value);

                if (!heap.isEmpty() && heap.size() > k) {
                    sortingArray[index] = heap.poll();
                    index++;
                }
            }

            while (!heap.isEmpty())
//                System.out.println(heap.peek());
                sortingArray[index++] = heap.poll();
            return sortingArray;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        int [] sortedArray = sortingKSortedArray(arr, k);
        for (int ele: sortedArray)
            System.out.print(ele + " ");
    }
}
