package algorithms.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayBasedHeap<E> {

    private final List<E> list;
    private final Comparator<? super E> comparator;

    public ArrayBasedHeap() {
        this(null);
    }

    public ArrayBasedHeap(Comparator<E> comparator) {
        this(10, comparator);
    }

    public ArrayBasedHeap(int initialCapacity, Comparator<E> comparator) {
        list = new ArrayList<>(initialCapacity);
        this.comparator = comparator;
    }

    public void add(E element) {
        list.add(element);
        siftUp();
    }

    public E peek() {
        if (list.isEmpty()) throw new IndexOutOfBoundsException("Heap is empty");

        return list.get(0);
    }

    public E pop() {
        if (list.isEmpty()) throw new IndexOutOfBoundsException("Heap is empty");

        E element = list.remove(0);
        if (!list.isEmpty()) {
            list.add(0, list.remove(list.size() - 1));
            siftDown();
        }
        return element;
    }

    public E replace(E element) {
        if (list.isEmpty()) throw new IndexOutOfBoundsException("Heap is empty");

        E ret = list.remove(0);
        list.add(0, element);
        siftDown();
        return ret;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    private void siftUp() {
        int childIndex = list.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (parentIndex >= 0
                && compare(list.get(childIndex), list.get(parentIndex)) < 0) {
            swap(parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    private void siftDown() {
        int parentIndex = 0;
        int childIndex1 = (2 * parentIndex) + 1;
        int childIndex2 = childIndex1 + 1;
        boolean swap = true;
        while (childIndex1 < list.size() && swap) {
            swap = false;
            if (compare(list.get(parentIndex), list.get(childIndex1)) > 0) {
                swap(parentIndex, childIndex1);
                parentIndex = childIndex1;
                childIndex1 = (2 * parentIndex) + 1;
                childIndex2 = childIndex1 + 1;
                swap = true;
            } else if (childIndex2 < list.size() && compare(list.get(parentIndex), list.get(childIndex2)) > 0) {
                swap(parentIndex, childIndex2);
                parentIndex = childIndex2;
                childIndex1 = (2 * parentIndex) + 1;
                childIndex2 = childIndex1 + 1;
                swap = true;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    private void swap(int i, int j) {
        E tmp = list.remove(i);
        list.add(i, list.remove(j-1));
        list.add(j, tmp);
    }
}
