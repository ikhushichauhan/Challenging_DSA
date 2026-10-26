class Solution {
    void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        visited[i][j] = true;

        if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == '1')
            dfs(i - 1, j, grid, visited);

        if (i + 1 < m && !visited[i + 1][j] && grid[i + 1][j] == '1')
            dfs(i + 1, j, grid, visited);

        if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == '1')
            dfs(i, j - 1, grid, visited);

        if (j + 1 < n && !visited[i][j + 1] && grid[i][j + 1] == '1')
            dfs(i, j + 1, grid, visited);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(i, j, grid, visited);
                }
            }
        }

        return count;
    }
}