class Solution {
    public String reverseWords(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        // Trim leading spaces
        while (l <= r && s.charAt(l) == ' ') l++;
        // Trim trailing spaces
        while (r >= l && s.charAt(r) == ' ') r--;

        StringBuilder sb = new StringBuilder();
        // Remove internal multiple spaces
        while (l <= r) {
            char c = s.charAt(l);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(' ');
            }
            l++;
        }

        // Step 1: Reverse the whole string
        reverse(sb, 0, sb.length() - 1);

        // Step 2: Reverse each word back
        int start = 0;
        for (int end = 0; end < sb.length(); end++) {
            // Find the end of the word
            if (sb.charAt(end) == ' ') {
                reverse(sb, start, end - 1);
                start = end + 1;
            } else if (end == sb.length() - 1) { // Last word
                reverse(sb, start, end);
            }
        }

        return sb.toString();
    }

    // Helper method to keep code clean
    private void reverse(StringBuilder sb, int i, int j) {
        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++; j--;
        }
    }
}