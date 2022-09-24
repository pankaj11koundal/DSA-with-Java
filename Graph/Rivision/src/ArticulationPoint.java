import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
public class ArticulationPoint {

    static void getArticulationPoints(Integer node, int parent, boolean[] visited, int[] iniT, int[] lowT, Integer timer, ArrayList<ArrayList<Integer>> ar, Set<Integer> bridges) {
        visited[node] = true;
        iniT[node] = lowT[node] = timer++;
        for (Integer it: ar.get(node)) {
            if (it == parent) continue;

            if (!visited[it]) {
                getArticulationPoints(it, node, visited, iniT, lowT, timer, ar, bridges);
                lowT[node] = Math.min(lowT[node], lowT[it]);
                if (lowT[it] > iniT[node]) {
                    bridges.add(it);
                    bridges.add(node);
                }
            } else {
                lowT[node] = Math.min(iniT[it] , lowT[node]);
            }
        }
    }

    static ArrayList<Integer> findArticulationPoints(ArrayList<ArrayList<Integer>> ar, int n) {
        int[] iniT = new int[n + 1];
        int[] lowT = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int parent = -1;
        Integer timer = 1;
        Set<Integer> articulationPointSet = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            for (Integer node: ar.get(i)) {
                if (!visited[node]) {
                    getArticulationPoints(node, parent, visited, iniT, lowT, timer, ar, articulationPointSet);
                }
            }
        }

        return new ArrayList<>(articulationPointSet);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, u, v;

        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        ArrayList<Integer> articulationPoints;

        for (int i = 0; i <= n; i++)    ar.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            System.out.print("Enter the u vertex: ");
            u = sc.nextInt();
            System.out.print("Enter the v vertex: ");
            v = sc.nextInt();

            ar.get(u).add(v);
            ar.get(v).add(u);
        }

        articulationPoints = findArticulationPoints(ar, n);

        for (Integer b : articulationPoints) {
            System.out.println(b);
        }
    }
}
