import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        long[] sums = new long[2];
        int[] sizes = new int[2];

        class Window {
            void add(int v) {
                if (left.isEmpty() || v <= left.lastKey()) {
                    left.merge(v, 1, Integer::sum);
                    sums[0] += v;
                    sizes[0]++;
                } else {
                    right.merge(v, 1, Integer::sum);
                    sums[1] += v;
                    sizes[1]++;
                }
                balance();
            }

            void remove(int v) {
                if (left.containsKey(v)) {
                    removeFrom(left, v, 0);
                } else {
                    removeFrom(right, v, 1);
                }
                balance();
            }

            void removeFrom(TreeMap<Integer, Integer> map, int v, int id) {
                map.compute(v, (a, b) -> b == 1 ? null : b - 1);
                sums[id] -= v;
                sizes[id]--;
            }

            void balance() {
                while (sizes[0] > (x + 1) / 2) {
                    int v = left.lastKey();
                    move(left, right, v, 0, 1);
                }
                while (sizes[0] < (x + 1) / 2 && !right.isEmpty()) {
                    int v = right.firstKey();
                    move(right, left, v, 1, 0);
                }
            }

            void move(TreeMap<Integer, Integer> from,
                      TreeMap<Integer, Integer> to, int v, int a, int b) {
                from.compute(v, (q, c) -> c == 1 ? null : c - 1);
                to.merge(v, 1, Integer::sum);
                sums[a] -= v;
                sums[b] += v;
                sizes[a]--;
                sizes[b]++;
            }

            long getCost() {
                long median = left.lastKey();
                return median * sizes[0] - sums[0]
                        + sums[1] - median * sizes[1];
            }
        }

        Window w = new Window();

        for (int i = 0; i < n; i++) {
            w.add(nums[i]);

            if (i >= x) {
                w.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = w.getCost();
            }
        }

        long[][] dp = new long[k + 1][n + 1];

        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];

                if (i >= x) {
                    dp[j][i] = Math.min(dp[j][i],
                            dp[j - 1][i - x] + cost[i - x]);
                }
            }
        }

        return dp[k][n];
    }
}