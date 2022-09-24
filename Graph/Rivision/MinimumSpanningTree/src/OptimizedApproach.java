import java.util.*;

public class OptimizedApproach {

    static class Pair implements Comparator<Pair> {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        Pair() {}
        public int compare(Pair o1, Pair o2) {
            return Integer.compare(o1.weight, o2.weight);
        }
    }

    static int[] findMST(int source, ArrayList<ArrayList<Pair>> ar, int n) {
        int []parent = new int[n + 1];
        boolean []mst = new boolean[n + 1];
        int []key = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            mst[i] = false;
            parent[i] = -1;
            key[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(n, new Pair());

        key[0] = 0;
        pq.add(new Pair(source, key[0]));
        int u;

        for (int i = 0; i < n; i++) {
            u = pq.poll().node;
            mst[u] = true;

            for (Pair it: ar.get(u)) {
                if (!mst[it.node] && key[it.node] > it.weight) {
                    parent[it.node] = u;
                    key[it.node] = it.weight;
                    pq.add(new Pair(it.node, key[it.node]));
                }
            }
        }

        return parent;
    }

    public static void main(String[] args) {
        int n, m, u, v, w, source = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Pair>> ar = new ArrayList<>();
        int[] mst;
        for (int i = 0; i <= n; i++)
            ar.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the u node: ");
            u = sc.nextInt();
            System.out.print("Enter the v node: ");
            v = sc.nextInt();
            System.out.print("Enter the weight: ");
            w = sc.nextInt();

            Pair p = new Pair(v, w);
            ar.get(u).add(p);

        }
        mst = findMST(source, ar, n);

        for (int i : mst) System.out.print(i + " ");
    }
}
