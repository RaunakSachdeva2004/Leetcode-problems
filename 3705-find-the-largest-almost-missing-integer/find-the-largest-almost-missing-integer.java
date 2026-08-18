import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;
        int answer = -1;

        for (int num : nums) {

            int count = 0;

            // Check every subarray of size k
            for (int i = 0; i <= n - k; i++) {

                // Check if num exists in this window
                for (int j = i; j < i + k; j++) {
                    if (nums[j] == num) {
                        count++;
                        break; // Don't count the same window twice
                    }
                }
            }

            // num appears in exactly one subarray
            if (count == 1) {
                answer = Math.max(answer, num);
            }
        }

        return answer;
    }
}