import java.util.Comparator;
import java.util.PriorityQueue;

public class Practice {
    static class Pair {
        Integer val;

        Pair(Integer val) {
            this.val = val;
        }
    }

    static class comparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            System.out.print(p1.val + " " + p2.val + " " + pq.peek().val + ": " + p1.val.compareTo(p2.val));
            System.out.println();
            return p1.val.compareTo(p2.val);
        }
    }

    static PriorityQueue<Pair> pq = new PriorityQueue<>(new comparator());

    public static void main(String[] args) {
        Pair p1 = new Pair(1);
        Pair p2 = new Pair(2);
        Pair p3 = new Pair(3);


        pq.add(p1);
        for (Pair p :pq)
            System.out.print(p.val + " ");
        System.out.println(pq.peek().val);
        System.out.println();
        pq.add(p2);
        for (Pair p :pq)
            System.out.print(p.val + " ");
        System.out.println(pq.peek().val);
        System.out.println();
        pq.add(p3);
        for (Pair p :pq)
            System.out.print(p.val + " ");
        System.out.println(pq.peek().val);
        System.out.println();
    }
}
