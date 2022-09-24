import java.util.Scanner;
import java.util.ArrayList;

public class CycleDetectionUsingDFS {
    static Scanner sc = new Scanner(System.in);

    static void createAdjacencyList(int n, int m, ArrayList<ArrayList<Integer>> adj){
        int u, v;
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++){
            System.out.print("Enter the value of vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the adjacent vertex: ");
            v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    static void printAdjacencyMatrix(int n, ArrayList<ArrayList<Integer>> adj){
        for (int i = 1; i < n; i++){
            for (Integer j: adj.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static boolean checkCycle(int i, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[i] = true;
        for (Integer j:  adj.get(i)){
            if (!visited[j]){
                if (checkCycle(j, i, visited, adj))
                    return true;
            }
            else if(j != parent){
                return true;
            }
        }
        return false;
    }

    static boolean detectCycle(int n, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++)
            if (!visited[i])
                if (checkCycle(i, -1, visited, adj))
                    return true;

        return false;
    }

    public static void main(String[] args){
        int n, m;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        m = sc.nextInt();

        createAdjacencyList(n + 1, m, adj);
        printAdjacencyMatrix(n + 1, adj);

        if (detectCycle(n + 1, adj))
            System.out.println("Cycle detected");
        else
            System.out.println("Cycle not detected");
    }
}
