public class LongestCommonSubsequenceBruteForceRecursion {
    static int longestCommonSubsequence(String x, String y, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (x.charAt(n - 1) == y.charAt(m - 1))
            return 1 + longestCommonSubsequence(x, y, n - 1, m - 1);
        else
            return Math.max(longestCommonSubsequence(x, y, n - 1, m), longestCommonSubsequence(x, y, n, m - 1));
    }

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhg";
        int n = 6, m = 7;

        System.out.println(longestCommonSubsequence(x, y, n, m));
    }

}
