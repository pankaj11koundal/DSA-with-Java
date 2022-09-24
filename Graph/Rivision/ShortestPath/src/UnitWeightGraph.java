import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class UnitWeightGraph {
    public static void main(String[] args) {
        int n, m, u, v;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        int[] dist = new int[n + 1];

        for (int i = 0; i <= n; i++)
            ar.add(new ArrayList<>());

        for (int i = 1; i <= m; i++) {
            System.out.print("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
            ar.get(v).add(u);
        }

        System.out.println("Adjacency Matrix: ");
        for (int i = 0; i <= n; i++){
            System.out.print(i + ": ");
            for (Integer j: ar.get(i))
                System.out.print(j + " ");
            System.out.println();
        }

        for (int i = 0; i <= n; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[0] = 0;
        visit[0] = true;

        for (Integer node: ar.get(0)) {
            q.add(node);
            visit[node] = true;
            dist[node] = 1;
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            for (Integer it: ar.get(node)) {
                if (!visit[it]) {
                    visit[it] = true;
                    q.add(it);
                    dist[it] = dist[node] + 1;
                } else if (dist[it] > dist[node] + 1)
                    dist[it] = dist[node] + 1;
            }
        }

        for (int i = 0; i <= n; i++)
            System.out.print(dist[i] + " ");
    }
}