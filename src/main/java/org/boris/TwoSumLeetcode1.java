package org.boris;

import java.util.HashMap;
import java.util.Map;

public class TwoSumLeetcode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainValue = target - nums[i];
            if (visitedMap.containsKey(remainValue)) {
                return new int[]{i, visitedMap.get(remainValue)};
            }
            visitedMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
