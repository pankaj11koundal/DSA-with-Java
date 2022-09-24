import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.*;

class KClosestNumber {
    static class Pair {
        Integer key;
        Integer value;
        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    static private List<Integer> kClosestNumber(int[] arr, int k, int x) {
        List<Integer> kClosestNumber = new ArrayList<>();
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

        while (!pq.isEmpty()) {
            kClosestNumber.add(arr[pq.poll().key]);
        }
        Collections.sort(kClosestNumber);
        return kClosestNumber;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4, x = 3;

        List<Integer> kClosestNumbers = kClosestNumber(arr, k, x);

        for (int ele: kClosestNumbers) {
            System.out.print(ele + " ");
        }
    }
}