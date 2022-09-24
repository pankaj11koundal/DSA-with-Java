public class MakeZeros {
    static class Solution {
        void makeZeros (int[][] matrix) {
            int n = matrix.length, m = matrix[0].length;
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) visited[i][j] = true;
                }
            }

            for (boolean[] ar: visited) {
                for (boolean ele: ar)
                    System.out.print(ele + " ");
                System.out.println();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) {
                        if (i - 1 >= 0 && (!visited[i - 1][j]))
                            matrix[i][j] += matrix[i - 1][j];
                        if (i + 1 < n && !(visited[i + 1][j]))
                            matrix[i][j] += matrix[i + 1][j];
                        if (j - 1 >= 0 && !(visited[i][j - 1]))
                            matrix[i][j] += matrix[i][j - 1];
                        if (j + 1 < m && !(visited[i][j + 1]))
                            matrix[i][j] += matrix[i][j + 1];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <  m; j++) {
                    if (visited[i][j]) {
                        if (i - 1 >= 0)
                            matrix[i - 1][j] = visited[i - 1][j] ? matrix[i - 1][j] : 0;
                        if (i + 1 < n)
                            matrix[i + 1][j] = visited[i + 1][j] ? matrix[i + 1][j] : 0;
                        if (j - 1 >= 0)
                            matrix[i][j - 1] = visited[i][j - 1] ? matrix[i][j - 1] : 0;
                        if (j + 1 < m)
                            matrix[i][j + 1] = visited[i][j + 1] ? matrix[i][j + 1] : 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 0},
                {5, 6, 0, 7},
                {8, 9, 0, 5},
                {8, 4, 5, 7}
        };

        Solution s = new Solution();
        s.makeZeros(matrix);

        for (int[] ar: matrix) {
            for (int ele: ar)
                System.out.print(ele + " ");
            System.out.println();
        }
    }
}
