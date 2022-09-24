import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
public class KruskalSAlgorithm {
    static class Edge {
        int u;
        int v;
        int weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class ComparatorSort implements Comparator<Edge> {
        public int compare(Edge e1, Edge e2) {
            return Integer.compare(e1.weight, e2.weight);
        }
    }

    static int findParent(int node, int[] parent) {
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node], parent);
    }

    static void union(int u, int v, int[] parent, int[] rank) {
        u = findParent(u, parent);
        v = findParent(v, parent);

        if (rank[u] < rank[v])
            parent[u] = v;
        else if (rank[u] > rank[v])
            parent[v] = u;
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

    static int kruskalSAlgorithm(ArrayList<Edge> ar, int n, ArrayList<Edge> mst) {
        ar.sort(new ComparatorSort());
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        int minMst = 0;

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (Edge e: ar) {
            if (findParent(e.u, parent) != findParent(e.v, parent)) {
                minMst += e.weight;
                mst.add(e);
                union(e.u, e.v, parent, rank);
            }
        }

        return minMst;
    }

    public static void main(String[] args) {
        int m, u, v, weight, minMST, n;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();
        System.out.println("Enter the number of nodes: ");
        n = sc.nextInt();

        ArrayList<Edge> ar = new ArrayList<>();
        ArrayList<Edge> mst = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            System.out.print("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the v vertex: ");
            v = sc.nextInt();
            System.out.print("Enter the weight: ");
            weight = sc.nextInt();
            ar.add(new Edge(u, v, weight));
        }

        minMST = kruskalSAlgorithm(ar, n, mst);
        System.out.println(minMST);

        for (Edge e: mst)
            System.out.println(e.u + " -> " + e.v);
    }
}
