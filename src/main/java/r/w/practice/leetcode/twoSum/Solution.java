package r.w.practice.leetcode.twoSum;

import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null) {
            return null;
        }
        final HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int i1 = -1;
        int i2 = -1;
        for (int i = 0; i < nums.length; i++) {
            final Integer index = map.get(target - nums[i]);
            if (index != null && index != i) {
                if (index > i) {
                    i1 = i;
                    i2 = index;
                } else {
                    i1 = index;
                    i2 = i;
                }
                break;
            }
        }
        if (i1 >= 0) {
            return new int[]{i1, i2};
        }
        return null;
    }
}