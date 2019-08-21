package algorithms.backtracking;

import org.junit.Assert;
import org.junit.Test;

public class WordSearchTest {

    @Test
    public void testEmptyBoard() {
        char[][] board = new char[0][0];
        WordSearch ws = new WordSearch();
        boolean actual = ws.exist(board, "abc");
        Assert.assertFalse(actual);
    }

    @Test
    public void testCaseLeetCode() {
        char[][] board =
                {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        WordSearch ws = new WordSearch();
        boolean actual = ws.exist(board, "ABCCED");
        Assert.assertTrue(actual);
        actual = ws.exist(board, "SEE");
        Assert.assertTrue(actual);
        actual = ws.exist(board, "ABCB");
        Assert.assertFalse(actual);
    }

}
