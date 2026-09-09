class Solution {
    public long countCommas(long n) {
        if (n <= 999) return 0;

        if (n <= 999999)
            return n - 999;

        long prev = 1_000_000L - 1_000L;

        if (n < 1_000_000_000L)
            return (n + 1 - 1_000_000L) * 2 + prev;

        prev += (2_000_000_000L - 2_000_000L);

        if (n < 1_000_000_000_000L)
            return (n + 1 - 1_000_000_000L) * 3 + prev;

        prev += (3_000_000_000_000L - 3_000_000_000L);

        if (n < 1_000_000_000_000_000L)
            return (n + 1 - 1_000_000_000_000L) * 4 + prev;

        prev += 4L * (1_000_000_000_000_000L
                    - 1_000_000_000_000L);

        return 5 + prev;
    }
}
