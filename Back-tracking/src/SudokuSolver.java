public class SudokuSolver {
    static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == c && board[i][col] != '.')
            return false;

            if (board[row][i] == c && board[row][i] != '.')
                return false;

            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c && board[3 * (row / 3) + (i / 3)][(3 * (col / 3)) + (i % 3)] != '.')
                return false;
        }
        return true;
    }

    static boolean sudokuSolver(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                           board[i][j] = c;

                           if (sudokuSolver(board))
                               return true;
                           else
                               board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        sudokuSolver(board);

        for (char[] chars : board) {
            for (char c : chars)
                System.out.print(c);

            System.out.println();
        }
    }
}
