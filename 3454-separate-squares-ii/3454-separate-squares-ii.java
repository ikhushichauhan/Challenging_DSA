class Solution {
    static class SegTree {
        int n;
        int[] cover;
        long[] len;
        long[] xs;
        SegTree(long[] xs) {
            this.xs = xs;
            n = xs.length - 1;
            cover = new int[n * 4];
            len = new long[n * 4];
        }
        void add(int ql, int qr, int idx, int l, int r, int val) {
            if (ql >= r || qr <= l) return;
            if (ql <= l && r <= qr) {
                cover[idx] += val;
                pushUp(idx, l, r);
                return;
            }
            int m = (l + r) >>> 1;
            add(ql, qr, idx << 1, l, m, val);
            add(ql, qr, idx << 1 | 1, m, r, val);
            pushUp(idx, l, r);
        }
        void pushUp(int idx, int l, int r) {
            if (cover[idx] > 0) {
                len[idx] = xs[r] - xs[l];
            } else {
                if (l + 1 == r) len[idx] = 0;
                else len[idx] = len[idx << 1] + len[idx << 1 | 1];
            }
        }
        long totalCovered() {
            return len[1];
        }
    }

    public double separateSquares(int[][] squares) {
        int m = squares.length;
        long[] xs = new long[m * 2];
        int k = 0;
        for (int[] s : squares) {
            long x = s[0];
            long l = s[2];
            xs[k++] = x;
            xs[k++] = x + l;
        }
        java.util.Arrays.sort(xs, 0, k);
        int u = 0;
        for (int i = 0; i < k; i++) {
            if (i == 0 || xs[i] != xs[i - 1]) xs[u++] = xs[i];
        }
        long[] ux = new long[u];
        System.arraycopy(xs, 0, ux, 0, u);

        java.util.List<long[]> events = new java.util.ArrayList<>(m * 2);
        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            int L = lowerBound(ux, x);
            int R = lowerBound(ux, x + l);
            if (L < R) {
                events.add(new long[]{y, 1, L, R});
                events.add(new long[]{y + l, -1, L, R});
            }
        }
        events.sort((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        SegTree st = new SegTree(ux);
        long total = 0;
        long prevY = events.isEmpty() ? 0 : events.get(0)[0];
        for (long[] e : events) {
            long y = e[0];
            long dy = y - prevY;
            if (dy > 0) total += st.totalCovered() * dy;
            st.add((int) e[2], (int) e[3], 1, 0, st.n, (int) e[1]);
            prevY = y;
        }

        double half = total / 2.0;
        st = new SegTree(ux);
        double cum = 0.0;
        prevY = events.isEmpty() ? 0 : events.get(0)[0];
        for (int i = 0; i < events.size(); i++) {
            long[] e = events.get(i);
            long y = e[0];
            long dy = y - prevY;
            if (dy > 0) {
                long Lcov = st.totalCovered();
                double add = Lcov * (double) dy;
                if (cum + add >= half) {
                    double need = half - cum;
                    if (Lcov == 0) return prevY;
                    return prevY + need / Lcov;
                }
                cum += add;
            }
            st.add((int) e[2], (int) e[3], 1, 0, st.n, (int) e[1]);
            prevY = y;
        }
        return prevY;
    }

    private int lowerBound(long[] a, long x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x) l = m + 1;
            else r = m;
        }
        return l;
    }
}
