import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
public class DepthFirstSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, u, v;

        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean [] visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++)    ar.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
            ar.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                System.out.print(i + " ");
                for (Integer j : ar.get(i)) st.push(j);
            }

            while (!st.isEmpty()) {
                int node = st.pop();
                if (!visit[node]) {
                    visit[node] = true;
                    System.out.print(node + " ");
                    for (Integer j : ar.get(node)) {
                        if (!visit[j])  st.push(j);
                    }
                }
            }
        }
    }
}
