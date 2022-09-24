import java.util.ArrayList;
import java.util.Scanner;
public class DepthFirstSearch {
    static Scanner sc = new Scanner(System.in);

    static void createAdjacent(int n, int m, ArrayList<ArrayList<Integer>> adj){
        int u, v;

        for (int i = 0; i < n + 1; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++){
            System.out.print("Enter the vertices: ");
            u = sc.nextInt();
            System.out.print("Enter the adjacent vertices: ");
            v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    static void dfsTraversal(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> traversal){
        visited[node] = true;
        traversal.add(node);

        for (Integer i : adj.get(node)) {
            if(!visited[i]){
                dfsTraversal(i, visited, adj, traversal);
            }
        }
    }

    public static void main(String[] args){
        int n, m;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> traversal = new ArrayList<>();

        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        m = sc.nextInt();
        boolean [] visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++){
            visited[i] = false;
        }

        createAdjacent(n + 1, m, adj);

        for (int i = 0; i < n+1; i++){
            if (!visited[i]){
                dfsTraversal(i, visited, adj, traversal);
            }
        }

        for (Integer i: traversal) {
            System.out.print(i + " ");
        }
    }
}
