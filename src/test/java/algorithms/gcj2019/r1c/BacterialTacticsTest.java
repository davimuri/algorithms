package algorithms.gcj2019.r1c;

import algorithms.gcj2019.r1c.BacterialTactics;
import org.junit.Test;

import static org.junit.Assert.*;

public class BacterialTacticsTest {

    @Test
    public void testCase1() {
        int expected = 0;
        char[][] board = {
                {'.', '.'},
                {'.', '#'},
        };
        int actual = BacterialTactics.winningOpenings(board);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        int expected = 0;
        char[][] board = {
                {'.', '#', '.', '.'},
                {'.', '.', '#', '.'},
                {'#', '.', '.', '.'},
                {'.', '.', '.', '#'},
        };
        int actual = BacterialTactics.winningOpenings(board);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        int expected = 7;
        char[][] board = {
                {'#', '.', '#', '#'},
                {'.', '.', '.', '.'},
                {'#', '.', '#', '#'},
        };
        int actual = BacterialTactics.winningOpenings(board);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        int expected = 2;
        char[][] board = {
                {'.'}
        };
        int actual = BacterialTactics.winningOpenings(board);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase5() {
        int expected = 0;
        char[][] board = {
                {'#', '#'}
        };
        int actual = BacterialTactics.winningOpenings(board);
        assertEquals(expected, actual);
    }

}
