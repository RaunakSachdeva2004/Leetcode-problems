class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> {
            int x = intervals.get(a).get(0);
            int y = intervals.get(b).get(0);
            if (x != y) return Integer.compare(x, y);
            return Integer.compare(intervals.get(a).get(1), intervals.get(b).get(1));
        });

        long[][] dp = new long[n + 1][5];
        List<Integer>[][] best = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j < 5; j++)
                best[i][j] = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            int id = idx[i];
            int end = intervals.get(id).get(1);
            int weight = intervals.get(id).get(2);

            int l = i + 1, r = n;

            while (l < r) {
                int m = (l + r) / 2;
                if (intervals.get(idx[m]).get(0) > end)
                    r = m;
                else
                    l = m + 1;
            }

            for (int k = 1; k <= 4; k++) {
                long take = weight + dp[l][k - 1];
                long skip = dp[i + 1][k];

                if (take > skip) {
                    dp[i][k] = take;
                    best[i][k] = new ArrayList<>(best[l][k - 1]);
                    best[i][k].add(id);
                } else if (take < skip) {
                    dp[i][k] = skip;
                    best[i][k] = new ArrayList<>(best[i + 1][k]);
                } else {
                    dp[i][k] = take;
                    List<Integer> a = new ArrayList<>(best[l][k - 1]);
                    a.add(id);
                    List<Integer> b = best[i + 1][k];

                    Collections.sort(a);
                    Collections.sort(b);

                    if (compare(a, b) <= 0)
                        best[i][k] = a;
                    else
                        best[i][k] = new ArrayList<>(b);
                }
            }
        }

        Collections.sort(best[0][4]);
        return best[0][4].stream().mapToInt(Integer::intValue).toArray();
    }

    private int compare(List<Integer> a, List<Integer> b) {
        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i)))
                return Integer.compare(a.get(i), b.get(i));
        }

        return Integer.compare(a.size(), b.size());
    }
}