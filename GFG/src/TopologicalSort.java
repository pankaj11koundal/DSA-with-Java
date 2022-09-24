import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {
    static class Solution {
        void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
            visited[node] = true;

            for (Integer i: adj.get(node))
                if (!visited[i]) dfs(i, visited, adj, st);

            st.push(node);
        }
        ArrayList<Integer> topologicalSort(int n, ArrayList<ArrayList<Integer>> adj) {
            Stack<Integer> st = new Stack<>();
            boolean[] visited = new boolean[n];
            ArrayList<Integer> topoSort = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (!visited[i])
                    dfs(i, visited, adj, st);
            }

            while(!st.isEmpty()) topoSort.add(st.pop());

            return topoSort;
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
        }

        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (Integer node: ar.get(i))
                System.out.print(node + " ");
            System.out.println();
        }

        Solution s = new Solution();
        System.out.println(s.topologicalSort(n, ar));
    }
}
