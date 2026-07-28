class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int max = (nums[n-1]-1)*(nums[n-2]-1);
        return max;
    }
}