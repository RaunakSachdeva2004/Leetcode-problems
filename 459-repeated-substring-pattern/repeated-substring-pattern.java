class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int l = n/2; l>=1; l--){
            if(n%l == 0){
                int times = n/l;
                String patt = s.substring(0,l);
                String newstr="";
                while(times>0){
                    newstr += patt;
                    times--;
                }
                if(newstr.equals(s))  return true;
            }
        }

        return false;
    }
}