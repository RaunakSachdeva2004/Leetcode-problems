class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int left = 0;
        int max = 0;
        
        // b c b b b c b a 
        // l
        // r
        // c
        
        for(int r = 0; r < s.length(); r++){
            char cur = s.charAt(r);
            freq[cur-'a']++;


            while(freq[cur-'a'] > 2){
                char l = s.charAt(left);
                freq[l-'a']--;
                left++;
            }


            max = Math.max(max, r-left+1);
        }

        return max;
    }
}