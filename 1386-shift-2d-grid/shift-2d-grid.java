class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int total = n * m;
        k = k ;

        for (int r = 0; r < k; r++) {

            int last = grid[n - 1][m - 1];

            // Shift every element one position to the right
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {

                    if (i == 0 && j == 0) {
                        grid[i][j] = last;
                    } else if (j == 0) {
                        grid[i][j] = grid[i - 1][m - 1];
                    } else {
                        grid[i][j] = grid[i][j - 1];
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();

            for (int val : row) {
                list.add(val);
            }

            ans.add(list);
        }

        return ans;
    }
}