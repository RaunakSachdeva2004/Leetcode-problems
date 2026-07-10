class Solution {
    public int arrayPairSum(int[] nums) {
        int k = 10000;
        int sum = 0;
        int[] count = new int[2*k+1];
        int n = nums.length;
        for(int i = 0; i<n; i++){
            count[nums[i]+k]++;
        }

        boolean flag = true;
        for(int i = 0; i< 2*k+1; i++){
            while(count[i]>0){
                sum+=flag ? i-k : 0;
                flag = !flag;
                count[i]--;

            }

        }

        return sum;
    }
}