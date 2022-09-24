public class SolveTheSudoku {
    static boolean isValid(int[][] board, int row, int col, int c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == c && board[i][col] != 0)
                return false;

            if (board[row][i] == c && board[row][i] != 0)
                return false;

            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c && board[3 * (row / 3) + (i / 3)][(3 * (col / 3)) + (i % 3)] != 0)
                return false;
        }
        return true;
    }

    static boolean SolveSudoku(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    for (int c = 1; c <= 9; c++) {
                        if (isValid(grid, i, j, c)) {
                            grid[i][j] = c;

                            if (SolveSudoku(grid))
                                return true;
                            else
                                grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SolveSudoku(grid);

        for (int[] ints : grid) {
            for (int c : ints)
                System.out.print(c);

            System.out.println();
        }
    }
}
