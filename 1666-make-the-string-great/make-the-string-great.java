class Solution {
    public String makeGood(String s) {
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()){

            int len = res.length();

            if(len > 0 && Math.abs(res.charAt(len-1) - ch ) == 32)  
                res.deleteCharAt(len - 1); // pop back
            
            else 
                res.append(ch);
        }
        return res.toString();
    }
}