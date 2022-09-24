public class BooleanParenthesizedMemoization {
    static int findWays(String str, int i, int j, int[][][]t, boolean isTrue) {
        if (i > j) return 0;

        if (i == j) {
            if (isTrue) {
                if (str.charAt(i) == 'T') return 1;
                else return 0;
            }
            else {
                if (str.charAt(i) == 'F') return 1;
                else return 0;
            }
        }

        if (isTrue) {
            if (t[1][i][j] != -1)
                return t[1][i][j];
        }
        else {
            if (t[0][i][j] != -1)
                return t[0][i][j];
        }

        int ans = 0, lT, lF, rT, rF;

        for (int k = i + 1; k <= j - 1; k += 2) {
            lT = findWays(str, i, k - 1, t, true);
            lF = findWays(str, i, k - 1, t, false);
            rT = findWays(str, k + 1, j, t, true);
            rF = findWays(str, k + 1, j, t, false);

            if (str.charAt(k) == '&') {
                if (isTrue)
                    ans += lT * rT;
                else
                    ans += (lF * rF) + (lF * rT) + (rF * lT);
            } else if (str.charAt(k) == '|') {
                if (isTrue)
                    ans += (lT * rT) + (rT * lF) + (lT * rF);
                else
                    ans += rF * lF;
            } else if (str.charAt(k) == '^') {
                if (isTrue)
                    ans += (lF * rT) + (rF * lT);
                else
                    ans += (lF * rF) + (rT * lT);
            }
        }

        if (isTrue) return t[1][i][j] = ans;
        else return t[0][i][j] = ans;
    }
    static int booleanParenthesization(int n, String str) {
        int[][][] t = new int[2][n][n];

        for (int k = 0; k < 2; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    t[k][i][j] = -1;

        return findWays(str, 0, n - 1, t, true);
    }

    public static void main(String[] args) {
        String str = "T|F^F";
        System.out.println(booleanParenthesization(str.length(), str));
    }
}
