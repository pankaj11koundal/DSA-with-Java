import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
public class CycleDetectionDirectedGraphBFS {
    public static void main(String[] args) {
        int n, m, u, v, count = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] ct = new int[n];

        for (int i = 0; i < n; i++)
            ar.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            System.out.println("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.println("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (Integer node: ar.get(i))
                System.out.print(node + " ");
            System.out.println();
        }

        for (int i = 0; i < n; i++)
            for (Integer it: ar.get(i))
                ct[it]++;

        for (int i: ct)
            if (i == 0)
                q.add(i);


        while (!q.isEmpty()) {
            Integer node = q.poll();
            count++;
            for (Integer it: ar.get(node)) {
                ct[it]--;
                if (ct[it] == 0)
                    q.add(it);
            }
        }

        if (count == n) System.out.println("No cycle is detected"); else System.out.println("Cycle is detected");
    }
}
