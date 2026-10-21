
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Case 1: Already sorted
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        // Case 2: Length 2 cannot be sorted
        if (n == 2) {
            return -1;
        }

        char minChar = 'z';
        char maxChar = 'a';

        // Find minimum and maximum characters
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            minChar = (char) Math.min(minChar, c);
            maxChar = (char) Math.max(maxChar, c);
        }

        // Case 3: One operation is sufficient
        if (s.charAt(0) == minChar ||
            s.charAt(n - 1) == maxChar) {
            return 1;
        }

        // Case 4: Check the middle characters
        for (int i = 1; i < n - 1; i++) {
            char c = s.charAt(i);

            if (c == minChar || c == maxChar) {
                return 2;
            }
        }

        // Case 5: Otherwise, three operations are needed
        return 3;
    }
}
