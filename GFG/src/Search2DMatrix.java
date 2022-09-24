public class Search2DMatrix {
    static class Solution {
        boolean search2DMatrix (int[][] matrix, int target) {
            int i = 0, j = matrix[0].length - 1;

            while (i < matrix.length && j >= 0) {
                if (matrix[i][j] == target) return true;
                else if (matrix[i][j] > target) j--;
                else i++;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {20, 23, 34, 60}
        };

        Solution s = new Solution();
        System.out.println(s.search2DMatrix(matrix, 3));
    }
}
