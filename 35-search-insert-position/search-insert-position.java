class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while(l <=r){
            int mid = l+(r-l)/2;

            if(target < nums[mid]){
                r=mid-1;
            }
            else if(target > nums[mid]){
                l = mid+1;;
            }

            else if(target == nums[mid]){
                return mid;

            }
        }

        return l;
    }
}