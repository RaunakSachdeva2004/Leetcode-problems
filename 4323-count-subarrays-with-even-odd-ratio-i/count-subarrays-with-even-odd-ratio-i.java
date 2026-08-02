class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int evenCount = 0;
            int oddCount = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }

                if (oddCount > 0) {
                    if ((long) b * evenCount <= (long) a * oddCount) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}