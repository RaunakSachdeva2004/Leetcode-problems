class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        // Find size and tail
        ListNode curr = head;
        ListNode tail = null;
        int size = 0;

        while (curr != null) {
            tail = curr;
            curr = curr.next;
            size++;
        }

        k = k % size;

        // No rotation needed
        if (k == 0) return head;

        int diff = size - k;

        // Find the node just before new head
        curr = head;
        int i = 0;

        while (i < diff - 1) {
            curr = curr.next;
            i++;
        }

        ListNode newh = curr.next;

        // Break the list
        curr.next = null;

        // Attach old head after old tail
        tail.next = head;

        return newh;
    }
}