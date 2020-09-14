package tree;

public class MiniSubTree {
    private TreeNode maxSubTree = null;
    private int res = Integer.MAX_VALUE;
    public TreeNode findSubTree(TreeNode root) {
        helper(root);
        return maxSubTree;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = helper(root.left) + helper(root.right) + root.value;
        if (sum < res) {
            res = sum;
            maxSubTree = root;
        }
        return sum;
    }
}
