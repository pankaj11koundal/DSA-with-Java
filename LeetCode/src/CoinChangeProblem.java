public class CoinChangeProblem {
    private static int minCoinChangeProblem(int []coins, int amount) {
        int [][]t = new int[coins.length + 1][amount + 1];

        for (int i = 1 ; i < coins.length + 1; i++)
            t[i][0] = 0;

        for (int j = 0; j < amount + 1; j++)
            t[0][j] = Integer.MAX_VALUE - 1;

        for (int j = 1; j < amount + 1; j++)
            if (j % coins[0] == 0)
                t[1][j] = j / coins[0];
            else
                t[1][j] = Integer.MAX_VALUE - 1;

        for (int i = 2; i < coins.length + 1; i++)
            for (int j = 1; j < amount + 1; j++)
                if (coins[i - 1] <= j)
                    t[i][j] = Math.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];

        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++)
                System.out.print(t[i][j] + " ");
            System.out.println();
        }
        return t[coins.length][amount] != Integer.MAX_VALUE - 1 ? t[coins.length][amount] : -1;
    }

    public static void main(String[] args) {
        int [] coins = {1, 2, 3};
        int amount = 5;

        System.out.println(minCoinChangeProblem(coins, amount));
    }
}
