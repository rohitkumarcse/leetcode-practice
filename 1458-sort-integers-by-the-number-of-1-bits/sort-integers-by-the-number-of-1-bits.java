class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[][] res = new int[n][2];

        for (int i = 0; i < arr.length; i++) {
            res[i][0] = arr[i];
            res[i][1] = countOnes(arr[i]);
        }

        Arrays.sort(res, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = res[i][0];
        }

        return ans;
    }

    public int countOnes(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}