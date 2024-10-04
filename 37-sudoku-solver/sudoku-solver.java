class Solution {
    int GRID_SIZE = 9;
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private  boolean solve(char[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                // Check for empty cell
                if (board[row][col] == '.') {
                    // Try numbers '1' to '9' in the empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recur to attempt solving the rest of the puzzle
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack by resetting the cell to '.'
                            board[row][col] = '.';
                        }
                    }
                    return false; // Trigger backtracking if no number fits
                }
            }
        }
        return true; // Puzzle solved
    }
         

    private boolean isValid(char[][] board, int row, int col, int num) {
        // Check the row and column
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int subGridRowStart = row - row % 3;
        int subGridColStart = col - col % 3;
        for (int i = subGridRowStart; i < subGridRowStart + 3; i++) {
            for (int j = subGridColStart; j < subGridColStart + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // Valid placement
    }
}