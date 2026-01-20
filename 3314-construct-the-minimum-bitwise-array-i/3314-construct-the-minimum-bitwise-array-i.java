class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            if ((x & (x - 1)) == 0) {
                ans[i] = -1;
            } else {
                int t = x + 1;
                int lsb = t & -t;
                ans[i] = x - (lsb >> 1);
            }
        }
        return ans;
    }
}