package algorithms.sorting;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/803/
 */
public class MergeIntervals {

    private class IntervalElement {
        private int value;
        private boolean start;

        private IntervalElement(int val, boolean start) {
            this.value = val;
            this.start = start;
        }

    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        List<IntervalElement> intervalElements = new ArrayList<>(intervals.length * 2);
        for (int[] interval : intervals) {
            intervalElements.add(new IntervalElement(interval[0], true));
            intervalElements.add(new IntervalElement(interval[1], false));
        }
        intervalElements.sort(Comparator.comparingInt(ie -> ie.value));

        List<int[]> output = new ArrayList<>();
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (IntervalElement ie : intervalElements) {
            if (ie.start && start > ie.value) {
                start = ie.value;
            } else if (!ie.start && end < ie.value) {
                end = ie.value;
            } else if (ie.start && ie.value > end && end != Integer.MIN_VALUE) {
                output.add(new int[] {start, end});
                start = ie.value;
                end = Integer.MIN_VALUE;
            }
        }
        if (start <= end) {
            output.add(new int[] {start, end});
        }

        int[][] arrayOutput = new int[output.size()][2];
        int index = 0;
        for (int[] outInterval : output) {
            arrayOutput[index++] = outInterval;
        }

        return arrayOutput;
    }
}
