public class MakeZerosGFG {
    static class Solution {
        void makeZeros(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] visited = new int[n][m];
            int sum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        if (i - 1 >= 0) {
                            sum += matrix[i - 1][j];
                            visited[i - 1][j] = -1;
                        }
                        if (i + 1 < n) {
                            sum += matrix[i + 1][j];
                            visited[i + 1][j] = -1;
                        }
                        if (j - 1 >= 0) {
                            sum += matrix[i][j - 1];
                            visited[i][j - 1] = -1;
                        }
                        if (j + 1 < m) {
                            sum += matrix[i][j + 1];
                            visited[i][j + 1] = -1;
                        }
                        visited[i][j] = sum;
                        sum = 0;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j] < 0) matrix[i][j] = 0;
                    else if (visited[i][j] > 0) matrix[i][j] = visited[i][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int [][] matrix = {
                {10, 1, 11},
                {2, 4, 16},
                {8, 12, 17},
                {12, 16, 0},
                {6, 10, 0},
                {12, 18, 12}
        };

        Solution s = new Solution();
        s.makeZeros(matrix);

        for (int[] ar: matrix) {
            for (int ele: ar) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}