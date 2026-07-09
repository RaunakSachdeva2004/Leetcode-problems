class Solution {
    int[] dp;
    public int fib(int n) {
        dp = new int[n+1];
        return solve(n);

        
    }

    public int solve(int n){
        if(n<=1) return n;
        if(dp[n] != 0)  return dp[n];

        int ans = solve(n-1) + solve(n-2);
        dp[n] = ans;
        return ans;
    }
}