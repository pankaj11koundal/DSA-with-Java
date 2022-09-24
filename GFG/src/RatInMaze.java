import java.util.ArrayList;

public class RatInMaze {
    private static void solve(int i, int j, int[][] m, String move, ArrayList<String> ans, boolean[][] vis, int n) {
        if (i == n - 1 &&  j == n - 1)
            ans.add(move);

        // downward
        if (i + 1 < n && !vis[i + 1][j] && m[i + 1][j] == 1) {
            vis[i][j] = true;
            solve(i + 1, j, m, move + "D", ans, vis, n);
            vis[i][j] = false;
        }

        // leftward
        if (j - 1 >= 0 && !vis[i][j - 1] && m[i][j - 1] == 1) {
            vis[i][j] = true;
            solve(i, j - 1, m, move + "L", ans, vis, n);
            vis[i][j] = false;
        }

        // rightward
        if (j + 1 < n && !vis[i][j + 1] && m[i][j + 1] == 1) {
            vis[i][j] = true;
            solve(i, j + 1, m, move + "R", ans, vis, n);
            vis[i][j] = false;
        }

        // upward
        if (i - 1 >= 0 && !vis[i - 1][j] && m[i - 1][j] == 1) {
            vis[i][j] = true;
            solve(i - 1, j, m, move + "U", ans, vis, n);
            vis[i][j] = false;
        }
    }

    private static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];

        if (m[0][0] == 1)
            solve(0, 0, m, "", ans, vis, n);

        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] m = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        System.out.println(findPath(m, n));
    }

}
