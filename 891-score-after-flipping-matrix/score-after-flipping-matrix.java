class Solution {
    public int matrixScore(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // Step 1: Flip rows whose first element is 0
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    grid[i][j] ^= 1;      // toggle bit
                }
            }
        }

        // Step 2: Flip columns if zeros are more than ones
        for (int cl = 1; cl < col; cl++) {
            int zeroCount = 0;

            for (int rw = 0; rw < row; rw++) {
                if (grid[rw][cl] == 0) {
                    zeroCount++;
                }
            }

            if (zeroCount > row / 2) {
                for (int rw = 0; rw < row; rw++) {
                    grid[rw][cl] ^= 1;
                }
            }
        }

        // Step 3: Calculate score
        int ans = 0;

        for (int i = 0; i < row; i++) {
            int val = 0;

            for (int j = 0; j < col; j++) {
                val = (val << 1) | grid[i][j];
            }

            ans += val;
        }

        return ans;
    }
}