public class RodCutProblem {

    private static int rodCutProblem(int n, int [] price) {
        int[] length = new int[n];

        for (int i = 0; i < price.length; i++)
            length[i] = i + 1;

        int [][]t = new int[n + 1][length.length + 1];

        for (int i = 0; i < n + 1; i++)
            t[i][0] = 0;

        for (int j = 1; j < length.length + 1; j++)
            t[0][j] = 0;

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < length.length + 1; j++)
                if (length[i - 1] <= j)
                    t[i][j] = Math.max(price[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];

        return t[n][n];
    }

    public static void main(String[] args) {
        int n = 8;
        int [] price = {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(rodCutProblem(n, price));
    }
}
