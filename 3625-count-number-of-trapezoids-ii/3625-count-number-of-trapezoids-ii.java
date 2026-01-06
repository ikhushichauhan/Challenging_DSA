class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        Map<Double, Map<Double, Integer>> slopeToIntercept = new HashMap<>();
        Map<Integer, Map<Double, Integer>> midToSlope = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < i; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dx = x2 - x1, dy = y2 - y1;

                double k = dx == 0 ? Double.MAX_VALUE : (double) dy / dx;
                double b = dx == 0 ? x1 : (double) (y1 * dx - x1 * dy) / dx;

                if (k == -0.0) k = 0.0;
                if (b == -0.0) b = 0.0;

                slopeToIntercept
                        .computeIfAbsent(k, key -> new HashMap<>())
                        .merge(b, 1, Integer::sum);

                int mid = (x1 + x2 + 2000) * 4000 + (y1 + y2 + 2000);
                midToSlope
                        .computeIfAbsent(mid, key -> new HashMap<>())
                        .merge(k, 1, Integer::sum);
            }
        }

        int ans = 0;

        for (var map : slopeToIntercept.values()) {
            int sum = 0;
            for (int cnt : map.values()) {
                ans += sum * cnt;
                sum += cnt;
            }
        }

        for (var map : midToSlope.values()) {
            int sum = 0;
            for (int cnt : map.values()) {
                ans -= sum * cnt;
                sum += cnt;
            }
        }

        return ans;
    }
}
