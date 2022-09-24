import java.util.*;

public class CycleDetectionInUndirectedGraphUsingBFS {
    public static void main(String[] args) {
        int n, m, u, v, node, prev = 0;
        boolean cycle = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++)
            ar.add(new ArrayList<>());

        for (int i = 1; i <= m; i++) {
            System.out.print("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
            ar.get(v).add(u);
        }

        System.out.println("Adjacency Matrix: ");
        for (int i = 1; i <= n; i++){
            System.out.print(i + ": ");
            for (Integer j: ar.get(i))
                System.out.print(j + " ");
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                prev = i;
                for (Integer j : ar.get(i))
                    q.offer(j);
            }

            while(!q.isEmpty()) {
                node = q.poll();
                visit[node] = true;
                for (Integer j : ar.get(node))
                    if (!visit[j]) {
                        for (Integer k : ar.get(prev))
                            if (Objects.equals(k, j)) {
                                cycle = true;
                                break;
                            }
                        q.add(j);
                    }
                prev = node;
            }
        }

        if (cycle) System.out.println("Cycle detected"); else System.out.println("Cycle not detected");
    }
}
