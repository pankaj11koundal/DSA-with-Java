import java.util.PriorityQueue;

public class ConnectRopes {
    private static int lengthOfRopes(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int test = 0;
        for (int value : arr) {
            pq.add(value);
        }

        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();

            test += a + b;
            pq.add(a + b);
        }

        return test;
    }
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};

        int length = lengthOfRopes(arr);
        System.out.println(length);
    }
}
