public class FillMatrixZeroBruteForce {
    static class Solution {
        void fillMatrixZero(int[][] matrix, int n, int m) {
            int[][] visited = new int[n][m];

            for (int i = 0 ; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j] == 0) {
                        visited[i][j] = 1;
                        if (matrix[i][j] == 0) {
                           for (int k = 0; k < n; k++) {
                               matrix[k][j] = 0;
                               visited[k][j] = 1;
                           }
                           for (int k = 0; k < m; k++) {
                               matrix[i][k] = 0;
                               visited[i][k] = 1;
                           }
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5},};
        int n = 3, m = 4;
        s.fillMatrixZero(matrix, n, m);

        for (int[] a: matrix) {
            for (int ele: a)
                System.out.print(ele + " ");
            System.out.println();
        }
    }
}