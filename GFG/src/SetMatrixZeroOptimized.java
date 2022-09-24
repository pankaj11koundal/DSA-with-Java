public class SetMatrixZeroOptimized {
    static class Solution {
        void setMatrixZero(int[][] matrix) {
            int n = matrix.length, m = matrix[0].length;
            int[] row = new int[n], column = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = 1;
                        column[j] = 1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (row[i] == 1 || column[j] == 1)
                        matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 8, 0,},
                {3, 4, 5, 2,},
                {1, 3, 1, 5}
        };

        Solution s = new Solution();
        s.setMatrixZero(matrix);

        for (int[] ar: matrix) {
            for (int ele: ar)
                System.out.print(ele + " ");

            System.out.println();
        }
    }
}
