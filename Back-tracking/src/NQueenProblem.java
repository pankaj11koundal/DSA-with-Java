import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueenProblem {
    static List<String> construct(char[][] board) {
        List<String> l = new LinkedList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            l.add(s);
        }

        return l;
    }

    static boolean isSafe(int row, int col, char[][] board, int n) {
        int duprow = row, dupcol = col;

        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }

        col = dupcol;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;

        while (row < n && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }


        return true;
    }

    static void nQueenProblem(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(construct(board));
        }
        else {
            for (int row = 0; row < n; row++) {
                if (isSafe(row, col, board, n)) {
                    board[row][col] = 'Q';
                    nQueenProblem(col + 1, board, ans, n);
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }

        nQueenProblem(0, board, ans, n);
        System.out.println(ans);
    }
}
