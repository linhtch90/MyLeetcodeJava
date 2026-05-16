package org.boris;

import java.util.ArrayList;
import java.util.List;

public class Leetcode39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtracking(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtracking(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int remaining = target - candidates[i];
            current.add(candidates[i]);
            backtracking(candidates, remaining, i, current, results);
            current.removeLast();
        }
    }
}
