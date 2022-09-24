public class Rotate2DArray {
    static class Solution {
        void swap(int[][]matrix, int i, int j) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }

        void swap(int[][] matrix, int start, int end, int col) {
            int temp = matrix[start][col];
            matrix[start][col] = matrix[end][col];
            matrix[end][col] = temp;
        }

        void rotate(int[][] matrix)
        {
            int n = matrix.length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i < j) swap(matrix, i, j);
                }
            }

            for (int i = 0; i < n; i++) {
                int start = 0, end = n - 1;
                while (start < end) {
                    swap(matrix, start++, end--, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Solution s = new Solution();
        s.rotate(image);

        for (int[] arr :image) {
            for (int ele: arr)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

}
