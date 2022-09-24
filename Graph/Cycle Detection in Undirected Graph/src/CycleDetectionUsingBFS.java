import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionUsingBFS {
    static Scanner sc = new Scanner(System.in);

    static class Node{
        int first;
        int second;

        Node(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

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
        for (int i = 0; i < n; i++){
            for (int j = 0; j < adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    static boolean checkForCycle(int s,  boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, -1));
        visited[s] = true;

        while(!q.isEmpty()){
            int node = q.peek().first;
            int prev = q.peek().second;
            q.remove();

            for (Integer i: adj.get(node)){
                if (!visited[i]){
                    q.add(new Node(i, node));
                    visited[i] = true;
                }
                else if (i != prev){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean detectCycle(int n, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            visited[i] = false;
        }

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                if(checkForCycle(i, visited, adj)){
                    return true;
                }
            }
        }

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

        printAdjacencyList(n+1, adj);

        if(detectCycle(n + 1, adj)){
            System.out.println("Cycle detected");
        }
        else
            System.out.println("Cycle not detected");
    }
}
