public class Knapsack01TopDown {

    private static int[][] t;

    private static int knapsack01TopDown(int[] values, int[] weight, int W, int n) {
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < W + 1; j++)
                if (weight[i - 1 ] <= j)
                    t[i][j] = Math.max(values[i - 1] + t[i - 1][j - weight[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
        return t[n][W];
    }

    public static void main(String[] args) {
        int []values = {1, 4, 5, 7};
        int []weight = {1, 3, 4, 5};

        int W = 7, n = 4;

        t = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++)
            t[i][0] = 0;
        for (int j = 0; j < W + 1; j++)
            t[0][j] = 0;

        System.out.println(knapsack01TopDown(values, weight, W, n));
    }
}
