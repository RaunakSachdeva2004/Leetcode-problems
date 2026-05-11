class Solution {
     public boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n/2;
        int countl = 0, countr = 0;

        int i = 0, j = mid;

        while(i<mid && j< n)
        {
            if(isVowel(s.charAt(i)))   countl++;
            if(isVowel(s.charAt(j)))   countr++;
            i++; j++;
        }

        return countl == countr;
    }
}