class Solution {
    int MOD = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long result = 0;
        int digit = 0;

        for (int num = 1; num <= n; num++) {
            if ((num & (num - 1)) == 0) {
                digit++;
            }

            result = ((result << digit) % MOD + num % MOD) % MOD;
        }

        return (int) result;
    }
}