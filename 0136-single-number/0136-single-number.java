class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;   // a^a=0 a^0=a
        }
        return result;
    }
}