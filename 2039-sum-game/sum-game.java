class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int mid = n / 2;
        
        int leftSum = 0;
        int leftQ = 0;
        int rightSum = 0;
        int rightQ = 0;
        
        // Process left half
        for (int i = 0; i < mid; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                leftQ++;
            } else {
                leftSum += c - '0';
            }
        }
        
        // Process right half
        for (int i = mid; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                rightQ++;
            } else {
                rightSum += c - '0';
            }
        }
        
        // If total question marks is odd, Alice wins
        if ((leftQ + rightQ) % 2 != 0) {
            return true;
        }
        
        // Calculate the difference in sums and question marks
        // Bob wins if: leftSum - rightSum == 9/2 * (rightQ - leftQ)
        // Multiply by 2 to avoid floating point: 2 * (leftSum - rightSum) == 9 * (rightQ - leftQ)
        
        int sumDiff = leftSum - rightSum;
        int qDiff = rightQ - leftQ;
        
        // Alice wins if the condition for Bob is NOT met
        return 2 * sumDiff != 9 * qDiff;
    }
}