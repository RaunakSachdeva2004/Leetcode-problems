class Solution {
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    // returns {sum of subtree, number of nodes in subtree}
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        // Get information from left and right subtrees
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // Calculate current subtree's sum and count
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;

        // Integer division automatically floors the average
        if (sum / count == root.val) {
            ans++;
        }

        return new int[]{sum, count};
    }
}
