package tree;

public class MaxPath {
    public int Solution(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.value;
        }
        int leftSum = Solution(root.left);
        int rightSum = Solution(root.right);
        if (leftSum < rightSum) {
            return rightSum + root.value;
        } else {
            return leftSum + root.value;
        }
    }
}
