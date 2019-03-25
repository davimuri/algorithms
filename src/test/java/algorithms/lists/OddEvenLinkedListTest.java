package algorithms.lists;


import org.junit.Test;

import static org.junit.Assert.*;

public class OddEvenLinkedListTest {

    @Test
    public void testEmptyList() {
        SingleLinkedNode input = SingleLinkedNode.listOf(null);
        SingleLinkedNode expected = null;
        SingleLinkedNode actual = OddEvenLinkedList.change(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testEvenSizeList() {
        SingleLinkedNode input = SingleLinkedNode.listOf(1, 2, 3, 4);
        SingleLinkedNode expected = SingleLinkedNode.listOf(1, 3, 2, 4);
        SingleLinkedNode actual = OddEvenLinkedList.change(input);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testOddSizeList() {
        SingleLinkedNode input = SingleLinkedNode.listOf(1, 2, 3, 4, 5);
        SingleLinkedNode expected = SingleLinkedNode.listOf(1, 3, 5, 2, 4);
        SingleLinkedNode actual = OddEvenLinkedList.change(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testUnorderedList() {
        SingleLinkedNode input = SingleLinkedNode.listOf(2, 1, 3, 5, 6, 4, 7);
        SingleLinkedNode expected = SingleLinkedNode.listOf(2, 3, 6, 7, 1, 5, 4);
        SingleLinkedNode actual = OddEvenLinkedList.change(input);
        assertEquals(expected, actual);
    }

}
