class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        // Find length of linked list
        int n = 0;
        ListNode curr = head;

        while (curr != null) {
            n++;
            curr = curr.next;
        }

        // Minimum size of each part
        int size = n / k;

        // Extra nodes that need to be distributed
        int extra = n % k;

        curr = head;

        for (int i = 0; i < k; i++) {
            result[i] = curr;

            // This part gets one extra node if i < extra
            int partSize = size + (i < extra ? 1 : 0);

            // Move to the last node of this part
            for (int j = 1; j < partSize && curr != null; j++) {
                curr = curr.next;
            }

            // Disconnect this part from the remaining list
            if (curr != null) {
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }

        return result;
    }
}