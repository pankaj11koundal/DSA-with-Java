public class KnapSack0_1 {

    public static int knapsack(int[] values, int[] weight, int W, int N) {
        if (N == 0 || W == 0)
            return 0;
        else if (weight[N - 1] <= W)
            return Math.max(values[N - 1] + knapsack(values, weight, W - weight[N - 1], N - 1), knapsack(values, weight, W, N - 1));
        else
            return knapsack(values, weight, W, N - 1);
    }

    public static void main(String[] args) {
        int []values = {1, 2, 3};
        int []weight = {4, 5, 1};
        int W = 4, N = 3;

        System.out.println(knapsack(values, weight, W, N));
    }
}
