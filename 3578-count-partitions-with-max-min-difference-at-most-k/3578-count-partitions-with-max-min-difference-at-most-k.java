class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length, mod = 1000000007;
        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];
        dp[0] = 1;
        pref[0] = 1;
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();
        int left = 0;
        for (int right = 0; right < n; right++) {
            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[right]) maxD.pollLast();
            maxD.addLast(right);
            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[right]) minD.pollLast();
            minD.addLast(right);
            while (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {
                if (maxD.peekFirst() == left) maxD.pollFirst();
                if (minD.peekFirst() == left) minD.pollFirst();
                left++;
            }
            long add = pref[right] - (left > 0 ? pref[left - 1] : 0);
            add %= mod;
            if (add < 0) add += mod;
            dp[right + 1] = add;
            pref[right + 1] = (pref[right] + dp[right + 1]) % mod;
        }
        return (int) dp[n];
    }
}
