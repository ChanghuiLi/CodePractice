package tree;
class ResultType{
    int treeSum;
    int countNode;
    public ResultType(int x1, int x2) {
        this.treeSum = x1;
        this.countNode = x2;
    }
}
public class findAveageSubTree {
    private TreeNode res = null;
    ResultType subTreeRes = new ResultType(0,0);
    public TreeNode findSubTree(TreeNode root) {
        helper(root);
        return res;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0,0);
        }
        ResultType leftRes = helper(root.left);
        ResultType rightRes = helper(root.right);
        ResultType rootRes = new ResultType(
                leftRes.treeSum + rightRes.treeSum + 1,
                leftRes.countNode + rightRes.countNode + 1
        );
        if (res == null ||
                subTreeRes.treeSum/subTreeRes.countNode < rootRes.treeSum/rootRes.countNode) {
            res = root;
            subTreeRes = rootRes;
        }
        return rootRes;
    }
}
