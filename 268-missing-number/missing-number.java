class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int miss =nums.length;
        for(int i = 0; i< nums.length;i++){
                    if(i != nums[i]) {miss = i;  break;}

        }
        return miss;
    }
}