class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int[] diff = new int[nums1.length];
        int max = 0;

        for (int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long sum = 0;
        for (int d : diff) sum += d;

        if (sum <= k) return 0;

        int left = 0, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long need = 0;

            for (int d : diff) {
                if (d > mid) need += d - mid;
            }

            if (need <= k) right = mid;
            else left = mid + 1;
        }

        int limit = left;
        long ans = 0;
        long used = 0;

        for (int d : diff) {
            int nd = Math.min(d, limit);
            used += d - nd;
            ans += (long) nd * nd;
        }

        long remaining = k - used;

        for (int d : diff) {
            if (remaining == 0) break;

            if (d >= limit && d > 0) {
                ans -= (long) limit * limit;
                ans += (long) (limit - 1) * (limit - 1);
                remaining--;
            }
        }

        return ans;
    }
}