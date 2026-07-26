class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        Arrays.sort(strs);
        int n = strs.length;
        String l = strs[0];
        String r = strs[n-1];

        for(int i = 0; i< Math.min(l.length(), r.length()); i++){
            if(l.charAt(i) != r.charAt(i)) return ans.toString();

            ans.append(l.charAt(i));
        }

        return ans.toString();
    }
}