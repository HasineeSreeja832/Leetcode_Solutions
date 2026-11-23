import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        // Initially, assume no greater element exists
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        // Traverse the array twice
        for (int i = 0; i < 2 * n; i++) {

            int index = i % n;

            // Find greater elements for elements in stack
            while (!stack.isEmpty() &&
                   nums[index] > nums[stack.peek()]) {

                int previousIndex = stack.pop();

                ans[previousIndex] = nums[index];
            }

            // Only add indices during the first traversal
            if (i < n) {
                stack.push(index);
            }
        }

        return ans;
    }
}