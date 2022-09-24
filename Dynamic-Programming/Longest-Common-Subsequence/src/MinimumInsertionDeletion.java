//Given two strings str1 and str2.
// The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2.
// It could be possible that the same character needs to be removed/deleted
// from one point of str1 and inserted to some another point.
public class MinimumInsertionDeletion {
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

    static int minimumOperations(int n, int m, String x, String y) {
        int lcs = longestCommonSubsequence(n, m, x, y);

        return (n - lcs) + (m - lcs);
    }

   public static void main(String[] args) {
       String x = "heap";
       String y = "pea";
       int n = x.length(), m = y.length();

       System.out.println(minimumOperations(n, m, x, y));
   }
}
