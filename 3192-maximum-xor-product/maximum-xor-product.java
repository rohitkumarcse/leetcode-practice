class Solution {
    int mod = 1000000007;

    public int maximumXorProduct(long a, long b, int n) {
        long axora = 0;
        long bxorb = 0;

        // Bits >= n cannot be changed
        for (int i = 49; i >= n; i--) {
            long tmp = 1L << i;

            boolean ath = ((a >> i) & 1L) != 0;
            boolean bth = ((b >> i) & 1L) != 0;

            if (ath) {
                axora ^= tmp;
            }

            if (bth) {
                bxorb ^= tmp;
            }
        }

        // Bits [0, n - 1] can be changed
        for (int i = n - 1; i >= 0; i--) {
            long tmp = 1L << i;

            boolean ath = ((a >> i) & 1L) != 0;
            boolean bth = ((b >> i) & 1L) != 0;

            if (ath == bth) {
                // If both bits are same, XORing both with 1
                // makes both values have this bit set if needed.
                axora ^= tmp;
                bxorb ^= tmp;
            } else {
                // Give the current bit to the smaller number
                if (axora < bxorb) {
                    axora ^= tmp;
                } else {
                    bxorb ^= tmp;
                }
            }
        }
        axora = ( axora % mod );
        bxorb = ( bxorb % mod );

        return (int) ((axora * bxorb) % mod);
    }
}