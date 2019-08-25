package algorithms.searching;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TopKWithLinkedListTest {

    @Test
    public void testCase1() {
        int[] nums = {5, 3, 1, 1, 1, 3, 73, 1};
        List<Integer> expected = Arrays.asList(1);

        TopKWithLinkedList topK = new TopKWithLinkedList();

        List<Integer> actual = topK.topKFrequent(nums, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        int[] nums = {5, 3, 1, 1, 1, 3, 5, 73, 1};
        List<Integer> expected = Arrays.asList(1, 3, 5);

        TopKWithLinkedList topK = new TopKWithLinkedList();

        List<Integer> actual = topK.topKFrequent(nums, 3);
        Assert.assertEquals(expected, actual);
    }

}
