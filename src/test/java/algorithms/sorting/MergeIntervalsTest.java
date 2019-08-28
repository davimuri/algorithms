package algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

public class MergeIntervalsTest {

    @Test
    public void testNullInput() {
        int[][] input = null;
        int[][] expected = null;
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] actual = mergeIntervals.merge(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testEmptyInput() {
        int[][] input = {};
        int[][] expected = {};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] actual = mergeIntervals.merge(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOneInterval() {
        int[][] input = {{1,3}};
        int[][] expected = {{1,3}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] actual = mergeIntervals.merge(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNoOverlapping() {
        int[][] input = {{1,3}, {4, 6}};
        int[][] expected = {{1,3}, {4, 6}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] actual = mergeIntervals.merge(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOverlappingAtEnd() {
        int[][] input = {{1,3}, {3, 5}};
        int[][] expected = {{1,5}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] actual = mergeIntervals.merge(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCase1() {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expected = {{1,6},{8,10},{15,18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] actual = mergeIntervals.merge(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        int[][] input = {{1,4},{0,2},{3,5}};// 0S, 1S, 2E, 3S, 4E, 5E
        int[][] expected = {{0,5}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] actual = mergeIntervals.merge(input);
        Assert.assertArrayEquals(expected, actual);
    }

}
