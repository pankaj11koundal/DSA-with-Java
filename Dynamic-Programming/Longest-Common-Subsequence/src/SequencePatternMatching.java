public class SequencePatternMatching {
    static int longestCommonSubsequence(int n, int m, String x, String y) {
        int[][] t = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            t[i][0] = 0;

        for (int j = 0; j <= m; j++)
            t[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
        }

        return t[n][m];
    }

    static boolean sequencePatternMatching(String a, String b) {
        int n = a.length(), m = b.length();

        return longestCommonSubsequence(n, m, a, b) == n;
    }

    public static void main(String[] args) {
        String a = "AXY";
        String b = "ABXCPY";

        System.out.println(sequencePatternMatching(a, b));
    }
}
