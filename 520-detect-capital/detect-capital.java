    class Solution {
        public boolean detectCapitalUse(String word) {
        int count  = 0;
            char[] newword = word.toCharArray();
        for(char ch : newword) 
            {
                if(ch < 'A' || ch > 'Z')  count++;
            }


            if(count == 0 ||
           count == word.length() ||
           (count == word.length() - 1 &&
            (newword[0] >= 'A' && newword[0] <= 'Z')))
            return true;


            return false;
        }
    }