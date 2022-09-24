import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class TopoSortUsingDFS {

    static Scanner sc = new Scanner(System.in);

    static void createAdjacenyList(ArrayList<ArrayList<Integer>> adj, int n, int m){
        int u, v;
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0 ;i < m; i++){
            System.out.print("Enter the vertex ");
            u = sc.nextInt(); +
            System.out.print("Enter the adjacent vertex: ");
            v = sc.nextInt();

            adj.get(u).add(v);
        }
    }

    static void printAdjacenyList(ArrayList<ArrayList<Integer>> adj, int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st){
        visited[node] = true;
        for (Integer i: adj.get(node))
            if (!visited[i])
                dfs(i, adj, visited, st);

        st.push(node);
    }

    static void findTopoSort(ArrayList<ArrayList<Integer>> adj, int n, ArrayList<Integer> toposort){
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];

        for (int i = 0 ; i < n; i++){
            if (!visited[i]){
                dfs(i, adj, visited, st);
            }
        }

        while (!st.empty()){
            toposort.add(st.pop());
        }
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n, m;

        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<Integer> topoSort = new ArrayList<>();

        createAdjacenyList(adj, n + 1, m);
        printAdjacenyList(adj, n + 1);

        findTopoSort(adj, n + 1, topoSort);

        for (Integer i: topoSort)
            System.out.print(i + " ");
    }
}
	