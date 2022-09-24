// Given an array A[] of integers, sort the array according to frequency of elements.
// That is elements that have higher frequency come first.
// If frequencies of two elements are same, then smaller number comes first.

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Scanner;

public class FrequencySort {

    static class Pair {
        Integer element, freq;
        Pair(int element, int freq) {
            this.element = element;
            this.freq = freq;
        }
    }
    static class comparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            int val;
            if (p1.freq.compareTo(p2.freq) > 0)
                val = -1;
            else if (p1.freq.compareTo(p2.freq) < 0)
                val = 1;
            else {
                if (p1.element < p2.element)
                    val = -1;
                else
                    val = 1;
            }
            System.out.println(p1.element + ": " + p1.freq + "----" + p2.element + ": " + p2.freq + "===" +  val + ", " + pq.peek().element);
            System.out.println("Queue");
            for (Pair p : pq) {
                System.out.println(p.element + ": " + p.freq);
            }
            System.out.println();
            return val;
        }
    }

    static PriorityQueue<Pair> pq = new PriorityQueue<>(new comparator() {
    });

    static int[] frequencySort(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer ele: arr)
            map.put(ele, map.getOrDefault(ele, 0) + 1);

        System.out.println(map);

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
        Scanner sc = new Scanner(System.in);

        int T, n;
        T = sc.nextInt();
        int[][] output = new int[T][];

        for(int i = 0; i < T; i++) {
            n = sc.nextInt();
            int []arr = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = sc.nextInt();
            output[i] = frequencySort(arr);
        }

        for(int i = 0; i < T; i++) {
            for(int j = 0 ; j < output[i].length; j++){
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }

}

