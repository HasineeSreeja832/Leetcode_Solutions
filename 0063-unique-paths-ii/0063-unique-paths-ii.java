class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If starting cell is an obstacle
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        // Starting cell
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                // Skip starting cell because it is already initialized
                if (i == 0 && j == 0) {
                    continue;
                }

                // If current cell is an obstacle
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } 
                else {

                    // Add paths from above
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }

                    // Add paths from left
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}