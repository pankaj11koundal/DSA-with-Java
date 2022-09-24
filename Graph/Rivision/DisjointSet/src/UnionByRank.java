public class UnionByRank {
    static int[] rank = new int[10000];
    static int[] parent = new int[10000];

    static void makeSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    static int findParent(int node) {
        if (node == parent[node])
            return node;

        return parent[node] = findParent(parent[node]);
    }

    static void unionByRank(int u, int v) {
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
        makeSet(n);
        unionByRank(1, 2);
        unionByRank(2, 3);
        unionByRank(4, 5);
        unionByRank(6, 7);
        unionByRank(5, 6);
        unionByRank(3, 7);

        for (int i = 0 ; i <= n; i++)
            System.out.print(parent[i] + " ");
    }
}
