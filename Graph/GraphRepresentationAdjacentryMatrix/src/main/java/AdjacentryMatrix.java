import java.util.Scanner;

public class AdjacentryMatrix {
       public static void main(String[] args){
           
           Scanner sc = new Scanner(System.in);
           
           int n, m, u, v;
           System.out.print("Enter the number of vertices: ");
           n = sc.nextInt();
           System.out.print("\nEnter the edges in the graph: ");
           m = sc.nextInt();
           int[][] adj = new int[n + 1][n + 1];
           
           for(int i = 0; i <= n; i ++){
               for(int j = 0; j <= n; j++){
                   adj[i][j] = 0;
               }
            }
           
           for(int i = 0; i < m; i++){
               System.out.print("\nEnter the node u");
               u = sc.nextInt();
               System.out.print("\nEnter the adjacent node of u");
               v = sc.nextInt();
               
               adj[u][v] = 1;
               adj[v][u] = 1;
           }
           
           System.out.println("Printing the adjacent matrix: ");
           for(int i = 0; i <= n; i++){
               for(int j = 0; j <=n ; j++){
                   System.out.print(adj[i][j] + " ");
               }
               System.out.println();
           }
       }
}
