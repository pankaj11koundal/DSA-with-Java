import java.util.ArrayList;
import java.util.Scanner;

public class BelmanFordAlgorithm {
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

    static int[] bellmanFordAlgorithm(ArrayList<Edge> edges, int n, int source) {
        int[] dis = new int[n];
        for (int i = 0; i < n; i++)
            dis[i] = Integer.MAX_VALUE;

        dis[source] = 0;

        for (int i = 1; i <= n - 1; i++) {
            for (Edge it: edges) {
                if (dis[it.u] + it.weight < dis[it.v])
                    dis[it.v] = dis[it.u] + it.weight;
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

        ArrayList<Edge> edges = new ArrayList<>();
        int[] shortestPath;

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the u node: ");
            u = sc.nextInt();
            System.out.print("Enter the v node: ");
            v = sc.nextInt();
            System.out.print("Enter the weight: ");
            w = sc.nextInt();

            edges.add(new Edge(u, v, w));
        }
        shortestPath = bellmanFordAlgorithm(edges, n, source);

        for (int i : shortestPath) System.out.print(i + " ");
    }
}
