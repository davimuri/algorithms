package algorithms.searching;

import java.util.*;

public class TopKWithLinkedList {
    private Node head = null;
    private Node tail = null;

    private class Node {
        int value;
        int freq;
        Node next;
        Node prev;

        Node(int v, int f) {
            value = v;
            freq = f;
        }

        public String toString() {
            return "(" + value + ", " + freq + ")";
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        head = null;
        tail = null;
        Map<Integer, Node> numToFreq = new HashMap<>();
        for (int e : nums) {
            Node node = numToFreq.get(e);
            if (node == null) {
                node = new Node(e, 1);
                numToFreq.put(e, node);
                if (tail == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
            } else {
                node.freq++;
                move(node);
            }
        }
        Node current = head;
        for (int i = 0; i < k; i++) {
            res.add(current.value);
            current = current.next;
        }
        return res;
    }

    private void move(Node node) {
        if (node == head) return;

        Node current = node.prev;
        while (current != null && current.freq < node.freq) {
            // linked list before: currentPrev, current, node, nodeNext
            // linked list after: currentPrev, node, current, nodeNext
            Node currentPrev = current.prev;
            Node nodeNext = node.next;

            if (currentPrev != null) {
                currentPrev.next = node;
            } else {
                head = node;
            }
            node.prev = currentPrev;

            node.next = current;
            current.prev = node;

            current.next = nodeNext;
            if (nodeNext != null) {
                nodeNext.prev = current;
            } else {
                tail = current;
            }

            current = currentPrev;
        }
    }

    private void printLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print(String.format("(%d, %d)", current.value, current.freq));
            current = current.next;
        }
        System.out.println();
    }

}
