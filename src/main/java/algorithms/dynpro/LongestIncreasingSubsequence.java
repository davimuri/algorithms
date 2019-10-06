package algorithms.dynpro;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/810/
 */
public class LongestIncreasingSubsequence {

    //int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
    //         10 ->  0  0  0  1  1  2    3   3
    //          9 ->  0  0  0  0  0  0    2   2
    //          2 ->  0  0  0  2  2  3    4   2
    //          3 ->  0  0  0  0  0  2    3   2
    //                2  2  2  2  2  2

    //int[] input = {1, 10, 15, 2, 3};
    //         1 ->  0   2   3  2

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] lis = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    lis[j] = Math.max(lis[i]+1, lis[j]);
                    if (max < lis[j]) {
                        max = lis[j];
                    }
                }
            }
        }
        return max+1;
    }

    /**
     * Keep an array (lis) in ascending order.
     * In each iteration of for loop find a place in lis to insert the current element of nums
     * At the end, the answer is the length of lis
     * @param nums
     * @return
     */
    public int lengthOfLISGreedyWithBinarySearch(int[] nums) {
        if (nums.length == 0) return 0;

        int[] lis = new int[nums.length];
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = length;
            while (left < right) {
                int middle = (left + right) / 2;
                if (lis[middle] < nums[i]) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            lis[left] = nums[i];
            if (left == length) {
                length++;
            }
        }
        return length;
    }

}
