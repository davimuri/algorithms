package algorithms.searching;

import java.util.*;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class FindKPairsWithSmallestSums {

    private int[] nums1;
    private int[] nums2;
    private PriorityQueue<Pair> priorityQueue;

    class Pair {
        int index1, index2, sum;

        Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = nums1[index1] + nums2[index2];
        }

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        priorityQueue = new PriorityQueue<>(k, Comparator.comparingInt( p -> p.sum ));
        addPairToPriorityQueue(0, 0);
        List<List<Integer>> output = new ArrayList<>(k);
        while (!priorityQueue.isEmpty() && output.size() < k) {
            Pair pair = priorityQueue.poll();
            output.add(Arrays.asList(nums1[pair.index1], nums2[pair.index2]));
            addPairToPriorityQueue(pair.index1, pair.index2+1);
            if (pair.index2 == 0) {
                addPairToPriorityQueue(pair.index1+1, 0);
            }
        }
        return output;
    }

    private void addPairToPriorityQueue(int index1, int index2) {
        if (index1 < nums1.length && index2 < nums2.length) {
            priorityQueue.add(new Pair(index1, index2));
        }
    }

}
