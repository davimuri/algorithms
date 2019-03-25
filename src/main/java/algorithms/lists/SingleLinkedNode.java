package algorithms.lists;

public class SingleLinkedNode {
    int val;
    SingleLinkedNode next;

    SingleLinkedNode(int x) {
        val = x;
        next = null;
    }

    public static SingleLinkedNode listOf(int...values) {
        if (values == null || values.length == 0) return null;

        SingleLinkedNode head = new SingleLinkedNode(values[0]);
        SingleLinkedNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new SingleLinkedNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj instanceof SingleLinkedNode) {
            SingleLinkedNode list = (SingleLinkedNode) obj;
            SingleLinkedNode current = this;
            while (current != null && list != null && current.val == list.val) {
                current = current.next;
                list = list.next;
            }
            if (current == null && list == null) {
                return true;
            }
        }

        return false;
    }
}
