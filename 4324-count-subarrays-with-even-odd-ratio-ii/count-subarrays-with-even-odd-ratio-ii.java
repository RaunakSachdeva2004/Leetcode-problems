import java.util.*;

class Solution {
    static class Fenwick {
        int n;
        ArrayList<Long>[] vals;
        int[][] bit;

        Fenwick(int n) {
            this.n = n;
            vals = new ArrayList[n + 2];
            for (int i = 0; i <= n + 1; i++) vals[i] = new ArrayList<>();
        }

        void prepare(int[] odd, long[] v) {
            int m = odd.length;
            for (int i = 0; i < m; i++) {
                int idx = odd[i] + 1;
                while (idx <= n + 1) {
                    vals[idx].add(v[i]);
                    idx += idx & -idx;
                }
            }
            bit = new int[n + 2][];
            for (int i = 1; i <= n + 1; i++) {
                Collections.sort(vals[i]);
                ArrayList<Long> u = new ArrayList<>();
                for (long x : vals[i]) {
                    if (u.isEmpty() || u.get(u.size() - 1) != x) u.add(x);
                }
                vals[i] = u;
                bit[i] = new int[u.size() + 1];
            }
        }

        int lower(ArrayList<Long> a, long x) {
            int l = 0, r = a.size();
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (a.get(mid) < x) l = mid + 1;
                else r = mid;
            }
            return l;
        }

        void addInner(int[] b, int idx) {
            while (idx < b.length) {
                b[idx]++;
                idx += idx & -idx;
            }
        }

        int sumInner(int[] b, int idx) {
            int s = 0;
            while (idx > 0) {
                s += b[idx];
                idx -= idx & -idx;
            }
            return s;
        }

        void update(int odd, long v) {
            int idx = odd + 1;
            while (idx <= n + 1) {
                int p = lower(vals[idx], v) + 1;
                addInner(bit[idx], p);
                idx += idx & -idx;
            }
        }

        int query(int oddLess, long v) {
            int res = 0;
            int idx = oddLess;
            while (idx > 0) {
                int p = lower(vals[idx], v);
                int total = sumInner(bit[idx], bit[idx].length - 1);
                int less = sumInner(bit[idx], p);
                res += total - less;
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int[] odd = new int[n + 1];
        long[] val = new long[n + 1];
        int o = 0, e = 0;
        odd[0] = 0;
        val[0] = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & 1) == 0) e++;
            else o++;
            odd[i + 1] = o;
            val[i + 1] = 1L * b * e - 1L * a * o;
        }

        Fenwick fw = new Fenwick(n);
        fw.prepare(odd, val);

        long ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += fw.query(odd[i], val[i]);
            fw.update(odd[i], val[i]);
        }
        return ans;
    }
}