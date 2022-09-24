import java.util.Scanner;
import java.util.ArrayList;
public class CycleDetectionInUndirectedGraphDFS {

    static boolean isCycle(int cur, int prev, boolean[] visited, ArrayList<ArrayList<Integer>> ar) {
        visited[cur] = true;
        for (Integer node: ar.get(cur)) {
            if (!visited[node]) {
                if (isCycle(node, cur, visited, ar))
                    return true;
            }
            else if (prev != node) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n, m, u, v;
        boolean cycle = false;

        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();

        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++)
            ar.add(new ArrayList<>());


        for (int i = 1; i <= m; i++) {
            System.out.println("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.println("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
            ar.get(v).add(u);
        }

        System.out.println("Adjacency Matrix: ");
        for (int i = 1; i <= n; i++){
            System.out.print(i + ": ");
            for (Integer j: ar.get(i))
                System.out.print(j + " ");
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cycle = isCycle(i, -1, visited, ar);
            }
        }

        if (cycle) System.out.println("Cycle is detected"); else System.out.println("Cycle is not detected");
    }
}
