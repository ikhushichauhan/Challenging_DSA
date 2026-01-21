class Solution {
    public int[] minBitwiseArray(java.util.List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            if ((x & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            int c = 0;
            int t = x;
            while ((t & 1) == 1) {
                c++;
                t >>= 1;
            }

            ans[i] = x - (1 << (c - 1));
        }
        return ans;
    }
}