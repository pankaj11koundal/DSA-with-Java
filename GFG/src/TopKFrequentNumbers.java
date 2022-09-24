import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {
    static class Pair {
        Integer element, freq;

        Pair(int element, int freq) {
            this.element = element;
            this.freq = freq;
        }
    }

    static class comparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2) {
            if (p1.freq.compareTo(p2.freq) > 0)
                return 1;
            else if (p1.freq.compareTo(p2.freq) < 0)
                return -1;
            else if (p1.element > p2.element)
                return 1;
            else
                return -1;
        }
    }

    static private int[] topKFrequentNumber(int[] arr, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new comparator());
//        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int value : arr) {
            m.put(value, m.getOrDefault(value, 0) + 1);
        }
        for (Integer i : m.keySet()) {
            pq.add(new Pair(i, m.getOrDefault(i, 0)));

            if(pq.size() > k)
                pq.poll();
        }
        for (Pair ele: pq) {
            System.out.print(ele.element + " : " + ele.freq);
            System.out.println();
        }
        int []frequencyNumber = new int[k];
        int i = k - 1;
        while (!pq.isEmpty()) {
            frequencyNumber[i] = pq.poll().element;
            i--;
        }
        return frequencyNumber;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 2, 2, 4};
        int k = 2;

        int []frequentNumbers = topKFrequentNumber(arr, k);

        for (int i : frequentNumbers)
            System.out.print(i + " ");
    }
}
