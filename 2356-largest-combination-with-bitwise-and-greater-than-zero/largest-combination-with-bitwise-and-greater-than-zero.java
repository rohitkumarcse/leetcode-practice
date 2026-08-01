// class Solution {
//     public int largestCombination(int[] candidates) {

//         int ans = 0;
//         use maxbit = log2(10^7)

//         for (int bit = 0; bit <= 31; bit++) {
//             int cnt = 0;

//             for (int i = 0; i < candidates.length; i++) {
//                 if ((candidates[i] & (1 << bit)) != 0) {
//                     cnt++;
//                 }
//             }

//             ans = Math.max(ans, cnt);
//         }

//         return ans;
//     }
// }


class Solution {
    public int largestCombination(int[] candidates) {

        int ans = 0;

        // Formula:
        // maxBit = floor(log2(maxElement))
        // Number of bits = floor(log2(maxElement)) + 1

        int max = 0;
        for (int x : candidates) {
            max = Math.max(max, x);
        }

        int maxBit = (int) (Math.log(max) / Math.log(2));
        // or: int maxBit = 31 - Integer.numberOfLeadingZeros(max);

        for (int bit = 0; bit <= maxBit; bit++) {
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