public class MatrixChainMultiplicationMemoization {
    static int matrixChainMultiplication(int[] dim, int[][] t, int i, int j) {
        if (i >= j)
            return 0;

        if (t[i][j] != -1)
            return t[i][j];

        int tempAns, ans = Integer.MAX_VALUE;

        for (int k = i; k <= j-1; k++) {
            tempAns = matrixChainMultiplication(dim, t, i, k) + matrixChainMultiplication(dim, t, k + 1, j)
                    + dim[i - 1] * dim[k] * dim[j];

            ans = Math.min(tempAns, ans);
        }

        return t[i][j] = ans;
    }

    public static void main(String[] args) {
        int[] dim = {40, 20, 30, 10, 30};
        int n = dim.length;

        int[][] t = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0 ;j < n; j++)
                t[i][j] = -1;

        System.out.println(matrixChainMultiplication(dim, t, 1, n - 1));
    }
}
