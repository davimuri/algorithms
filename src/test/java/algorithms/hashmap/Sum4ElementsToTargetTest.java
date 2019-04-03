package algorithms.hashmap;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4ElementsToTargetTest {

    @Test
    public void testBasicCase() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1,  0, 0, 1));
        expected.add(Arrays.asList(-2, -1, 1, 2));
        expected.add(Arrays.asList(-2,  0, 0, 2));
        List<List<Integer>> actual = Sum4ElementsToTarget.fourSum(nums, target);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenArraySameValuesWithOneAnswer() {
        int[] nums = {1, 1, 1, 1};
        int target = 4;
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1,  1, 1, 1));
        List<List<Integer>> actual = Sum4ElementsToTarget.fourSum(nums, target);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenArraySameValuesWithDuplicatedAnswers() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 4;
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1,  1, 1, 1));
        List<List<Integer>> actual = Sum4ElementsToTarget.fourSum(nums, target);

        Assert.assertEquals(expected, actual);
    }

}
