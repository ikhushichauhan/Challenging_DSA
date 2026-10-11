class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), res, nums);
        return res;
        
    }
    void backtrack(int start, List<Integer> curr, List<List<Integer>> res, int nums[]){
        res.add(new ArrayList<>(curr));
        for(int i = start; i<nums.length; i++){
            if (i>start && nums[i] ==  nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            backtrack(i+1, curr, res, nums);
            curr.remove(curr.size()-1);
        }
    }
}