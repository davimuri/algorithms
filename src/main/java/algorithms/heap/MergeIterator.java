package algorithms.heap;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MergeIterator<T extends Comparable> {
    private T[][] arrays;
    private PriorityQueue<Element> priorityQueue;

    public MergeIterator(T[][] arrays) {
        this.arrays = arrays;
        priorityQueue = new PriorityQueue<>(arrays.length);
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i][0] != null) {
                priorityQueue.add(new Element(arrays[i][0], i));
            }
        }
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There is not more elements in iterator");
        }
        Element element = priorityQueue.poll();
        int newIndex = element.index + 1;
        if (newIndex < arrays[element.arrayIndex].length) {
            T newValue = arrays[element.arrayIndex][newIndex];
            Element newElement = new Element(newValue, element.arrayIndex);
            newElement.index = newIndex;
            priorityQueue.add(newElement);
        }
        return element.value;
    }

    public boolean hasNext() {
        return !priorityQueue.isEmpty();
    }

    private class Element implements Comparable<Element> {
        T value;
        int arrayIndex;
        int index;

        Element(T value, int arrayIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
        }

        @Override
        public int compareTo(Element o) {
            return value.compareTo(o.value);
        }
    }
}
