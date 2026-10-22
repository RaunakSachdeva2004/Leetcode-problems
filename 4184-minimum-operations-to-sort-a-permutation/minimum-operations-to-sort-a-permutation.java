
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;

        // Find the position of 0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        // Check increasing cyclic order
        boolean increasing = true;

        for (int i = 1; i < n; i++) {
            int prev = (zero + i - 1) % n;
            int curr = (zero + i) % n;

            if (nums[curr] != nums[prev] + 1) {
                increasing = false;
                break;
            }
        }

        if (increasing) {
            // Rotate directly, or reverse-rotate-reverse
            ans = Math.min(ans, zero);
            ans = Math.min(ans, n - zero + 2);
        }

        // Check decreasing cyclic order
        boolean decreasing = true;

        for (int i = 1; i < n; i++) {
            int prev = (zero - i + 1 + n) % n;
            int curr = (zero - i + n) % n;

            if (nums[curr] != nums[prev] + 1) {
                decreasing = false;
                break;
            }
        }

        if (decreasing) {
            // Rotate then reverse, or reverse then rotate
            ans = Math.min(ans, zero + 2);
            ans = Math.min(ans, n - zero);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
