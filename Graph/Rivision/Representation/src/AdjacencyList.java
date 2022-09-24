import java.util.Scanner;
import java.util.ArrayList;
public class AdjacencyList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, u, v;
        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            System.out.println("Enter the vertex u: ");
            u = sc.nextInt();
            System.out.println("Enter the vertex v: ");
            v = sc.nextInt();

            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        for (int i = 0; i <= n; i++) {
            System.out.print(i + ": ");
            for (Integer j: adjacencyList.get(i))
                System.out.print(j + " ");
            System.out.println();
        }
    }
}
