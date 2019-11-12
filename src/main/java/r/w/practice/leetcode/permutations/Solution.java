package r.w.practice.leetcode.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
class Solution {

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null) {
            return Collections.emptyList();
        }
        final ArrayList<List<Integer>> result = new ArrayList<>();
        _perm(nums, 0, nums.length - 1, result);
        return result;
    }

    private void _perm(int[] nums, int start, int end, ArrayList<List<Integer>> result) {

        if (start == end) {
            final ArrayList<Integer> ints = new ArrayList<>();
            for (int num : nums) {
                ints.add(num);
            }
            result.add(ints);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(nums, start, i);
            _perm(nums, start + 1, end, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int start, int i) {

        final int tmp = nums[i];
        nums[i] = nums[start];
        nums[start] = tmp;
    }
}