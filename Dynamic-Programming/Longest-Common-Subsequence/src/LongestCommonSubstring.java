public class LongestCommonSubstring {
    static int longestCommonSubstring(int[][] t, int n, int m, String x, String y) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++)
            t[i][0] = 0;

        for (int j = 0; j <= m; j++)
            t[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    max = Math.max(max, t[i][j]);
                }
                else
                    t[i][j] = 0;
        }

        return max;
    }

    public static void main(String[] args) {
        String x = "abcdfcgh";
        String y = "abedfchg";
        int n = 6, m = 7;

        int[][] t = new int[n + 1][m + 1];

        System.out.println(longestCommonSubstring(t, n, m, x, y));
    }
}
