import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
public class BreadthFirstSearch {
    public static void main(String[] args) {
        int n, m, u, v;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[] visit = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0 ; i <= n; i++)
            arr.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            System.out.println("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.println("Enter the v vertex");
            v = sc.nextInt();

            arr.get(u).add(v);
            arr.get(v).add(u);
        }

        System.out.println("Adjacency List: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(i + ": ");
            for (Integer j : arr.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n + 1; i++)
            visit[i] = 0;

        System.out.println("Traversal of the graph: ");
        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                q.addAll(arr.get(i));
                System.out.println(i);
            }

            while (!q.isEmpty()) {
                int node = q.poll();
                visit[node] = 1;
                System.out.println(node);
                for (Integer j : arr.get(node)) {
                    if (!j.equals(q.peek()) && visit[j] == 0)
                        q.add(j);
                }
            }
        }
    }
}
