package algorithms.dynpro;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testInputOfLengthOne() {
        int[] input = {10};
        int expected = 1;
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int actual = lis.lengthOfLIS(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase1() {
        int[] input = {10,9,2,5,3,7,101,18};
        int expected = 4;
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int actual = lis.lengthOfLIS(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTwoNegatives() {
        int[] input = {-2, -1};
        int expected = 2;
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int actual = lis.lengthOfLIS(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGreedyWithInputOfLengthOne() {
        int[] input = {10};
        int expected = 1;
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int actual = lis.lengthOfLISGreedyWithBinarySearch(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGreedyWithCase1() {
        int[] input = {10,9,2,5,3,7,101,18};
        int expected = 4;
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int actual = lis.lengthOfLISGreedyWithBinarySearch(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGreedyWithTwoNegatives() {
        int[] input = {-2, -1};
        int expected = 2;
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int actual = lis.lengthOfLISGreedyWithBinarySearch(input);
        Assert.assertEquals(expected, actual);
    }

}
