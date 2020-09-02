package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
            if (root != null) {
                res.addFirst(root.value);
                s.push(root);
                root = root.right;
            } else {
                root = s.pop();
                root = root.left;
            }
        }
        return res;
    }

    public List<List<Integer>> levelTravel(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int levelCount = 1;
         while (!q.isEmpty()) {
             List<Integer> tempres = new LinkedList<Integer>();
             int nextLevelCount = 0;
             while (levelCount > 0) {
                 TreeNode temp = q.poll();
                 tempres.add(temp.value);
                 levelCount--;
                 if (temp.left != null) {
                     q.add(temp.left);
                     nextLevelCount++;
                 }
                 if (temp.right != null) {
                     q.add(temp.right);
                     nextLevelCount++;
                 }
             }
             levelCount = nextLevelCount;
             res.add(tempres);
        }
         return res;
    }
}
