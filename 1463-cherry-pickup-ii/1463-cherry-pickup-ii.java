class Solution {

    int rows;
    int cols;
    int[][][] dp;

    public int cherryPickup(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        dp = new int[rows][cols][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(grid, 0, 0, cols - 1);
    }

    private int solve(int[][] grid, int row, int col1, int col2) {

        // Outside the grid
        if (col1 < 0 || col1 >= cols ||
            col2 < 0 || col2 >= cols) {
            return Integer.MIN_VALUE;
        }

        // Already calculated
        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        // Last row
        if (row == rows - 1) {

            if (col1 == col2) {
                return dp[row][col1][col2] = grid[row][col1];
            }

            return dp[row][col1][col2] =
                    grid[row][col1] + grid[row][col2];
        }

        // Current cherries
        int cherries;

        if (col1 == col2) {
            cherries = grid[row][col1];
        } else {
            cherries = grid[row][col1] + grid[row][col2];
        }

        int maxNext = Integer.MIN_VALUE;

        // Robot 1 moves -1, 0, +1
        // Robot 2 moves -1, 0, +1
        for (int move1 = -1; move1 <= 1; move1++) {

            for (int move2 = -1; move2 <= 1; move2++) {

                int next = solve(
                    grid,
                    row + 1,
                    col1 + move1,
                    col2 + move2
                );

                maxNext = Math.max(maxNext, next);
            }
        }

        return dp[row][col1][col2] = cherries + maxNext;
    }
}