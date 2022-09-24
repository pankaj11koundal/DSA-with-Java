public class FindWaysTopDown {
    static class Solution {
        int uniquePaths(int n, int m) {
            int[][] t = new int[n][m];

            for (int i = 0; i < n; i++) {
                t[i][0] = 1;
            }

            for (int i = 0; i < m; i++) {
                t[0][i] = 1;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    t[i][j] = t[i][j - 1] + t[i - 1][j];
                }
            }

            return t[n - 1][m - 1];
        }
    }

    public static void main(String[] args) {
        int n = 3, m = 7;
        Solution s = new Solution();

        System.out.print(s.uniquePaths(n, m));
    }
}
