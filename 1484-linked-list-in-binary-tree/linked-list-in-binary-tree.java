class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }

        // Try starting the linked list from this tree node
        if (check(head, root)) {
            return true;
        }

        // Try from left and right children
        return isSubPath(head, root.left) ||
               isSubPath(head, root.right);
    }

    private boolean check(ListNode head, TreeNode root) {
        // Linked list completely matched
        if (head == null) {
            return true;
        }

        // Tree path ended before linked list
        if (root == null) {
            return false;
        }

        // Values don't match
        if (head.val != root.val) {
            return false;
        }

        // Continue matching along the tree
        return check(head.next, root.left) ||
               check(head.next, root.right);
    }
}