class Solution {
    public void moveZeroes(int[] nums) {
        int ind = 0;
        int n = nums.length;
        for(int num : nums){
            if(num != 0){
                nums[ind] = num;
                ind++;
            }


        }
        while(ind < n){
            nums[ind] = 0;
            ind++;
        }
    }
}