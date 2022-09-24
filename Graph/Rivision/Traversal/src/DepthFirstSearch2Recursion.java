import java.util.Scanner;
import java.util.ArrayList;

public class DepthFirstSearch2Recursion {

    static void dfs(int i, boolean[] visit, ArrayList<ArrayList<Integer>> ar, ArrayList<Integer> dfsTraversal) {
        visit[i] = true;
        dfsTraversal.add(i);
        for (Integer j : ar.get(i)) {
            if (!visit[j]) {
                dfs(j, visit, ar, dfsTraversal);
            }
        }
    }

    static ArrayList<Integer> dfsTraverse(ArrayList<ArrayList<Integer>> ar, int n) {
        ArrayList<Integer> dfsTraversal = new ArrayList<>();
        boolean[] visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++)
            if (!visit[i])  dfs(i, visit, ar, dfsTraversal);
        return dfsTraversal;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, u, v;

        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        ArrayList<Integer> dfsTraversal;

        for (int i = 0; i <= n; i++)    ar.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
            ar.get(v).add(u);
        }

        dfsTraversal = dfsTraverse(ar, n);

        for (Integer node: dfsTraversal) System.out.print(node + " ");
    }
}

