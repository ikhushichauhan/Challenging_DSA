import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(
            helper(0, n - 1, nums, dp1),
            helper(1, n, nums, dp2)
        );
    }

    int helper(int i, int n, int[] nums, int[] dp) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Rob
        int rob = nums[i] + helper(i + 2, n, nums, dp);

        // Skip
        int skip = helper(i + 1, n, nums, dp);

        dp[i] = Math.max(rob, skip);

        return dp[i];
    }
}