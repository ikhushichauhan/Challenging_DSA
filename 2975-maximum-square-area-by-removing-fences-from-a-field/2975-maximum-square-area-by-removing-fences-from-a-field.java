class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final int MOD = 1_000_000_007;

        List<Integer> h = new ArrayList<>();
        h.add(1);
        for (int fence : hFences) h.add(fence);
        h.add(m);

        List<Integer> v = new ArrayList<>();
        v.add(1);
        for (int fence : vFences) v.add(fence);
        v.add(n);

        Collections.sort(h);
        Collections.sort(v);

        Set<Integer> hGaps = new HashSet<>();
        for (int i = 0; i < h.size(); i++) {
            for (int j = 0; j < i; j++) {
                hGaps.add(h.get(i) - h.get(j));
            }
        }

        int maxSide = 0;

        for (int i = 0; i < v.size(); i++) {
            for (int j = 0; j < i; j++) {
                int gap = v.get(i) - v.get(j);
                if (hGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }
        maxSide = Math.min(maxSide, Math.min(m - 1, n - 1));

        if (maxSide <= 0) {
            return -1;
        }

        return (int)((1L * maxSide * maxSide) % MOD);
    }
}
