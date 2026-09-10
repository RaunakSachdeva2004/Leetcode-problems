class Solution {

    private int solve(int[] nums, int start, int end) {

        int n = end - start + 1;

        int[] dp = new int[n];

        dp[0] = nums[start];

        if (n >= 2) {
            dp[1] = Math.max(nums[start], nums[start + 1]);
        }

        for (int i = 2; i < n; i++) {

            int rob = nums[start + i] + dp[i - 2];
            int skip = dp[i - 1];

            dp[i] = Math.max(rob, skip);
        }

        return dp[n - 1];
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        // Case 1: Don't rob last house
        int case1 = solve(nums, 0, n - 2);

        // Case 2: Don't rob first house
        int case2 = solve(nums, 1, n - 1);

        return Math.max(case1, case2);
    }
}