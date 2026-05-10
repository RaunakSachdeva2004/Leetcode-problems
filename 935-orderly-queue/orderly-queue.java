class Solution {
    public String orderlyQueue(String s, int k) {
        if(k > 1){
            char[] ch = s.toCharArray();
            java.util.Arrays.sort(ch);
            return new String(ch);
        }

        String res = s;
        for( int i = 1; i < s.length(); i++){
            String temp = s.substring(i) + s.substring(0, i);

            if(temp.compareTo(res) < 0)
                res = temp;
        }
            return res;
    }

    
}