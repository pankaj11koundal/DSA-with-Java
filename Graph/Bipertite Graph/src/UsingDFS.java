import java.util.Scanner;
import java.util.ArrayList;

public class UsingDFS {
    static Scanner sc = new Scanner(System.in);

    static void createAdjacencyList(int n, int m, ArrayList<ArrayList<Integer>> adj){
        int u, v;

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

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
        for (int i = 0; i < n; i++){
            for (Integer j: adj.get(i))
                System.out.print(j + " ");
            System.out.println();
        }
    }

    static boolean checkDFs(int node, int[] color, ArrayList<ArrayList<Integer>> adj){

        for (Integer i : adj.get(node))
            if (color[i] == -1){
                color[i] = 1 - color[node];
                checkDFs(i, color, adj);
            }
            else if (color[i] == color[node])
                return false;

        return true;
    }

    static boolean checkBipartite(int n, ArrayList<ArrayList<Integer>> adj){
        int[] color = new int[n];
        for (int i = 0; i < n; i++)
            color[i] = -1;

        for (int i = 0; i < n; i++)
            if (color[i] == -1) {
                color[i] = 1;
                if (!checkDFs(i, color, adj)) return false;
            }
        return  true;
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

        if (!checkBipartite(n + 1, adj)) System.out.println("Graph is not Bipartite");
        else System.out.println("Graph is Bipartite");
    }

}
