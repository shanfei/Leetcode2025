package com.leetcode.amazon;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {

    public  boolean isValidSudoku(char[][] board) {
        // Initialize sets to keep track of the numbers in each row, column, and box.
        HashSet<String> rows = new HashSet<>();
        HashSet<String> columns = new HashSet<>();
        HashSet<String> boxes = new HashSet<>();

        // Iterate through each cell in the 9x9 board.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // Formulate keys for the row, column, and box.
                    String rowKey = "row" + i + "(" + num + ")";
                    String colKey = "col" + j + "(" + num + ")";
                    String boxKey = "box" + (i / 3 * 3 + j / 3) + "(" + num + ")";
                    // Check the corresponding sets for these keys.
                    if (!rows.add(rowKey) || !columns.add(colKey) || !boxes.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isSquareValid(char[][] board) {

        int k = 0;

        while ( k < 9 ) {

            Set<Character> s = new HashSet<>();

            for (int i = k; i < k + 3; i++) {
                for (int j = k; j < k + 3; j++) {
                    if (!s.add(board[i][j])) {
                        return false;
                    }
                }
            }

            k += 3;
        }

        return true;

    }

    boolean isLineValid(char[][] board) {

        for ( int i = 0; i < 9; ++i ) {
            Set<Character> set = new HashSet<>();
            for ( int j = 0; j < 9; ++j ) {
                if (!set.add(board[i][j])) {
                    return false;
                }
            }
        }

        for ( int j = 0; j < 9; ++j ) {
            Set<Character> set = new HashSet<>();
            for ( int i = 0; i < 9; ++i ) {
                if (!set.add(board[i][j])) {
                    return false;
                }
            }
        }

        return true;

    }
}
