import java.util.Scanner;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        int n, m, u, v;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        int[][] adjacencyMatrix = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.println("Enter the v vertex: ");
            v = sc.nextInt();

            adjacencyMatrix[u][v] = 1;
            adjacencyMatrix[v][u] = 1;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++)
                System.out.print(adjacencyMatrix[i][j] + " ");
            System.out.println();
        }
    }
}
