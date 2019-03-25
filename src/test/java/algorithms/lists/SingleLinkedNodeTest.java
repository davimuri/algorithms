package algorithms.lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLinkedNodeTest {

    @Test
    public void testListOfEmpty() {
        assertNull(SingleLinkedNode.listOf(null));
    }

    @Test
    public void testListOfOneItem() {
        SingleLinkedNode list = SingleLinkedNode.listOf(1);
        assertEquals(1, list.val);
        assertNull(list.next);
    }

    @Test
    public void testListOfTwoItems() {
        SingleLinkedNode list = SingleLinkedNode.listOf(1, 2);
        assertEquals(1, list.val);
        assertEquals(2, list.next.val);
        assertNull(list.next.next);
    }

    @Test
    public void testEqualsLists() {
        SingleLinkedNode list1 = SingleLinkedNode.listOf(1, 2, 4);
        SingleLinkedNode list2 = SingleLinkedNode.listOf(1, 2, 4);
        assertTrue(list1.equals(list2));
    }

    @Test
    public void testEqualsDifferentValuesSameSize() {
        SingleLinkedNode list1 = SingleLinkedNode.listOf(1, 3, 5);
        SingleLinkedNode list2 = SingleLinkedNode.listOf(1, 2, 4);
        assertFalse(list1.equals(list2));
    }
}
