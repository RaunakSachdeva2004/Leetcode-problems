class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0, j = n-1, k = n-1;
        int[] res = new int[n];
        while(i <= j){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                res[k] = nums[i]*nums[i];
                i++;
            }
            else{
                res[k] = nums[j]*nums[j];
                j--;

            }

            k--;
        }

        return res;
    }
}