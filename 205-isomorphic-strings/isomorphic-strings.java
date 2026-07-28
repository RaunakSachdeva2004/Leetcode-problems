class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] maps=new int[256];
        int[] mapt=new int[256];

        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(maps[c1] != mapt[c2]) return false;

            maps[c1] = i+1;
            mapt[c2] = i+1;
        }
        return true;
    }
}