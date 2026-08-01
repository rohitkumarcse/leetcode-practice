class Solution {
    public int largestCombination(int[] candidates) {

        int ans = 0;

        for (int bit = 0; bit <= 31; bit++) {
            int cnt = 0;

            for (int i = 0; i < candidates.length; i++) {
                if ((candidates[i] & (1 << bit)) != 0) {
                    cnt++;
                }
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}