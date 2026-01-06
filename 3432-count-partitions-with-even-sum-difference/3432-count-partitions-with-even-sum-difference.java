class Solution {
    public int countPartitions(int[] nums) {
        long total = 0;
        for(int x: nums){
            total += x;
        }
        long left = 0;
        int ans = 0;
        for(int i=0;i<nums.length-1;i++){
            left += nums[i];
            long right = total - left;
            if(((left - right) % 2) == 0){
                ans++;
            }
        }
        return ans;
    }
}
