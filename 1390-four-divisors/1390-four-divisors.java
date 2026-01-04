class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            int sum = 0;
            int count = 0;
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    int d1 = i;
                    int d2 = n / i;
                    sum += d1;
                    count++;
                    if (d1 != d2) {
                        sum += d2;
                        count++;
                    }
                    if (count > 4) break;
                }
            }
            if (count == 4) ans += sum;
        }
        return ans;
    }
}