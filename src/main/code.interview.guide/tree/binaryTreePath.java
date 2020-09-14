package tree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String > res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null){
            res.add(""+root.value);
            return res;
        }
        List<String > leftPaths = binaryTreePaths(root.left);
        List<String > rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            res.add(root.value + "->" + path);
        }
        for (String path : rightPaths) {
            res.add(root.value + "->" + path);
        }
        return res;
    }
}
