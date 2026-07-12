class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > 2) {
                return false;
            }
        }
        return true;
    }
}