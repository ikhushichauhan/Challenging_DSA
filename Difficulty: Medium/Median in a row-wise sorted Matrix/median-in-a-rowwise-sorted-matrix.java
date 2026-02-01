class Solution {
    public int median(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
      int min = mat[0][0];
        int max = mat[0][c - 1];
    for (int i = 1; i < r; i++) {
         if (mat[i][0] < min) min = mat[i][0];
            if (mat[i][c - 1] > max) max = mat[i][c - 1];
        }
        int desired = (r * c + 1) / 2;
    while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
        for (int i = 0; i < r; i++) {
                int l = 0, h = c - 1;
                while (l <= h) {
             int m = (l + h) / 2;
                    if (mat[i][m] <= mid) l = m + 1;
                    else h = m - 1;
                }
                place = place + l;
            }
            if (place < desired) min = mid + 1;
            else max = mid;
        }
        return min;
    }
}
