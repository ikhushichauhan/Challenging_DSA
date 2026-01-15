class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        java.util.Arrays.sort(hBars);
        java.util.Arrays.sort(vBars);
        int maxRunH = 1, cur = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) cur++;
            else cur = 1;
            if (cur > maxRunH) maxRunH = cur;
        }
        int maxRunV = 1; cur = 1;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) cur++;
            else cur = 1;
            if (cur > maxRunV) maxRunV = cur;
        }
        int side = Math.min(maxRunH, maxRunV) + 1;
        return side * side;
    }
}
