import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class UsingBFS {
    static Scanner sc = new Scanner(System.in);

    static void createAdjacencyList(int n, int m, ArrayList<ArrayList<Integer>> adj){
        int u, v;

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++){
            System.out.print("Enter the vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the adjacent vertex: ");
            v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    static void printAdjacencyList(int n, ArrayList<ArrayList<Integer>> adj){
        for (int i = 0; i < n; i++) {
            for (Integer j : adj.get(i))
                System.out.print(j + " ");

            System.out.println();
        }
    }

    static boolean checkBfs(int node, int[] color, ArrayList<ArrayList<Integer>> adj){
        color[node] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){

            Integer nde = q.poll();

            for (int i : adj.get(nde)) {
                if (color[i] == -1) {
                    q.add(i);
                    color[i] = 1 - color[nde];
                }
                else if (color[i] == color[nde]){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkBipartite(int n, ArrayList<ArrayList<Integer>> adj){
        int[] color = new int[n];

        for (int i = 0; i < n; i++)
            color[i] = -1;

        for (int j = 0; j < n; j++) {
            if(color[j] == -1){
                if(!checkBfs(j, color, adj)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int n, m;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        m = sc.nextInt();

        createAdjacencyList(n + 1, m, adj);
        printAdjacencyList(n + 1, adj);

        if (checkBipartite(n + 1, adj)) System.out.println("Graph is bipartite ");
        else System.out.println("Graph is not a bipartite");
    }
}
