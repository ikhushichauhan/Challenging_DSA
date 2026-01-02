class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return x;
            }
        }
        return -1;
    }
}