class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int negInf = Integer.MIN_VALUE / 2;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = negInf;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int prod = nums1[i - 1] * nums2[j - 1];
                int take = Math.max(prod, prod + dp[i - 1][j - 1]);
                dp[i][j] = Math.max(take, Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        return dp[n][m];
    }
}