public class FindWays {
    static class Solution {
        int findWays (int n, int m, int i, int j, int count, int[][] t) {
            if (i == n - 1 && j == m - 1) {
                return 1;
            }

            if (i >= n || j >= m) return 0;

            if (t[i][j] != -1) return t[i][j];

            count += findWays(n, m, i + 1, j, count, t) + findWays(n, m, i, j + 1, count, t);
            return t[i][j] = count;
        }

        int uniquePaths(int n, int m) {
            int i = 0, j = 0, count = 0;
            int[][] t = new int[n][m];

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++)
                    t[r][c] = -1;
            }

            return findWays(n, m, i, j, count, t);
        }
    }

    public static void main(String[] args) {
        int n = 3, m = 7;
        Solution s = new Solution();

        System.out.print(s.uniquePaths(n, m));
    }
}
