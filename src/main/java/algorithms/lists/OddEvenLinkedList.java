package algorithms.lists;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * Change in place and linear complexity and constant space complexity
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 */
public class OddEvenLinkedList {

    public static SingleLinkedNode change(SingleLinkedNode head) {
        if (head == null) return null;

        SingleLinkedNode oddPointer = head;
        SingleLinkedNode evenPointer = head.next;
        SingleLinkedNode evenPointerHead = evenPointer;
        while ((oddPointer != null && oddPointer.next != null && oddPointer.next.next != null)
                ||(evenPointer != null && evenPointer.next != null && evenPointer.next.next != null)) {
            if (oddPointer.next != null) {
                oddPointer.next = oddPointer.next.next;
                oddPointer = oddPointer.next;
            }
            if (evenPointer.next != null) {
                evenPointer.next = evenPointer.next.next;
                evenPointer = evenPointer.next;
            }
        }
        oddPointer.next = evenPointerHead;

        return head;
    }
}
