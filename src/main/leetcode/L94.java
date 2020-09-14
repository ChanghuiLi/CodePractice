import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.pop();
                res.add(root.value);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return res;
    }
}
