import java.util.PriorityQueue;

public class ReturnKLargestElements {
    private static int[] returnKLargestElements(int[] arr, int k) {
        int[] largestElements = new int[k];
        if (arr.length > k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();

            for (int value : arr) {
                heap.add(value);

                if (heap.size() > k)
                    heap.poll();
            }

            int i = k - 1;
            while (!heap.isEmpty())
                largestElements[i--] = heap.poll();

            return largestElements;
        } else {
            return arr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;

        int[] largestElements = returnKLargestElements(arr, k);
        for (int ele : largestElements) {
            System.out.print(ele + " ");
        }
    }
}
