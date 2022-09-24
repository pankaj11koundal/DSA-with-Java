import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathInWeightedDAG {
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static void findTopoSort(int node, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Pair>> ar) {
        visited[node] = true;

        for (Pair p : ar.get(node)) {
            if (!visited[p.node])
                findTopoSort(p.node, visited, st, ar);
        }

        st.push(node);
    }

    static int[] shortestPath(int n, int source, ArrayList<ArrayList<Pair>> ar) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];

        for (int i = 0; i <= n; i++)
            if(!visited[i])
                findTopoSort(i, visited, st, ar);
        distance[source] = 0;
        for (int i = 1; i <= n; i++)
            distance[i] = Integer.MAX_VALUE;

        while (!st.isEmpty()) {
            int node = st.pop();
            if (node != Integer.MAX_VALUE) {
                for (Pair p : ar.get(node)) {
                    if (distance[p.node] > distance[node] + p.weight)
                        distance[p.node] = distance[node] + p.weight;
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int n, m, u, v, w, source = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Pair>> ar = new ArrayList<>();
        int[] dis;
        for (int i = 0; i <= n; i++)
            ar.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the n node: ");
            u = sc.nextInt();
            System.out.println("Enter the v node: ");
            v = sc.nextInt();
            System.out.println("Enter the weight: ");
            w = sc.nextInt();

            Pair p = new Pair(v, w);
            ar.get(u).add(p);
        }

        for (int i = 0; i <= n; i++) {
            System.out.print(i + ": ");
            for (Pair p: ar.get(i)) {
                System.out.print(p.node + " " + p.weight);
            }
            System.out.println();
        }

        dis = shortestPath(n, source, ar);
        for (Integer i : dis) {
            System.out.print(i + " ");
        }
    }
}
