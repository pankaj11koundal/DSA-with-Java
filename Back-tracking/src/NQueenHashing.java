import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueenHashing {
    static List<String> construct(char[][] board) {
        List<String> l = new LinkedList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            l.add(s);
        }
        return l;
    }

    static void nQueenProblem(int col, char[][] board, List<List<String>> ans, int[] left, int[] upperD, int[] lowerD, int n) {
        if (n == col) {
            ans.add(construct(board));
        } else {
            for (int row = 0; row < n; row++) {
                if ((left[row] == 0) && (lowerD[row + col] == 0) && (upperD[n - 1 + col - row] == 0)) {
                    left[row] = 1;
                    lowerD[row + col] = 1;
                    upperD[n - 1 + col - row] = 1;
                    board[row][col] = 'Q';
                    nQueenProblem(col + 1, board, ans, left, upperD, lowerD, n);

                    left[row] = 0;
                    lowerD[row + col] = 0;
                    upperD[n - 1 + col - row] = 0;
                    board[row][col] = '.';
                }

            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[4][4];
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        int[] left = new int[n];
        int[] upperD = new int[n * 2];
        int[] lowerD = new int[n * 2];

        nQueenProblem(0, board, ans, left, upperD, lowerD, n);
        System.out.println(ans);
    }
}

