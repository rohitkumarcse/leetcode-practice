// class Solution {
//     public int stoneGameVIII(int[] stones) {
//         int n = stones.length;
//         int[] presum = new int[n];
//         int memo[] = new int[n];
//         Arrays.fill(memo,-1);

//         presum[0] = stones[0];

//         for (int i = 1; i < n; i++)
//             presum[i] = presum[i - 1] + stones[i];

//         return solve(1, presum, n,memo);
//     }

//     public static int solve(int i, int[] presum, int n, int memo[]) {
//         if (i == n - 1)
//             return presum[i];
//         if(memo[i]!=-1) return memo[i];

//         int take = presum[i] - solve(i + 1, presum, n,memo);
//         int skip = solve(i + 1, presum, n,memo);

//         return memo[i]=Math.max(take, skip);
//     }
// }

// iterative


class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        int[] presum = new int[n];
        int[] memo = new int[n];

        presum[0] = stones[0];

        for (int i = 1; i < n; i++) {
            presum[i] = presum[i - 1] + stones[i];
        }

        memo[n - 1] = presum[n - 1];

        for (int i = n - 2; i >= 1; i--) {
            int take = presum[i] - memo[i + 1];
            memo[i] = Math.max(take, memo[i + 1]);
        }

        return memo[1];
    }
}