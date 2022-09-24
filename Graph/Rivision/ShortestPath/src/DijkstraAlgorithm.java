// Dijkstra Algorithm is used to find the shortest distance from source
// to each node in a weighted un-directional graph.

import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class DijkstraAlgorithm {
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
    static int[] dijkstraAlgorithm(int source, ArrayList<ArrayList<Pair>> ar, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair());

        pq.add(new Pair(source, 0));

        int[] dis = new int[n + 1];

        for (int i = 0; i <= n; i++)
            dis[i] = Integer.MAX_VALUE;

        dis[source] = 0;

        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            for (Pair it: ar.get(node.node))
                if (it.weight + node.weight < dis[it.node]) {
                    dis[it.node] = it.weight + node.weight;
                    pq.add(new Pair(it.node, it.weight + node.weight));
                }
        }

        return dis;
    }
    public static void main(String[] args) {
        int n, m, u, v, w, source = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Pair>> ar = new ArrayList<>();
        int[] shortestPath;
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
        shortestPath = dijkstraAlgorithm(source, ar, n);

        for (int i : shortestPath) System.out.print(i + " ");
    }
}
