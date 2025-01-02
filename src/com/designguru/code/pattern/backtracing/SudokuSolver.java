package com.designguru.code.pattern.backtracing;

/**
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 *
 * Example 1:
 * Input:
 *
 *             {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
 *             {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
 *             {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
 *             {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
 *             {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
 *             {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
 *             {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
 *             {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
 *             {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
 * Output:
 *
 *             {'5'', '3'', '4'', '6'', '7'', '8'', '9'', '1'', '2''},
 *             {'6'', '7'', '2'', '1'', '9'', '5'', '3'', '4'', '8''},
 *             {'1'', '9'', '8'', '3'', '4'', '2'', '5'', '6'', '7''},
 *             {'8'', '5'', '9'', '7'', '6'', '1'', '4'', '2'', '3''},
 *             {'4'', '2'', '6'', '8'', '5'', '3'', '7'', '9'', '1''},
 *             {'7'', '1'', '3'', '9'', '2'', '4'', '8'', '5'', '6''},
 *             {'9'', '6'', '1'', '5'', '3'', '7'', '2'', '8'', '4''},
 *             {'2'', '8'', '7'', '4'', '1'', '9'', '6'', '3'', '5''},
 *             {'3'', '4'', '5'', '2'', '8'', '6'', '1'', '7'', '9''}
 *
 * Explanation: The given output is the only valid Sudoku solution.
 *
 *
 */
public class SudokuSolver {

    public char[][] solveSudoku(char[][] board) {
        solve(board);
        return board;
    }

    boolean solve(char[][] board) {

        for ( int i = 0; i < board.length; ++i ) {
            for (int j = 0; j < board[i].length; ++j) {

                char c = board[i][j];

                if (c != '.') {
                    continue;
                }

                for (int n = 1; n < 10; ++n) {
                    if (isValid(board, i, j, n)) {
                        board[i][j] = (char) (n + '0');
                        if (solve(board)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }

        return true;
    }

    boolean isValid(char[][] board, int row, int col, int cnum) {

        char num = (char) ( cnum + '0' );

        // Check if we already have the same number in the same row, col or box
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num) {
                return false; // Check if the same number is in the same row
            }
            if (board[x][col] == num) {
                return false; // Check if the same number is in the same col
            }
            if (board[(row / 3) * 3 + x / 3][(col / 3) * 3 + x % 3] == num) {
                return false; // Check if the same number is in the same 3x3 box
            }
        }
        return true;
    }


}
