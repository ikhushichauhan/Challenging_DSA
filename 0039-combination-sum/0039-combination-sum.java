class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, target, candidates, new ArrayList<>(), res);
        return res;
        
    }
    void backtrack(int start, int remaining, int candidates[], List<Integer> curr, List<List<Integer>> res){
        if(remaining == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i<candidates.length; i++){
            if(candidates[i]>remaining){
                continue;
            }
            curr.add(candidates[i]);
            backtrack(i, remaining- candidates[i], candidates, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}