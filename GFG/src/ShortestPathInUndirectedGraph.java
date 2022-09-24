import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathInUndirectedGraph {
    static class Solution {
        int[] shortestPath(ArrayList<ArrayList<Integer>> ar, int n) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n];
            int[] distance = new int[n];

            for (int it: distance) it = Integer.MAX_VALUE;

            distance[0] = 0;
            visited[0] = true;

            for(Integer it: ar.get(0)) {
                distance[it] = Math.max(distance[0], distance[it] + 1);
                q.add(it);
                visited[it] = true;
            }

            while (!q.isEmpty()) {
                int node = q.poll();
                for (Integer i: ar.get(node)) {
                    if (!visited[node]) {
                        distance[i] = Math.max(distance[node] + 1, distance[i]);
                        q.add(i);
                        visited[i] = true;
                    } else if (distance[node] + 1 > distance[i])
                        distance[i] = distance[node] + 1;
                }
            }

            return distance;
        }
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
            ar.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (Integer node: ar.get(i))
                System.out.print(node + " ");
            System.out.println();
        }

        Solution s = new Solution();
        int[] distance = s.shortestPath(ar, n);

        for (int dis: distance) System.out.print(dis + " ");
    }
}
