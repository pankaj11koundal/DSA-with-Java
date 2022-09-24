import java.util.Scanner;
import java.util.ArrayList;
public class CycleDetectionDirectedGraphDFS  {
    static boolean isCycle(int node, boolean[] visited, boolean[] dfs, ArrayList<ArrayList<Integer>> ar) {
        visited[node] = true;
        dfs[node] = true;

        for (Integer i: ar.get(node)) {
            if (!visited[i]) {
                if (isCycle(i, visited, dfs, ar)) return true;
            }
            else if (dfs[i]) return true;
        }

        dfs[node] = false;
        return false;
    }
    static boolean detectCycle(int n, ArrayList<ArrayList<Integer>> ar) {
        boolean[] visited = new boolean[n + 1];
        boolean[] dfs = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if(isCycle(i, visited, dfs, ar)) return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int n, m, u, v;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            ar.add(new ArrayList<>());

        for (int i = 1; i <= m; i++) {
            System.out.println("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.println("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            for (Integer node: ar.get(i))
                System.out.print(node + " ");
            System.out.println();
        }

        if (detectCycle(n, ar)) System.out.println("Cycle is detected"); else System.out.println("Cycle is not detected");
    }
}
