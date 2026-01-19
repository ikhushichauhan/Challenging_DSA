class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
            }
        }
        int left = 0, right = Math.min(m, n), ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(pre, m, n, threshold, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean possible(int[][] pre, int m, int n, int threshold, int length) {
        for (int i = length; i <= m; i++) {
            for (int j = length; j <= n; j++) {
                int total = pre[i][j] - pre[i - length][j] - pre[i][j - length] + pre[i - length][j - length];
                if (total <= threshold) return true;
            }
        }
        return false;
    }
}
