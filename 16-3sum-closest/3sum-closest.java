class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closest = nums[0] + nums[1] +nums[2];
        Arrays.sort(nums);

        for(int i = 0; i<= n-3;i++){
            int a = i+1;
            int b = n-1;
            while(a<b){
                int sum = nums[i] + nums[a] + nums[b];

                if(Math.abs(target-sum) < Math.abs(target-closest))  closest = sum;
                
                if(sum == target)  return sum;

                if(sum < target)  a++;
                else b--;
            }
        }

        return closest;    
    }
}