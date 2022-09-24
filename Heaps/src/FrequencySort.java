import java.util.PriorityQueue;
import java.util.HashMap;

public class FrequencySort {

    static class Pair {
        Integer element, freq;
        Pair(int element, int freq) {
            this.element = element;
            this.freq = freq;
        }
    }

    static int[] frequencySort(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer ele: arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.freq.compareTo(o1.freq));

        for (Integer key: map.keySet())
            pq.add(new Pair (key, map.getOrDefault(key, 0)));

        int i = 0;
        for (Pair p : pq) {
            while (p.freq > 0) {
                arr[i] = p.element;
                i++;
                p.freq--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 2, 2, 2, 4};

        int[] frequencySorted = frequencySort(arr);
        for (int ele : frequencySorted) {
            System.out.print(ele + " ");
        }
    }

}
