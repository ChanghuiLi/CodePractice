package tree;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left.value != root.right.value) {
            return false;
        }
        boolean right = isSymmetric(root.right);
        boolean left = isSymmetric(root.left);
        if (right == false || left == false) {
            return false;
        }
        return true;
    }
}
