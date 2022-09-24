import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class UsingDFS {

    static void dfsTopoSort(int node, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> ar) {
        visited[node] = true;

        for (Integer it: ar.get(node))
            if (!visited[it])
                dfsTopoSort(it, visited, st, ar);

        st.push(node);
    }

    static ArrayList<Integer> findTopologicalSort(int n, ArrayList<ArrayList<Integer>> ar) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> topoSort = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            if (!visited[i])
                dfsTopoSort(i, visited, st, ar);
        }

        while(!st.isEmpty())
            topoSort.add(st.pop());

        return topoSort;
    }


    public static void main(String[] args) {
        int n, m, u, v;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        ArrayList<Integer> topoSort;

        for (int i = 0; i <= n + 1; i++)
            ar.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
        }

        topoSort = findTopologicalSort(n, ar);

        for (Integer it: topoSort)
            System.out.print(it + " ");
    }
}
