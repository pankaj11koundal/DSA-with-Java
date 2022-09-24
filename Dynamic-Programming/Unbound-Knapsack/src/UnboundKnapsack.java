public class UnboundKnapsack {

    private static int unboundKnapsack(int[] wt, int[] val, int n, int W) {
        int [][]t = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++)
            t[i][0] = 0;

        for (int j = 1; j < W + 1; j++)
            t[0][j] = 0;

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < W + 1; j++)
                if (wt[i - 1] <= j)
                    t[i][j] = Math.max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];

        return t[n][W];
    }

    public static void main(String[] args) {
        int [] wt = {1, 3, 4, 5};
        int [] val = {1, 4, 5, 7};
        int n = 4;
        int W = 8;

        System.out.println(unboundKnapsack(wt, val, n, W));

    }
}
