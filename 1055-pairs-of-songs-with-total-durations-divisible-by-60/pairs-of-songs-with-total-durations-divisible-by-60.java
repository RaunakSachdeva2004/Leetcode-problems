class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remMap = new int[60];
        for(int t : time){
            int rem = t % 60;
            remMap[rem]++;
        }

        int ans = 0;
        for(int i = 1; i< 30; i++){
            ans+=(remMap[i] * remMap[60-i]);
        }

         if (remMap[0] > 1) {
            ans += (long) remMap[0] * (remMap[0] - 1) / 2;
        }

        // Case 3: Count pairs for remainder 30.
        if (remMap[30] > 1) {
            ans += (long) remMap[30] * (remMap[30] - 1) / 2;
        }

        return ans;
    }
}