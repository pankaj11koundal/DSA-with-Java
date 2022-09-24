// Program to find out the strongly connected components.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class KosarajuSAlgorithm {
    static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, Stack<Integer> st) {
        visited[i] = true;
        for (Integer node: adj.get(i))
            if (!visited[node])
                topologicalSort(adj, node, visited, st);

        st.push(i);
    }

    static void dfs(Integer i, boolean[] visited, ArrayList<ArrayList<Integer>> transposeGraph, ArrayList<Integer> ans) {
        visited[i] = true;
        ans.add(i);
        System.out.print(i + " ");

        for (Integer it: transposeGraph.get(i))
            if (!visited[it])
                dfs(it, visited, transposeGraph, ans);

    }

    static ArrayList<ArrayList<Integer>> kosarajuSAlgorithm(ArrayList<ArrayList<Integer>> adj, int n) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> transposeGraph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> css = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] topoSort = new int[n];
        int itr = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                topologicalSort(adj, i, visited, st);
        }

        while(!st.isEmpty()) {
            topoSort[itr++] = st.pop();
        }

        for (int i = 0; i < n; i++)
            transposeGraph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            visited[i] = false;
            for (Integer it: adj.get(i))
                transposeGraph.get(it).add(i);
        }

        for (Integer it: topoSort) {
            if (!visited[it]) {
                dfs(it, visited, transposeGraph, ans);
                css.add(ans);
                ans.clear();
                System.out.println();
            }
        }

        return css;
    }

    public static void main(String[] args) {
        int n, m, u, v;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            System.out.println("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.println("Enter the v vertex: ");
            v = sc.nextInt();

            adj.get(u).add(v);
        }

        ArrayList<ArrayList<Integer>> scc = kosarajuSAlgorithm(adj, n);
        for (ArrayList<Integer> ar : scc) {
            for (Integer it: ar) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}
