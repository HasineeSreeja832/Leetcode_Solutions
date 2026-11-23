class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Impossible cases
        if (Math.abs(target) > total) {
            return 0;
        }

        if ((total + target) % 2 != 0) {
            return 0;
        }

        int requiredSum = (total + target) / 2;

        int[] dp = new int[requiredSum + 1];

        dp[0] = 1;

        for (int num : nums) {

            for (int j = requiredSum; j >= num; j--) {

                dp[j] += dp[j - num];
            }
        }

        return dp[requiredSum];
    }
}