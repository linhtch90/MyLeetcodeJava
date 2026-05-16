package org.boris;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, 0, results);
        return results;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> results) {
        if (start == nums.length) {
            List<Integer> items = new ArrayList<>();
            for (int i : nums) {
                items.add(i);
            }
            results.add(items);
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, results);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
