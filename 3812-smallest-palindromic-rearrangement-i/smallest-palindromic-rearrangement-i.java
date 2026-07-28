class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n/2;
        char[] ch = s.toCharArray();
        char[] first = new char[mid];

        for(int i = 0; i< mid; i++){
            first[i]=ch[i];
        }
        Arrays.sort(first);

        for(int i = 0; i< mid; i++){
            ch[i] = first[i];
            ch[n-1-i] = first[i];
        }

        return new String(ch);
    }
}