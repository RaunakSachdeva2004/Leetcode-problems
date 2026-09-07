class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;

        // dp[i] = number of distinct subsequences of s[0..i-1]
        long[] dp = new long[s.length() + 1];
        dp[0] = 1; // empty subsequence

        // Last DP value associated with each character
        long[] last = new long[26];

        for (int i = 1; i <= s.length(); i++) {
            int c = s.charAt(i - 1) - 'a';

            // Double the existing subsequences by either taking or not taking c
            dp[i] = (2 * dp[i - 1]) % MOD;

            // Remove duplicates caused by the previous occurrence of c
            dp[i] = (dp[i] - last[c] + MOD) % MOD;

            // For future occurrences of c
            last[c] = dp[i - 1];
        }

        // Exclude the empty subsequence
        return (int) ((dp[s.length()] - 1 + MOD) % MOD);
    }
}