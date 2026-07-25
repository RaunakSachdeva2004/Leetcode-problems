class Solution {
    public int sqsum(int n ){
        int sum = 0;
        while( n>0){
            int d = n%10;
            sum+= d*d;
            n = n/10;
        }

        return sum;
    }
    
    public boolean isHappy(int n) {
        int slow = n, fast=n;
        while(fast!=1){
            slow = (sqsum(slow));
            fast = sqsum(sqsum(fast));

            if(fast ==1) return true;
            if (slow == fast) return false;
        }

        return true;
    }
}