class Solution {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0, index = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (index % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            index++;
            n >>= 1;
        }

        return new int[]{even, odd};
    }
}