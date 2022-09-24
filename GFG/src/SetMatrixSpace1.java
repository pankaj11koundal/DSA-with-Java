public class SetMatrixSpace1 {
    static class Solution {
        void setMatrixZero(int[][] matrix) {
            int n = matrix.length, m = matrix[0].length;
            int index = 1;
            for (int i = 0; i < n; i++) {
                if (matrix[i][0] == 0) index = 0;

                for (int j = 1; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 1; j--) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
                }

                if (index == 0) matrix[i][0] = 0;
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
            for (int ele: ar) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
