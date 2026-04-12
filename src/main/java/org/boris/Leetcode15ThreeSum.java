package org.boris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                if ((nums[leftIndex] + nums[rightIndex]) == (0 - nums[i])) {
                    results.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));
                    leftIndex++;
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]) {
                        leftIndex++;
                    }
                }
                if ((nums[leftIndex] + nums[rightIndex]) < (0 - nums[i])) {
                    leftIndex++;
                }
                if ((nums[leftIndex] + nums[rightIndex]) > (0 - nums[i])) {
                    rightIndex--;
                }
            }
        }
        return results;
    }
}
