public class LongestCommonSubsequenceMemoization {
    static int longestCommonSubsequence(String x, String y, int n, int m, int[][] t) {
        if (n == 0 || m == 0)
            return 0;

        if (x.charAt(n - 1) == y.charAt(m - 1))
            return t[n][m] = 1 + longestCommonSubsequence(x, y, n - 1, m - 1, t);
        else
            return t[n][m] = Math.max(longestCommonSubsequence(x, y, n - 1, m, t), longestCommonSubsequence(x, y, n, m - 1, t));
    }

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhg";
        int n = 6, m = 7;

        int[][] t = new int[n + 1][m + 1];

        System.out.println(longestCommonSubsequence(x, y, n, m, t));
    }
}
