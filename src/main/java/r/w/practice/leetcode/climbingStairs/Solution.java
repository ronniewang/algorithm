package r.w.practice.leetcode.climbingStairs;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
class Solution {

    public int climbStairs(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("can not less than zero");
        }
        int[] dp = new int[2];
        if (n <= 2) {
            return n;
        }
        dp[0] = 1;
        dp[1] = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            int tmp = dp[0] + dp[1];
            res = tmp;
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        return res;
    }

    public static void main(String[] args) {

        final int n = new Solution().climbStairs(5);
        System.out.println("n = " + n);
    }
}