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
        ListNode nextTemp = curr.next; // Store the next node
        curr.next = prev;              // Reverse the link
        prev = curr;                   // Move prev forward
        curr = nextTemp;               // Move curr forward
    }
    return prev; // New head of the reversed list
}

public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next;

        }

        ListNode p1 = reverseLL(slow), p2 = head;

        while(p1 != null && p2 != null){
            
            if(p1.val != p2.val)  return false;
            
            p1 = p1.next;
            p2= p2.next;
        }

        return true;
    }
}