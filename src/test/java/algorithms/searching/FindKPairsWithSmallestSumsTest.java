package algorithms.searching;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FindKPairsWithSmallestSumsTest {

    @Test
    public void testEmptyInput() {
        int[] nums1 = {};
        int[] nums2 = {};
        int k = 3;
        List<List<Integer>> expected = Arrays.asList();
        FindKPairsWithSmallestSums algo = new FindKPairsWithSmallestSums();
        List<List<Integer>> actual = algo.kSmallestPairs(nums1, nums2, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase1() {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 6)
        );
        FindKPairsWithSmallestSums algo = new FindKPairsWithSmallestSums();
        List<List<Integer>> actual = algo.kSmallestPairs(nums1, nums2, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 2;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(1, 1)
        );
        FindKPairsWithSmallestSums algo = new FindKPairsWithSmallestSums();
        List<List<Integer>> actual = algo.kSmallestPairs(nums1, nums2, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        int[] nums1 = {1,2};
        int[] nums2 = {3};
        int k = 3;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 3)
        );
        FindKPairsWithSmallestSums algo = new FindKPairsWithSmallestSums();
        List<List<Integer>> actual = algo.kSmallestPairs(nums1, nums2, k);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 10;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3)
        );
        FindKPairsWithSmallestSums algo = new FindKPairsWithSmallestSums();
        List<List<Integer>> actual = algo.kSmallestPairs(nums1, nums2, k);
        Assert.assertEquals(expected, actual);
    }

}
