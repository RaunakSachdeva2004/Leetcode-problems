class Solution {
    public void twoSumHelper(int f, int[] nums, List<List<Integer>> res) {
    int i = f + 1;
    int j = nums.length - 1;

    while (i < j) {
        int sum = nums[f] + nums[i] + nums[j];

        if (sum < 0) {
            i++; // Increase the sum by moving the left pointer
        } else if (sum > 0) {
            j--; // Decrease the sum by moving the right pointer
        } else {
            res.add(Arrays.asList(nums[f], nums[i], nums[j]));
            i++;
            j--;
            
            // Skip duplicates for the second and third elements
            while (i < j && nums[i] == nums[i - 1]) i++;
            while (i < j && nums[j] == nums[j + 1]) j--;
        }
    }
}
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int f = 0; f<nums.length; f++){
            if(nums[f]> 0){
                break;

            }if(f== 0 || nums[f]!= nums[f-1]){
                twoSumHelper(f, nums, res);
            }

        }

        return res;
    }
}