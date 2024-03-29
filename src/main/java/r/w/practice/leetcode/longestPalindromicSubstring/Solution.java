package r.w.practice.leetcode.longestPalindromicSubstring;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
class Solution {

    public String longestPalindrome(String s) {

        if (s == null) {
            return null;
        }
        if (s.equals("")) {
            return "";
        }
        final int length = s.length();
        int maxLength = 1;
        boolean[][] positions = new boolean[length][length];
        int start = 0;
        final char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                final boolean charEquals = chars[i] == chars[j];
                if (i - j < 2) {
                    positions[j][i] = charEquals;
                } else {
                    positions[j][i] = positions[j + 1][i - 1] && charEquals;
                }
                if (i - j + 1 > maxLength && positions[j][i]) {
                    maxLength = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}