class Solution {
    public int mySqrt(int x) {
       
        if (x < 2) return x;

        int l = 1;
        int r = x;
        int ans = 1;
       
        while(l <=r){
            int mid = l+(r-l)/2;

            if((long)mid * mid <= x)  {
                ans = mid;
                l = mid+1;
            }
            else { 
                r = mid-1;
            }

        }

        return ans;
    }
}