class Solution {
    public int lastStoneWeightII(int[] stones) {

        int total = 0;

        // Find total weight
        for (int stone : stones) {
            total += stone;
        }

        int target = total / 2;

        // dp[j] = can we make sum j?
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        // 0/1 Knapsack
        for (int stone : stones) {

            for (int j = target; j >= stone; j--) {

                dp[j] = dp[j] || dp[j - stone];
            }
        }

        // Find the largest possible sum <= target
        int best = 0;

        for (int j = target; j >= 0; j--) {

            if (dp[j]) {
                best = j;
                break;
            }
        }

        return total - 2 * best;
    }
}