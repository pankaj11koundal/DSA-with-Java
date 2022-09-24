import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentNumber {
    static class Pair {
        Integer element, freq;

        Pair(int element, int freq) {
            this.element = element;
            this.freq = freq;
        }
    }

    static class comparator implements Comparator<Pair>{
        public int compare(Pair str1, Pair str2) {
            return str1.freq.compareTo(str2.freq);
        }
    }

    static private int[] topKFrequentNumber(int[] arr, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new comparator());

        for (int value : arr) {
            m.put(value, m.getOrDefault(value, 0) + 1);
        }
        for (Integer i : m.keySet()) {
            pq.add(new Pair(i, m.getOrDefault(i, 0)));

            if(pq.size() > k)
                pq.poll();
        }
        int []frequencyNumber = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            frequencyNumber[i] = pq.poll().element;
            i++;
        }
        return frequencyNumber;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 2, 2, 4};
        int k = 2;

        int []frequentNumbers = topKFrequentNumber(arr, k);

        for (int i : frequentNumbers)
            System.out.print(i + " ");
    }
}
