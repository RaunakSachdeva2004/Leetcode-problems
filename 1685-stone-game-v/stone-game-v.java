class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] mem = new int[n][n];
        int[] prefix = new int[n + 1];
        
        for (int[] row : mem) {
            java.util.Arrays.fill(row, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        
        return solve(stoneValue, 0, n - 1, prefix, mem);
    }
    
    private int solve(int[] stoneValue, int i, int j, int[] prefix, int[][] mem) {
        if (i == j) return 0;
        if (mem[i][j] != Integer.MIN_VALUE) return mem[i][j];
        
        int maxScore = 0;
        
        for (int p = i; p < j; p++) {
            int leftSum = prefix[p + 1] - prefix[i];
            int rightSum = prefix[j + 1] - prefix[p + 1];
            
            if (leftSum < rightSum) {
                maxScore = Math.max(maxScore, leftSum + solve(stoneValue, i, p, prefix, mem));
            } else if (leftSum > rightSum) {
                maxScore = Math.max(maxScore, rightSum + solve(stoneValue, p + 1, j, prefix, mem));
            } else {
                maxScore = Math.max(maxScore, Math.max(leftSum + solve(stoneValue, i, p, prefix, mem), rightSum + solve(stoneValue, p + 1, j, prefix, mem)));
            }
        }
        
        mem[i][j] = maxScore;
        return maxScore;
    }
}