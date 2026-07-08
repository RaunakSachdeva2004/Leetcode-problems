class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum =0, r = 0, l = 0, n = nums.length;
        int minD = Integer.MAX_VALUE;
        while(r < n){
            sum+= nums[r];
            while(sum >=target){
                minD=Math.min(minD, r-l+1);
                sum -= nums[l];
                l++;
            }

            r++;
        }   
        return minD == Integer.MAX_VALUE ? 0 : minD;
    }
}