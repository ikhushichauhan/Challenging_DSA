class Solution {
    public int missingNumber(int[] nums) {
        int range = nums.length;
        int totalsum = range*(range+1)/2;

        int currsum = 0;

        for(int i =0; i<nums.length; i++){
            currsum = currsum + nums[i];
        }
        int ans = totalsum - currsum;
        return ans;
        
    }
}