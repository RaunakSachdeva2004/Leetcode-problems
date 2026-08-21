class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long left = 1, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (count(coins, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private long count(int[] coins, long x) {
        int n = coins.length;
        long total = 0;
        for (int i = 1; i < (1 << n); i++) {
            long lcm = 1;
            int bits = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    bits++;
                    lcm = lcm(lcm, coins[j]);
                    if (lcm > x) break;
                }
            }
            if (lcm <= x) {
                long term = x / lcm;
                if ((bits & 1) == 1) total += term;
                else total -= term;
            }
        }
        return total;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd(a, b)) * b;
    }
}