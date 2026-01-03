class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int currmax = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(nums[i-1]<nums[i]){
                currmax = currmax + nums[i];
            }
            else {
                max = Math.max(currmax,max);
                currmax = nums[i];
            }
        }
        max = Math.max(max, currmax);
        return max;
    }
}