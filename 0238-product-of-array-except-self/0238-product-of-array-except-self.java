class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int right [] = new int [n];
        int pro = 1;
        for(int i=n-1; i>=0; i--){
            pro = pro * nums[i];
            right[i] = pro;
        }

        
        int ans[] = new int[n];
        int left = 1;

        for(int i=0; i<n-1; i++){
            int val = left * right[i+1];
            ans[i] = val;
            left = left * nums[i]; 
        }

        ans[n-1] = left;
        return ans;
    }
}