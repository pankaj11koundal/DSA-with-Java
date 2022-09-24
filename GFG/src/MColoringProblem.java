import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {

    static  class solve
    {
        private  boolean isSafe(int node,List<Integer>[] G,int [] color,int n,int col){
            for(int it:G[node]){
                if(color[it]==col)
                    return false;
            }
            return true;
        }
        private  boolean solve(int node,List<Integer>[]G,int [] color,int n,int C){
            if(node==n)
                return true;

            for(int i=1;i<=C;i++){
                if(isSafe(node,G,color,n,i)){
                    color[node]=i;
                    if(solve(node+1,G,color,n,C)==true)
                        return true;
                    color[node]=0;
                }
            }
            return false;
        }
        //Function to determine if graph can be coloured with at most M colours such
        //that no two adjacent vertices of graph are coloured with same colour.
        public boolean graphColoring(List<Integer>[] G, int [] color, int i, int C)
        {
            // Your code here
            int n = G.length;
            if(solve(0,G,color,n,C)==true)
                return true;
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, m, u, v;
        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        m = sc.nextInt();
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i <= n ; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the adjacent vertex : ");
            v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= adj[i].size(); j++) {
                System.out.print(adj[i].get(j) + " ");
            }
            System.out.println();
        }
        int [] color = new int[n];

        solve s = new solve();
        System.out.println(s.solve(0, adj, color, 1, n));

    }
}
