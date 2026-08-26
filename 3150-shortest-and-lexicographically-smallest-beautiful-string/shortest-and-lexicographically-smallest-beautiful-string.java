class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String result = "";
        int minLen = Integer.MAX_VALUE;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') {
                    count++;
                }

                if (count == k) {
                    int currentLen = j - i + 1;
                    String currentSub = s.substring(i, j + 1);

                    if (currentLen < minLen) {
                        minLen = currentLen;
                        result = currentSub;
                    } else if (currentLen == minLen) {
                        if (result.equals("") || currentSub.compareTo(result) < 0) {
                            result = currentSub;
                        }
                    }
                    break; 
                }
            }
        }

        return result;
    }
}