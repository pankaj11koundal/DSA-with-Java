import java.util.Arrays;

public class BooleanParenthesizationMemoization2 {
    static int mod = 1003;
    static int findWays(String str, int i, int j, int[][][]t, int isTrue) {
        if (i > j) return 0;

        if (i == j) {
            if (isTrue == 1) {
                return str.charAt(i) == 'T' ? 1 : 0;

            }
            else {
                return str.charAt(i) == 'F' ? 1 : 0;
            }
        }

        if (t[i][j][isTrue] != -1) return t[i][j][isTrue];

        int ans = 0, lT, lF, rT, rF;

        for (int k = i + 1; k <= j - 1; k += 2) {
            lT = (t[i][k - 1][1] != -1) ? t[i][k - 1][1] : findWays(str, i, k - 1, t, 1);
            lF = (t[i][k - 1][0] != -1) ? t[i][k - 1][0] : findWays(str, i, k - 1, t, 0);
            rT = (t[k + 1][j][1] != -1) ? t[k + 1][j][1] : findWays(str, k + 1, j, t, 1);
            rF = (t[k + 1][j][0] != -1) ? t[k + 1][j][0] : findWays(str, k + 1, j, t, 0);

            if (str.charAt(k) == '&') {
                if (isTrue == 1)
                    ans = (ans + lT * rT) % mod;
                else
                    ans = (ans + (lF * rF) + (lF * rT) + (rF * lT)) % mod;
            } else if (str.charAt(k) == '|') {
                if (isTrue == 1)
                    ans = (ans + (lT * rT) + (rT * lF) + (lT * rF)) % mod;
                else
                    ans = (ans + rF * lF) % mod;
            } else if (str.charAt(k) == '^') {
                if (isTrue == 1)
                    ans = (ans + (lF * rT) + (rF * lT)) % mod;
                else
                    ans = (ans + (lF * rF) + (rT * lT)) % mod;
            }
        }

        return t[i][j][isTrue] = ans % 1003;
    }
    static int booleanParenthesization(int n, String str) {
        int[][][] t = new int[n][n][2];

        for (int row[][] : t)
            for (int col[]: row)
                Arrays.fill(col, -1);

        return findWays(str, 0, n - 1, t, 1);
    }

    public static void main(String[] args) {
        String str = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
        System.out.println(booleanParenthesization(str.length(), str));
    }
}
