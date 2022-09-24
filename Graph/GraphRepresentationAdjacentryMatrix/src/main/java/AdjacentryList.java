
import java.util.*;
import java.util.Scanner;

public class AdjacentryList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        int n, m, u, v;
        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        m = sc.nextInt();

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the vertice: ");
            u = sc.nextInt();
            System.out.print("Enter the adjacent vertice: ");
            v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
