package algorithms.lists;

import org.junit.Test;

import static algorithms.lists.IntersectionOfTwoLinkedLists.*;
import static org.junit.Assert.*;

public class IntersectionOfTwoLinkedListsTest {

    @Test
    public void testOneListNull() {
        assertNull(find(null, listOf(1, 2)));
    }

    @Test
    public void testSameLength() {
        ListNode intersection = listOf(9, 10, 20);
        ListNode head1 = new ListNode(4);
        head1.next = intersection;
        ListNode head2 = new ListNode(4);
        head2.next = intersection;

        assertEquals(intersection, find(head1, head2));
    }

    @Test
    public void testDifferentLengthOfOne() {
        ListNode intersection = listOf(9);
        ListNode head1 = new ListNode(4);
        head1.next = intersection;
        ListNode head2 = listOf(1, 2);
        head2.next.next = intersection;

        assertEquals(intersection, find(head1, head2));
    }

    @Test
    public void testDifferentLengthOfTen() {
        ListNode intersection = listOf(9);
        ListNode head1 = new ListNode(4);
        head1.next = intersection;
        ListNode head2 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        ListNode tail = head2;
        while (tail.next != null) { tail = tail.next; }
        tail.next = intersection;

        assertEquals(intersection, find(head1, head2));
    }

    @Test
    public void testNoIntersectionSameLength() {
        assertNull(find(listOf(1, 2), listOf(1, 2)));
    }

    @Test
    public void testNoIntersectionDifferentLengthOfOne() {
        assertNull(find(listOf(1, 2), listOf(1, 2, 3)));
    }

    @Test
    public void testNoIntersectionDifferentLengthOfTwo() {
        assertNull(find(listOf(1, 2), listOf(1, 2, 3, 4)));
    }

}
