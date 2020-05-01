package algorithms.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class ArrayBasedHeapTest {

    @Test
    public void testAddOneElement() {
        ArrayBasedHeap<Integer> heap = new ArrayBasedHeap<>();
        heap.add(3);
        Assert.assertFalse(heap.isEmpty());
        Assert.assertEquals(3, heap.peek().intValue());
        Assert.assertEquals(3, heap.pop().intValue());
        Assert.assertTrue(heap.isEmpty());
    }

    @Test
    public void testAddTwoElements() {
        ArrayBasedHeap<Integer> heap = new ArrayBasedHeap<>();
        heap.add(3);
        heap.add(1);
        Assert.assertEquals(1, heap.pop().intValue());
        Assert.assertEquals(3, heap.pop().intValue());
    }

    @Test
    public void testAddTwoElementsReverseOrder() {
        ArrayBasedHeap<Integer> heap = new ArrayBasedHeap<>(Comparator.<Integer>reverseOrder());
        heap.add(1);
        heap.add(3);
        Assert.assertEquals(3, heap.pop().intValue());
        Assert.assertEquals(1, heap.pop().intValue());
    }

    @Test
    public void testAddAndRemoveSequence() {
        ArrayBasedHeap<Integer> heap = new ArrayBasedHeap<>();
        heap.add(3);
        heap.add(1);
        heap.pop();
        heap.add(5);
        Assert.assertEquals(3, heap.pop().intValue());
        Assert.assertEquals(5, heap.pop().intValue());
    }

}
