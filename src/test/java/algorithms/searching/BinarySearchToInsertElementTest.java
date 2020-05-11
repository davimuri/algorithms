package algorithms.searching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinarySearchToInsertElementTest {

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int actual = BinarySearchToInsertElement.findIndexToInsert(nums, 3);
        assertEquals(0, actual);
    }

    @Test
    public void testArray1Element3() {
        int[] nums = {1};
        int actual = BinarySearchToInsertElement.findIndexToInsert(nums, 3);
        assertEquals(1, actual);
    }

    @Test
    public void testArray5Element2() {
        int[] nums = {5};
        int actual = BinarySearchToInsertElement.findIndexToInsert(nums, 2);
        assertEquals(0, actual);
    }

    @Test
    public void testBasicCase() {
        int[] nums = {1, 2, 4, 5};
        int actual = BinarySearchToInsertElement.findIndexToInsert(nums, 3);
        assertEquals(2, actual);
    }

    @Test
    public void givenOddArrayFindZeroIndex() {
        int[] nums = {2, 4, 5};
        int actual = BinarySearchToInsertElement.findIndexToInsert(nums, 1);
        assertEquals(0, actual);
    }

    @Test
    public void givenEvenArrayFindZeroIndex() {
        int[] nums = {2, 4, 5, 6};
        int actual = BinarySearchToInsertElement.findIndexToInsert(nums, 1);
        assertEquals(0, actual);
    }

    @Test
    public void givenOddArrayFindMaxIndex() {
        int[] nums = {2, 4, 5};
        int actual = BinarySearchToInsertElement.findIndexToInsert(nums, 6);
        assertEquals(3, actual);
    }

    @Test
    public void givenEvenArrayFindMaxIndex() {
        int[] nums = {2, 4, 5, 6};
        int actual = BinarySearchToInsertElement.findIndexToInsert(nums, 8);
        assertEquals(4, actual);
    }

    @Test
    public void givenArrayWithGapFindIndexBetweenGapToTheLeft() {
        int[] nums = {2, 4, 20, 21, 22};
        int actual = BinarySearchToInsertElement.findIndexToInsert(nums, 10);
        assertEquals(2, actual);
    }

    @Test
    public void givenArrayWithGapFindIndexBetweenGapToTheRight() {
        int[] nums = {2, 4, 20, 31, 32};
        int actual = BinarySearchToInsertElement.findIndexToInsert(nums, 25);
        assertEquals(3, actual);
    }

    @Test
    public void givenArrayWithDuplicatesFindIndexInDuplicates() {
        int[] nums = {2, 4, 20, 20, 20, 31, 32};
        int actual = BinarySearchToInsertElement.findIndexToInsert(nums, 20);
        assertTrue(2 <= actual && actual <= 5);
    }

}
