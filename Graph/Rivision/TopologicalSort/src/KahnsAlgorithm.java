// Kahn's Algorithm is used to find the topological ordering of a graph using BFS traversal
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Scanner;
public class KahnsAlgorithm {
    public static void main(String[] args) {
        int n, m, u, v;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        ArrayList<Integer> topoSort = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] ct = new int[n + 1];

        for (int i = 0; i < n; i++)
            ar.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (Integer node: ar.get(i))
                System.out.print(node + " ");
            System.out.println();
        }

        for (int i = 0; i < n; i++)
            for (Integer it: ar.get(i))
                ct[it]++;

        for (int i = 0; i < n; i++)
            if (ct[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            Integer node = q.poll();
            topoSort.add(node);
            for (Integer it: ar.get(node)) {
                ct[it]--;
                if (ct[it] == 0)
                    q.add(it);
            }
        }

        for (Integer it: topoSort)
            System.out.print(it + " ");
    }
}
