import java.util.Comparator;
import java.util.PriorityQueue;

class KClosestNumber {
    static class Pair {
        Integer key;
        Integer value;
        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    static private int[] kClosestNumber(int[] arr, int k, int x) {
        int []kClosestNumber = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                new Comparator<Pair>()
                {
                    public int compare(Pair p1, Pair p2)
                    {
                        return p2.value.compareTo(
                                p1.value);
                    }
                });

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(i, Math.abs(x - arr[i])));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int i = 0;
        while (!pq.isEmpty()) {
            kClosestNumber[i] = pq.poll().key;
            i++;
        }

        return kClosestNumber;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4, x = 3;

        int[] kClosestNumbers = kClosestNumber(arr, k, x);

        for (int ele: kClosestNumbers) {
            System.out.print(ele + " ");
        }
    }
}