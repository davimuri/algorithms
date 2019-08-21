package algorithms.backtracking;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Source: https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/797/
 */
public class WordSearch {

    private char[][] board;
    private boolean[][] visited;
    private String word;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < word.length(); i++) {
            if (search(0, 0, i)) return true;
        }
        return false;
    }

    private boolean search(int r, int c, int i) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
            || i >= word.length() || board[r][c] != word.charAt(i)) {
            return false;
        }
        if (i == word.length()-1 && board[r][c] == word.charAt(i)) {
            return true;
        }
        if (board[r][c] != word.charAt(i)) {
            return false;
        }
        visited[r][c] = true;
        if (search(r+1, c, i+1)) return true;
        if (search(r-1, c, i+1)) return true;
        if (search(r, c+1, i+1)) return true;
        if (search(r, c-1, i+1)) return true;
        visited[r][c] = false;
        return false;
    }
}
