public class MinCoinChange {
    public static int minCoins(int coins[], int m, int amount)
    {
        int [][]t = new int[m + 1][amount + 1];

        for (int i = 1 ; i < m + 1; i++)
            t[i][0] = 0;

        for (int j = 0; j < amount + 1; j++)
            t[0][j] = Integer.MAX_VALUE - 1;

        for (int j = 1; j < amount + 1; j++)
            if (j % coins[0] == 0)
                t[1][j] = j / coins[0];
            else
                t[1][j] = Integer.MAX_VALUE - 1;

        for (int i = 2; i < m + 1; i++)
            for (int j = 1; j < amount + 1; j++)
                if (coins[i - 1] <= j)
                    t[i][j] = Math.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];


        return t[m][amount] != Integer.MAX_VALUE - 1 ? t[m][amount] : -1;
    }

    public static void main(String[] args) {
        int [] coins = {1, 2, 3};
        int amount = 5;

        System.out.println(minCoins(coins, coins.length, amount));
    }
}
