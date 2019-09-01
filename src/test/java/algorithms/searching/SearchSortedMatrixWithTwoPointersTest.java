package algorithms.searching;

import org.junit.Assert;
import org.junit.Test;

public class SearchSortedMatrixWithTwoPointersTest {

    @Test
    public void testCase1() {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        SearchSortedMatrixWithTwoPointers algorithm = new SearchSortedMatrixWithTwoPointers();
        boolean actual = algorithm.searchMatrix(matrix, target);
        Assert.assertTrue(actual);
    }

    @Test
    public void testCase2() {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 20;
        SearchSortedMatrixWithTwoPointers algorithm = new SearchSortedMatrixWithTwoPointers();
        boolean actual = algorithm.searchMatrix(matrix, target);
        Assert.assertFalse(actual);
    }
}
