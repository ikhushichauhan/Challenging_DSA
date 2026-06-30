class Solution {
    public boolean isMonotonic(int[] nums) {
      boolean inc = true;
      boolean dec = true;
    for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] > nums[i + 1]) {
                inc = false;
        } else if (nums[i] < nums[i + 1]) {
                dec = false;
        }
      }
    if(inc == true || dec == true) {
        return true;
    }
       return false;
        
    }
}