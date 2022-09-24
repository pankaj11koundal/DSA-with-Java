public class LongestRepeatingSubsequence {
    static int longestRepeatingSubsequence(String str, int n) {
        String s = str;
        int[][] t = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = 0;
            t[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == s.charAt(j - 1) && i != j)
                    t[i][j] = t[i - 1][j - 1] + 1;
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }

        return t[n][n];
    }

    public static void main(String[] args) {
        String str = "AABEBCDD";

        System.out.println(longestRepeatingSubsequence(str, str.length()));
    }
}
