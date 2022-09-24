public class CoinChangeProblem2 {
    private static int coinChangeSolver(int[] coin, int sum) {
        int[][] t = new int[coin.length + 1][sum + 1];

        for (int i = 0; i < coin.length + 1; i++)
            t[i][0] = 1;

        for (int j = 1; j < sum + 1; j++)
            t[0][j] = 0;

        for (int i = 1; i < coin.length + 1; i++)
            for (int j = 1; j < sum + 1; j++)
                if (coin[i - 1] <= j)
                    t[i][j] = t[i][j - coin[i - 1]] + t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];

        return t[coin.length][sum];
    }

    public static void main(String[] args) {
        int []coin = {1, 2, 3};
        int sum = 5;

        System.out.println(coinChangeSolver(coin, sum));
    }
}
