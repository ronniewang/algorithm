package r.w.practice.leetcode.uniquePaths;

class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        final long start = System.currentTimeMillis();
        final int i = new UniquePaths().uniquePaths(30, 30);
        System.out.println("i = " + i);
        final long end = System.currentTimeMillis();
        System.out.println("end-start = " + (end - start));
    }
}