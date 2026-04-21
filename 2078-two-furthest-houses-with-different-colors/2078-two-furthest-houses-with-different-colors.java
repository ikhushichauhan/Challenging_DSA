class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                max = Math.max(max, n - 1 - i);
            }
            if (colors[i] != colors[0]) {
                max = Math.max(max, i);
            }
        }
        
        return max;
    }
}