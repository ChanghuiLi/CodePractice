import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    public List<Integer> list = new ArrayList<Integer>();
    public int index;
    public BSTIterator(TreeNode root) {
        middleSearch(root);
        index = 0;
    }
    /** @return the next smallest number */
    public int next() {
        if (index < list.size()) {
            return list.get(index++);
        }
        return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        }
        return false;
    }

    public void middleSearch(TreeNode root) {
        if (root != null) {
            middleSearch(root.left);
            list.add(root.value);
            middleSearch(root.right);
        }
    }
}
