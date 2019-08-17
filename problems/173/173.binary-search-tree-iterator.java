/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> path;
    public BSTIterator(TreeNode root) {
        path = new Stack<>();
        preprocess(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode nextNode = path.pop();
        preprocess(nextNode.right);
        return nextNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !path.empty();
    }

    private void preprocess(TreeNode root) {
        while (root != null) {
            path.add(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
