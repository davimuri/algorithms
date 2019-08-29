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

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            int oldEnd = Integer.MIN_VALUE;
            if (!mergedIntervals.isEmpty()) {
                oldEnd = mergedIntervals.get(mergedIntervals.size() - 1)[1];
            }
            if (mergedIntervals.isEmpty() || interval[0] > oldEnd) {
                mergedIntervals.add(interval);
            } else if (interval[0] <= oldEnd) {
                mergedIntervals.get(mergedIntervals.size()-1)[1] = Math.max(oldEnd, interval[1]);
            }
        }

        int[][] arrayOutput = new int[mergedIntervals.size()][2];
        int index = 0;
        for (int[] outInterval : mergedIntervals) {
            arrayOutput[index++] = outInterval;
        }

        return arrayOutput;
    }
}
