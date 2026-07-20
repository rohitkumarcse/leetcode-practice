class Solution {
    static final long MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length;

        ArrayList<Integer>[] gps = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            gps[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            gps[u].add(v);
            gps[v].add(u);
        }

        int max = maxDepth(gps, 0, -1);

        return (int) power(2, max - 1);
    }

    public int maxDepth(ArrayList<Integer>[] gps, int u, int parent) {
        int depth = 0;

        for (int v : gps[u]) {
            if (v != parent) {
                depth = Math.max(depth, maxDepth(gps, v, u) + 1);
            }
        }

        return depth;
    }

    public long power(long base, int exp) {
        long ans = 1;

        while (exp > 0) {
            if ((exp & 1) != 0) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return ans;
    }
}