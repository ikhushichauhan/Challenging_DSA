class Solution {
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCross(row, col, cells, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    boolean canCross(int row, int col, int[][] cells, int day) {
        boolean[][] water = new boolean[row][col];
        for (int i = 0; i < day; i++) {
            water[cells[i][0] - 1][cells[i][1] - 1] = true;
        }

        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        boolean[][] vis = new boolean[row][col];

        for (int c = 0; c < col; c++) {
            if (!water[0][c]) {
                q.add(new int[]{0, c});
                vis[0][c] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == row - 1) return true;

            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col &&
                    !water[nr][nc] && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}