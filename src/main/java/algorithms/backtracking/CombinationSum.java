package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS with backtracking
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    List<List<Integer>> answer;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>());
        return answer;
    }

    private void dfs(int[] candidates, int currentTarget, int index, List<Integer> currentSelected) {
        if (currentTarget == 0) {
            answer.add(new ArrayList<>(currentSelected));
            return;
        }
        if (currentTarget < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int newTarget = currentTarget - candidates[i];
            currentSelected.add(candidates[i]);
            dfs(candidates, newTarget, i, currentSelected);
            currentSelected.remove(currentSelected.size() - 1);
        }
    }

}
