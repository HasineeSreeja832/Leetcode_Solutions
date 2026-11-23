import java.util.*;

class Solution {

    public long subArrayRanges(int[] nums) {

        long sumMax = sumSubarrayMax(nums);
        long sumMin = sumSubarrayMin(nums);

        return sumMax - sumMin;
    }

    // Find sum of all subarray minimums
    private long sumSubarrayMin(int[] nums) {

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous smaller
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] > nums[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        // Next smaller or equal
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] >= nums[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n - i;
            } else {
                right[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {

            sum += (long) nums[i] * left[i] * right[i];
        }

        return sum;
    }

    // Find sum of all subarray maximums
    private long sumSubarrayMax(int[] nums) {

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous greater
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] < nums[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        // Next greater or equal
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] <= nums[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n - i;
            } else {
                right[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {

            sum += (long) nums[i] * left[i] * right[i];
        }

        return sum;
    }
}