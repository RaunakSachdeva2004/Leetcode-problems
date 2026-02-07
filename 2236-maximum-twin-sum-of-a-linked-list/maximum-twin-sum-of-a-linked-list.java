/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextNode = curr.next; // Save the rest of the list
            curr.next = prev;              // Flip the pointer
            prev = curr;                   // Move prev forward
            curr = nextNode;               // Move curr forward
        }
        return prev; // New head of the reversed list
    }

    public int pairSum(ListNode head) {

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p1 = head, p2 = reverseLL(slow);
        int max = Integer.MIN_VALUE;
        while(p1 != null && p2 != null){
            int sum = p1.val + p2.val;
            max = Math.max(sum, max);
            p1 = p1.next;
            p2= p2.next;
        }
        return max;
    }
}