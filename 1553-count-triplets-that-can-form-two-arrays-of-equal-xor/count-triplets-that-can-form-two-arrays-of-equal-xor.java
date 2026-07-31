class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;

        int[] prefixXor = new int[n + 1];
        prefixXor[0] = 0;

        // Build prefix XOR array
        for (int i = 1; i <= n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i - 1];
        }

        int cntTriplets = 0;

        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k <= n; k++) {
                if (prefixXor[i] == prefixXor[k]) {
                    cntTriplets += k - i - 1;
                }
            }
        }

        return cntTriplets;
    }
}