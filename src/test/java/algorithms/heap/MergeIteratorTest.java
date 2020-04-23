package algorithms.heap;

import org.junit.Assert;
import org.junit.Test;

public class MergeIteratorTest {

    @Test
    public void testEmptyInput() {
        MergeIterator<Integer> iterator = new MergeIterator<Integer>(new Integer[1][1]);
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void testEqualElementsInTwoArrays() {
        Integer[][] arrays = {{1, 2}, {1, 3}};
        Integer[] expected = {1, 1, 2, 3};
        MergeIterator<Integer> iterator = new MergeIterator<Integer>(arrays);
        checkIterator(iterator, expected);
    }

    private void checkIterator(MergeIterator<Integer> iterator, Integer[] expected) {
        int i = 0;
        while (iterator.hasNext()) {
            Assert.assertEquals(expected[i], iterator.next());
            i++;
        }
        Assert.assertTrue(i == expected.length);
        Assert.assertFalse(iterator.hasNext());
    }
}
