class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        for (int[] sq : squares) {
            totalArea += (long) sq[2] * sq[2];
        }
        double low = 0, high = 1e9 + 1;
        for (int[] sq : squares) {
            high = Math.max(high, sq[1] + sq[2]);
        }
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2;
            double below = 0;
            for (int[] sq : squares) {
                double y = sq[1], l = sq[2];
                if (mid <= y) continue;
                if (mid >= y + l) {
                    below += l * l;
                } else {
                    double h = mid - y;
                    below += l * h;
                }
            }
            if (below * 2 >= totalArea) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }
}
