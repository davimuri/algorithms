package algorithms.monotonicqueues;

import java.util.LinkedList;

// Longest subarray in which absolute difference between any two element is not greater than X
// Given an integer array arr[] of size N and an integer X,
// the task is to find the longest sub-array where the absolute difference between any two elements is not greater than X.
// https://www.geeksforgeeks.org/longest-subarray-in-which-absolute-difference-between-any-two-element-is-not-greater-than-x/
public class LongestSubArrayWithAbsoluteDifference {

    public static int[] solve(int[] nums, int x) {
        int start = 0;
        int end = 0;
        int answerStart = 0;
        int answerEnd = 0;
        // increasing monotonic queue
        LinkedList<Integer> minQueue = new LinkedList<>();
        // decreasing monotonic queue
        LinkedList<Integer> maxQueue = new LinkedList<>();
        while (end < nums.length) {
            while (!minQueue.isEmpty() && minQueue.getFirst() > nums[end]) {
                minQueue.removeFirst();
            }
            minQueue.addLast(nums[end]);
            while (!maxQueue.isEmpty() && maxQueue.getFirst() < nums[end]) {
                maxQueue.removeFirst();
            }
            maxQueue.addLast(nums[end]);
            while (maxQueue.getFirst() - minQueue.getFirst() > x) {
                if (minQueue.getFirst() == nums[start]) {
                    minQueue.removeFirst();
                }
                if (maxQueue.getFirst() == nums[start]) {
                    maxQueue.removeFirst();
                }
                start++;
            }
            if (end - start > answerEnd - answerStart) {
                answerStart = start;
                answerEnd = end;
            }
            end++;
        }
        int [] subArray = new int[answerEnd - answerStart + 1];
        System.arraycopy(nums, answerStart, subArray, 0, subArray.length);
        return subArray;
    }
}
