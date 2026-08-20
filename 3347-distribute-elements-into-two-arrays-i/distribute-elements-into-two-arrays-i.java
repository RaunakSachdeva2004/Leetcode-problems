class Solution {
    public int[] resultArray(int[] nums) {
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];
        int n1 = 0, n2 = 0;

        arr1[0] = nums[0];
        n1++;

        arr2[0] = nums[1];
        n2++;

        for (int i = 2; i < nums.length; i++) {
            if (arr1[n1 - 1] > arr2[n2 - 1]) {
                arr1[n1++] = nums[i];
            } else {
                arr2[n2++] = nums[i];
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < n1; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < n2; i++) {
            result[n1 + i] = arr2[i];
        }

        return result;
    }
}