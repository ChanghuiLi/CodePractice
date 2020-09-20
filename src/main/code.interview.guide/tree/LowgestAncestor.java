package tree;

public class LowgestAncestor {
    // 1,设计一个解构能够指向父亲指针；能够指向root;
    // divide and conquer;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,A,B);
        TreeNode right = lowestCommonAncestor(root.right,A,B);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return null;
    }
}
