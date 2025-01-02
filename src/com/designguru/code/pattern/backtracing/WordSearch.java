package com.designguru.code.pattern.backtracing;

/**
 *
 * Given an m x n grid of characters board and a string word, return true if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example 1:
 *
 * Input: word="ABCCED", board:
 *
 *   { 'A', 'B', 'C', 'E' },
 *   { 'S', 'F', 'C', 'S' },
 *   { 'A', 'D', 'E', 'E' }
 * Output: true
 *
 * Explanation: The word exists in the board:
 * -> { 'A', 'B', 'C', 'E' },
 * -> { 'S', 'F', 'C', 'S' },
 * -> { 'A', 'D', 'E', 'E' }
 *
 * Example 2:
 *
 * Input: word="SEE", board:
 *
 *   { 'A', 'B', 'C', 'E' },
 *   { 'S', 'F', 'C', 'S' },
 *   { 'A', 'D', 'E', 'E' }
 * Output: true
 *
 * Explanation: The word exists in the board:
 * -> { 'A', 'B', 'C', 'E' },
 * -> { 'S', 'F', 'C', 'S' },
 * -> { 'A', 'D', 'E', 'E' }
 *
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        char[] cs = word.toCharArray();
        char c =  word.charAt(0);

        boolean f = false;

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if ( board[i][j] == c ) {
                    f |=  dfs(board, cs, i, j, 0);
                }
            }
        }

        return f;
    }

    static boolean dfs(char[][] board, char[] words, int x, int y, int c) {

        int[][] directions = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        if ( c >= words.length ) {
            return true;
        }

        char nc = words[c];

        boolean r = false;

        if ( x < 0 || x > board.length - 1 || y < 0 || y > board[x].length - 1 || nc != board[x][y] ) {
            return r;
        }

        char t = board[x][y];
        board[x][y] = '/';

        for ( int[] d : directions ) {
            r |= dfs(board, words, x + d[0], y + d[1], c + 1);
        }

        board[x][y] = t;

        return r;

    }
}
