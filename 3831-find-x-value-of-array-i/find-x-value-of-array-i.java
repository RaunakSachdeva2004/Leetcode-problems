class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int x : nums) {
            long[] ndp = new long[k];

            int rem = x % k;

            ndp[rem]++;

            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int nr = (r * rem) % k;
                    ndp[nr] += dp[r];
                }
            }

            for (int r = 0; r < k; r++) {
                ans[r] += ndp[r];
            }

            dp = ndp;
        }

        return ans;
    }
}