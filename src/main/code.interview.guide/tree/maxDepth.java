package tree;

public class maxDepth {
    private int depth;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.right),maxDepth(root.left)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        depth = 0;
        helper(root,1);
        return depth;
    }

    private void helper(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }
        if (curDepth > depth) {
            depth = curDepth;
        }
        helper(root.left, curDepth + 1);
        helper(root.right, curDepth + 1);
    }
}
