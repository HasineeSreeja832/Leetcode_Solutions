class Solution {
    public boolean canPartition(int[] nums) {

        int total = 0;

        // Find total sum
        for (int num : nums) {
            total += num;
        }

        // Odd sum cannot be divided equally
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        // dp[j] = can we make sum j?
        boolean[] dp = new boolean[target + 1];

        // Sum 0 is always possible
        dp[0] = true;

        for (int num : nums) {

            // Go backwards so each number is used only once
            for (int j = target; j >= num; j--) {

                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}