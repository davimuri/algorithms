package algorithms.sorting;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/803/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> mergedIntervals = new ArrayList<>(intervals.length);
        mergedIntervals.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int oldEnd = mergedIntervals.get(mergedIntervals.size() - 1)[1];
            if (intervals[i][0] > oldEnd) {
                mergedIntervals.add(intervals[i]);
            } else if (intervals[i][0] <= oldEnd) {
                mergedIntervals.get(mergedIntervals.size()-1)[1] = Math.max(oldEnd, intervals[i][1]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
