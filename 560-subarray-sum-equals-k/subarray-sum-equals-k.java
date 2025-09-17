class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int preSum =0, count = 0;
        map.put(0, 1);
        for(int i = 0; i< nums.length; i++){
            preSum += nums[i];
            int remove = preSum-k;

           // Add the number of times we've seen the 'remove' prefix sum to our count.
            count += map.getOrDefault(remove, 0);
            
            // Add the current prefix sum to the map, incrementing its frequency.
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
         }

         return count;
    }
}