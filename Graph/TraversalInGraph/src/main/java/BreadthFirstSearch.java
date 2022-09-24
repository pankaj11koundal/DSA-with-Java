import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstSearch {  
    static Scanner sc = new Scanner(System.in);
    
    static void AdjacentryList(ArrayList<ArrayList<Integer>> adj, int n, int m){
        int u, v;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            System.out.print("Enter the vertice: ");
            u = sc.nextInt();
            System.out.print("Enter the adjacent vertice: ");
            v = sc.nextInt();
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
    
    static ArrayList<Integer> bFS(boolean visited[], ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i < visited.length; i++){
            if(!visited[i])
            {
                q.add(i);
                visited[i] = true;
            
                while(!q.isEmpty()){
                    int node = q.poll();
                    bfs.add(node);
                
                    for(Integer j: adj.get(node)){
                        if(!visited[j]){
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        
        return bfs;
        
        
    }
    
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> bfs;
        int n, m;
        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        m = sc.nextInt();
        
        boolean[] visited = new boolean[n + 1];
        AdjacentryList(adj, n + 1, m);
        
        
        for(int i = 0; i < n + 1; i++){
            visited[i] = false;
        }
        
        bfs = bFS(visited, adj);
        
        for(Integer j: bfs){
            System.out.print(j + " ");
        }
    }
}
