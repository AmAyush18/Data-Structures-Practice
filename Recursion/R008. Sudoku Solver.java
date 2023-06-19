// Problem Link: https://leetcode.com/problems/sudoku-solver/description/

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(i, j, c, board)){
                            board[i][j] = c;

                            if(solve(board))
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

    private boolean isValid(int row, int col, char val, char[][] board){
        for(int i = 0; i < 9; i++){
            // check for rows
            if(board[i][col] == val)
                return false;

            // check for cols
            if(board[row][i] == val)
                return false;

            // check for 3x3 board
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val)
                return false;
        }
        return true;
    }
}
