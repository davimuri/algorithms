package algorithms.monotonicqueues;

import org.junit.Assert;
import org.junit.Test;


public class LongestSubArrayWithAbsoluteDifferenceTest {

    @Test
    public void testCase1() {
        int[] subArray = algorithms.heap.LongestSubArrayWithAbsoluteDifference.solve(new int[] {8, 4, 2, 6, 7}, 4);
        Assert.assertArrayEquals(new int[] {4, 2, 6}, subArray);
    }

    @Test
    public void testCase2() {
        int[] subArray = algorithms.heap.LongestSubArrayWithAbsoluteDifference.solve(new int[] {15, 10, 1, 2, 4, 7, 2}, 5);
        Assert.assertArrayEquals(new int[] {2, 4, 7, 2}, subArray);
    }

    @Test
    public void testCase3() {
        int[] subArray = algorithms.heap.LongestSubArrayWithAbsoluteDifference.solve(new int[] {5, 5, 20}, 5);
        Assert.assertArrayEquals(new int[] {5, 5}, subArray);
    }

    @Test
    public void testCase4() {
        int[] subArray = LongestSubArrayWithAbsoluteDifference.solve(new int[] {5, 5, 20, 21, 22}, 5);
        Assert.assertArrayEquals(new int[] {20, 21, 22}, subArray);
    }

}
