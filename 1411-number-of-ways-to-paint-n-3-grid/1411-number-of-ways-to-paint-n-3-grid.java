class Solution {
    static final int MOD = 1_000_000_007;

    public int numOfWays(int n) {
        long aba = 6;
        long abc = 6;

        for (int i = 2; i <= n; i++) {
            long newAba = (aba * 3 + abc * 2) % MOD;
            long newAbc = (aba * 2 + abc * 2) % MOD;
            aba = newAba;
            abc = newAbc;
        }

        return (int) ((aba + abc) % MOD);
    }
}