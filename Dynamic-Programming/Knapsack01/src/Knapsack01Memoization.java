public class Knapsack01Memoization {
    private static int[][] t;

    public static void main(String[] args) {
        int []values = {1, 2, 3};
        int []weight = {4, 5, 1};

        int W = 4, n = 3;
        t = new int[n][W];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < W; j++)
                t[i][j] = -1;

        System.out.println(knapsackMemoization(values, weight, W, n));
    }

    private static int knapsackMemoization(int []values, int []weight, int W, int n) {
        if (n == 0 || W == 0)
            return 0;

        if (t[n - 1][W - 1] != -1)
            return t[n - 1][W - 1];

        if (weight[n - 1] <= W)
            t[n - 1][W - 1] = Math.max(values[n - 1] + knapsackMemoization(values, weight, W - weight[n - 1], n - 1), knapsackMemoization(values, weight, W, n - 1));
        else
            t[n - 1][W - 1] = knapsackMemoization(values, weight, W, n - 1);

        return t[n - 1][ W - 1];
    }
}
