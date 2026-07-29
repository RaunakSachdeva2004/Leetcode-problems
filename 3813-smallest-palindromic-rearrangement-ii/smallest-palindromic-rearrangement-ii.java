class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                midChar = (char) ('a' + i);
            }
        }

        int[] halfCounts = new int[26];
        int halfLen = 0;
        for (int i = 0; i < 26; i++) {
            halfCounts[i] = freq[i] / 2;
            halfLen += halfCounts[i];
        }

        StringBuilder sb = new StringBuilder();
        int currentLen = halfLen;

        for (int i = 0; i < halfLen; i++) {
            boolean found = false;
            for (int c = 0; c < 26; c++) {
                if (halfCounts[c] == 0) continue;

                halfCounts[c]--;
                long ways = countPermutations(halfCounts, currentLen - 1, k);

                if (ways >= k) {
                    sb.append((char) ('a' + c));
                    currentLen--;
                    found = true;
                    break;
                } else {
                    k -= ways;
                    halfCounts[c]++;
                }
            }
            if (!found) {
                return "";
            }
        }

        String half = sb.toString();
        StringBuilder res = new StringBuilder(half);
        if (midChar != 0) {
            res.append(midChar);
        }
        res.append(new StringBuilder(half).reverse());
        return res.toString();
    }

    private long countPermutations(int[] counts, int remainingLen, int k) {
        if (remainingLen == 0) return 1;

        long ways = 1;
        int currentN = remainingLen;

        for (int count : counts) {
            if (count == 0) continue;
            if (ways > k) return ways;

            int r = count;
            if (r > currentN / 2) r = currentN - r;

            for (int i = 0; i < r; i++) {
                ways = ways * (currentN - i);
                ways = ways / (i + 1);
                if (ways > k) return ways;
            }

            currentN -= count;
        }

        return ways;
    }
}