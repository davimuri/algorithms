package algorithms.hashmap;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * The solution set must not contain duplicate quadruplets.
 */
public class Sum4ElementsToTarget {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) return null;

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0) return res;

        Map<Integer, List<int[]>> mapSum2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                int[] indexes = {i, j};
                List<int[]> list = mapSum2.get(sum);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(indexes);
                mapSum2.put(sum, list);
            }
        }


        Set<String> duplicates = new HashSet<>();
        for (Map.Entry<Integer, List<int[]>> entry : mapSum2.entrySet()) {
            int newTarget = target - entry.getKey();
            List<int[]> indexesNewT = mapSum2.get(newTarget);
            if (indexesNewT != null) {
                res.addAll(buildAnswers(
                        entry.getValue(), indexesNewT, nums, duplicates));
            }
        }

        return res;
    }

    private static List<List<Integer>> buildAnswers(List<int[]> indexes1,
                                             List<int[]> indexes2,
                                             int[] nums, Set<String> duplicates) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] arr1 : indexes1) {
            for (int[] arr2 : indexes2) {
                if (duplicatedElements(arr1, arr2)) continue;

                int[] anAnswer = {nums[arr1[0]], nums[arr1[1]],
                        nums[arr2[0]], nums[arr2[1]]};
                Arrays.sort(anAnswer);
                String dupElement = Arrays.toString(anAnswer);
                if (!duplicates.contains(dupElement)) {
                    res.add(Arrays.asList(anAnswer[0],
                            anAnswer[1],
                            anAnswer[2],
                            anAnswer[3]));
                    duplicates.add(dupElement);
                }
            }
        }
        return res;
    }

    private static boolean duplicatedElements(int[] arr1, int[] arr2) {
        for (int e1 : arr1) {
            for (int e2 : arr2) {
                if (e1 == e2) return true;
            }
        }
        return false;
    }
}
