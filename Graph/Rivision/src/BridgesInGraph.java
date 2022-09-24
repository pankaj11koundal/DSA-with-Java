import java.util.ArrayList;
import java.util.Scanner;
public class BridgesInGraph {
    static class Bridge {
        int u;
        int v;

        Bridge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static void getBridge(Integer node, int parent, boolean[] visited, int[] iniT, int[] lowT, Integer timer, ArrayList<ArrayList<Integer>> ar, ArrayList<Bridge> bridges) {
        visited[node] = true;
        iniT[node] = lowT[node] = timer++;
        for (Integer it: ar.get(node)) {
            if (it == parent) continue;

            if (!visited[it]) {
                getBridge(it, node, visited, iniT, lowT, timer, ar, bridges);
                lowT[node] = Math.min(lowT[node], lowT[it]);
                if (lowT[it] > iniT[node]) bridges.add(new Bridge(node, it));
            } else {
                lowT[node] = Math.min(iniT[it] , lowT[node]);
            }
        }
    }

    static ArrayList<Bridge> findBridges(ArrayList<ArrayList<Integer>> ar, int n) {
        int[] iniT = new int[n + 1];
        int[] lowT = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int parent = -1;
        Integer timer = 1;
        ArrayList<Bridge> bridges = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            if (!visited[i]) {
                getBridge(i, parent, visited, iniT, lowT, timer, ar, bridges);
            }
        }

        return bridges;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, u, v;

        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        ArrayList<Bridge> bridges;

        for (int i = 0; i <= n; i++)    ar.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
            ar.get(v).add(u);
        }

        bridges = findBridges(ar, n);

        for (Bridge b : bridges) {
            System.out.println(b.u + " -> " + b.v);
        }
    }

}
