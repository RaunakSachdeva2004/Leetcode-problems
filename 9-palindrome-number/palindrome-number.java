class Solution {
    public boolean isPalindrome(int x) {
        int dig = 0;
        int rev = 0;
        int num = x;
        if(x < 0)  return  false;
        while(x!=0){

            dig  = x%10;
            rev = rev * 10 + dig;
            x /= 10;

        }
        return rev == num;
    }
}