public class UnionByRankRevisted {
    static int[] parent;
    static int[] rank;

    static void makeSet(int n) {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int findParent(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }

    static void union(int u, int v) {
        u = findParent(u);
        v = findParent(v);

        if (rank[u] < rank[v])
            parent[u] = v;
        else if (rank[u] > rank[v])
            parent[v] = u;
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public static void main(String[] args) {
        int n = 7;
        parent = new int[n + 1];
        rank = new int[n + 1];

        makeSet(n);
        union(1, 2);
        union(2, 3);
        union(4, 5);
        union(6, 7);
        union(5, 6);
        union(3, 7);

        for (int i = 1; i <= n; i++)
            System.out.print(parent[i] + " ");


        if (findParent(7) == findParent(3))
            System.out.println("same");
        else
            System.out.println("different");
    }
}
