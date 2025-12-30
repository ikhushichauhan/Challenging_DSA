class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, count = 0;
        for (int i = 0; i + 2 < rows; i++) {
            for (int j = 0; j + 2 < cols; j++) {
                if (isMagic(grid, i, j)) count++;
            }
        }
        return count;
    }
    private boolean isMagic(int[][] g, int r, int c) {
        boolean[] seen = new boolean[16];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = g[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }
        int s = g[r][c] + g[r][c+1] + g[r][c+2];
        if (g[r+1][c] + g[r+1][c+1] + g[r+1][c+2] != s) return false;
        if (g[r+2][c] + g[r+2][c+1] + g[r+2][c+2] != s) return false;
        if (g[r][c] + g[r+1][c] + g[r+2][c] != s) return false;
        if (g[r][c+1] + g[r+1][c+1] + g[r+2][c+1] != s) return false;
        if (g[r][c+2] + g[r+1][c+2] + g[r+2][c+2] != s) return false;
        if (g[r][c] + g[r+1][c+1] + g[r+2][c+2] != s) return false;
        if (g[r][c+2] + g[r+1][c+1] + g[r+2][c] != s) return false;
        return true;
    }
}
