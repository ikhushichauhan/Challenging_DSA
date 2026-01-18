class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
            }
        }

        java.util.function.Predicate<int[]> isMagic = (params) -> {
            int r = params[0], c = params[1], k = params[2];
            int target = row[r][c + k] - row[r][c];

            for (int i = r; i < r + k; i++) {
                if (row[i][c + k] - row[i][c] != target) return false;
            }
            for (int j = c; j < c + k; j++) {
                if (col[r + k][j] - col[r][j] != target) return false;
            }

            int d1 = 0, d2 = 0;
            for (int i = 0; i < k; i++) {
                d1 += grid[r + i][c + i];
                d2 += grid[r + i][c + k - 1 - i];
            }

            return d1 == target && d2 == target;
        };

        for (int k = Math.min(m, n); k > 1; k--) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (isMagic.test(new int[]{i, j, k})) {
                        return k;
                    }
                }
            }
        }

        return 1;
    }
}
