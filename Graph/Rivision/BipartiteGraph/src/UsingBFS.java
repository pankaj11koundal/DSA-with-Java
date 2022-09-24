import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class UsingBFS {
    static boolean checkBipartite(int n, ArrayList<ArrayList<Integer>> ar) {
        Queue<Integer> q = new LinkedList<>();
        int[] coloured = new int[n + 1];

        for (int i = 0; i <= n; i++)
            coloured[i] = -1;

        for (int i = 1; i <= n; i++) {
            if (coloured[i] == -1) {
                coloured[i] = 0;

                for (Integer node: ar.get(i)) {
                    coloured[node] = 1;
                    q.add(node);
                }
            }

            while (!q.isEmpty()) {
                int node = q.poll();

                for (Integer j: ar.get(node)) {
                    if (coloured[j] == -1) {
                        coloured[j] = Math.abs(coloured[node] - 1);
                        q.add(j);
                    }
                    else if (coloured[j] == coloured[node])
                        return false;
                }
            }
        }
        return true;
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

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
            ar.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            for (Integer node: ar.get(i))
                System.out.print(node + " ");
            System.out.println();
        }

        if (checkBipartite(n, ar))
            System.out.println("The given graph is bipartite");
        else
            System.out.println("The given graph is not bipartite");
    }
}
