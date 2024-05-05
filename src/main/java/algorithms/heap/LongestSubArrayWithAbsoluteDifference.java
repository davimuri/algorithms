package algorithms.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        while (end < nums.length) { // O(N)
            minHeap.add(nums[end]); // O(log N)
            maxHeap.add(nums[end]);
            if (maxHeap.peek() - minHeap.peek() <= x) {
                if (end - start > answerEnd - answerStart) {
                    answerStart = start;
                    answerEnd = end;
                }
            } else {
                while (!maxHeap.isEmpty() && maxHeap.peek() - minHeap.peek() > x) {
                    maxHeap.remove(nums[start]);
                    minHeap.remove(nums[start]);
                    start++;
                }
            }
            end++;
        }
        int[] subArray = new int[answerEnd - answerStart + 1];
        if (answerEnd - answerStart + 1 >= 0) {
            System.arraycopy(nums, answerStart, subArray, 0, answerEnd - answerStart + 1);
        }
        return subArray;
    }
}
