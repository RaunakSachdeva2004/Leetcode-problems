class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        ListNode prevNode = head;
        ListNode currNode = head.next;

        int position = 1;
        int first = -1;
        int prevCritical = -1;
        int min = Integer.MAX_VALUE;
        int max = -1;

        while (currNode.next != null) {
            int prevValue = prevNode.val;
            int currValue = currNode.val;
            int nextValue = currNode.next.val;

            boolean isCritical =
                    (currValue > prevValue && currValue > nextValue) ||
                    (currValue < prevValue && currValue < nextValue);

            if (isCritical) {
                if (first == -1) {
                    // First critical point
                    first = position;
                } else {
                    // Distance from previous critical point
                    min = Math.min(min, position - prevCritical);

                    // Distance from first critical point
                    max = position - first;
                }

                prevCritical = position;
            }

            prevNode = currNode;
            currNode = currNode.next;
            position++;
        }

        if (max == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{min, max};
    }
}