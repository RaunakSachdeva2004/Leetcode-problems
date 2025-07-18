// Using recursion
class Solution {
    public boolean isPalindrome(String s) {
        if( s == null || s.length() == 0)
        return true;
        return isPlaindromeRecursive(s, 0, s.length() -1 );
    }

    private boolean isPlaindromeRecursive(String s, int left, int right){
        if(left >= right){
            return true;
        }

        char leftchar = s.charAt(left);
        char rightchar = s.charAt(right);

        if(!Character.isLetterOrDigit(leftchar)){
            return isPlaindromeRecursive(s, left + 1, right);
        }

        if(!Character.isLetterOrDigit(rightchar)){
            return isPlaindromeRecursive(s, left, right -1);
        }
        

        if(Character.toLowerCase(leftchar) != Character.toLowerCase(rightchar)){
            return false;
        }

        return isPlaindromeRecursive(s, left+1, right-1);
    }
}