class Solution {
    public void rotate(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int st = 0; count<n; st++){
            int prev = nums[st];
            int next = st;

            do{
                next = (next+k)  %n;
                int temp=nums[next];
                nums[next]=prev;
                prev = temp;
                count++;
            }while(st!=next);
        }
    }
}