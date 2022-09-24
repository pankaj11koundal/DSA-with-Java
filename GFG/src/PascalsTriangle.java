import java.util.ArrayList;

public class PascalsTriangle {
    static class Solution {
        ArrayList<Integer> pascalTriangle(int n) {
            int[][] arr = new int[n][n];
            ArrayList<Integer> ar = new ArrayList<>();

            arr[0][0] = 1;
            if (n > 1)
                arr[1][0] = arr[1][1] = 1;

            for (int i = 2; i < n; i++) {
                arr[i][0] = 1;
                for (int j = 1; j < i; j++)
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                arr[i][i] = 1;
            }

            for (int ele: arr[n - 1]) {
                ar.add(ele);
            }

            return ar;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 1;
        System.out.println(s.pascalTriangle(n));
    }
}
