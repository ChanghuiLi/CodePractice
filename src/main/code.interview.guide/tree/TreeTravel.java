package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTravel {
    public List<Integer> midTravel(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (root != null || !s.isEmpty()) {
            if (root == null) {
                root = s.pop();
                res.add(root.value);
                root = root.right;
            } else {
                s.push(root);
                root = root.left;
            }
        }
        return res;
    }

    public List<Integer> preOrderTravel(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                res.addLast(root.value);
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> postOrderTravel(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (root != null || !s.isEmpty()) {
            if(root != null) {
                res.addFirst(root.value);
            }
        }
        return res;
    }
}
