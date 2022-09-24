public class RotateImage {
    static class Solution {
        void swap(int[][]image, int i, int j) {
            int temp = image[i][j];
            image[i][j] = image[j][i];
            image[j][i] = temp;
        }

        void swap(int[][] image, int start, int end, int row) {
            int temp = image[row][start];
            image[row][start] = image[row][end];
            image[row][end] = temp;
        }

        void rotateImage(int[][] image) {
            int n = image.length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i < j) swap(image, i, j);
                }
            }

            for (int i = 0; i < n; i++) {
                int start = 0, end = n - 1;
                while (start < end) {
                    swap(image, start++, end--, i);
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
        s.rotateImage(image);

        for (int[] arr :image) {
            for (int ele: arr)
                System.out.print(ele + " ");
            System.out.println();
        }
    }
}
