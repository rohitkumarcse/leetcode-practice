class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] prefixXor = new int[n + 1];
        prefixXor[0] = 0;

        for (int i = 1; i <= n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i - 1];
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int i = queries[q][0];
            int j = queries[q][1];

            ans[q] = prefixXor[j + 1] ^ prefixXor[i];
        }

        return ans;
    }
}