import java.util.Scanner;
import java.util.ArrayList;
public class BruteForce {
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int[] findMST(int source, ArrayList<ArrayList<Pair>> ar, int n) {
        boolean[] mst = new boolean[n + 1];
        int[] key = new int[n + 1];
        int[] parent = new int[n + 1];
        int node;
        for (int i = 0; i <= n; i++) {
            mst[i] = false;
            parent[i] = -1;
            key[i] = Integer.MAX_VALUE;
        }

        key[source] = 0;

        for (int i = 0; i < n; i++) {
            node = Integer.MAX_VALUE;
            for (int j = 0; j <= n; j++)
                if (key[i] < node) {
                    node = i;
                }

            for (Pair it : ar.get(node))
                if (!mst[it.node] && key[it.node] > it.weight) {
                    key[it.node] = it.weight;
                    parent[it.node] = node;
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

            for (int i: mst) System.out.print(i + " ");
    }
}
